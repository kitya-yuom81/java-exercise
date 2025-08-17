package exceptionpro;

import java.nio.file.Path;
import java.util.List;

public class MainApp {

    // ---- Custom Exceptions (package-private so we keep 2 files only) ----
    // Checked: bad data in the file
    static class DataFormatException extends Exception {
        private final int lineNumber;
        public DataFormatException(String message, int lineNumber, Throwable cause) {
            super(message, cause);
            this.lineNumber = lineNumber;
        }
        public DataFormatException(String message, int lineNumber) {
            super(message);
            this.lineNumber = lineNumber;
        }
        public int getLineNumber() { return lineNumber; }
    }

    // Checked: business rule: user not found
    static class UserNotFoundException extends Exception {
        public UserNotFoundException(String message) { super(message); }
    }

    // Unchecked: configuration/environment issue
    static class AppConfigException extends RuntimeException {
        public AppConfigException(String message, Throwable cause) { super(message, cause); }
        public AppConfigException(String message) { super(message); }
    }

    // ---- Main demo ----
    public static void main(String[] args) {
        // Arg 0 = path to CSV file, fallback to default
        String csvPath = (args.length > 0) ? args[0] : "data/users.csv";

        UserService service = new UserService();

        try {
            System.out.println("Loading users from: " + csvPath);
            List<User> users = service.loadUsers(Path.of(csvPath));   // may throw checked exceptions
            System.out.println("Loaded " + users.size() + " users.");

            // Try to find a specific user (will throw if missing)
            String searchEmail = "missing@example.com";
            User u = service.findByEmail(users, searchEmail);          // may throw UserNotFoundException
            System.out.println("Found: " + u);

        } catch (DataFormatException e) { // Specific data errors with line number
            System.out.println("❌ Bad data at line " + e.getLineNumber() + ": " + e.getMessage());
        } catch (UserNotFoundException e) { // Business-level error
            System.out.println("❌ " + e.getMessage());
        } catch (AppConfigException e) { // Unchecked but we still demonstrate catching it
            System.out.println("❌ Configuration error: " + e.getMessage());
            if (e.getCause() != null) {
                System.out.println("   Root cause: " + e.getCause());
            }
        } catch (Exception e) { // Last-resort safety net
            System.out.println("❌ Unexpected error: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        } finally {
            // Always runs — good for cleanup/logging
            System.out.println("➡️  Finished attempt to load users (success or fail).");
        }

        System.out.println("Program continues...");
    }
}

