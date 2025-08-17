package exceptionpro;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

class User {
    final int id;
    final String name;
    final String email;

    User(int id, String name, String email) {
        this.id = id; this.name = name; this.email = email;
    }
    @Override public String toString() {
        return "User{id=" + id + ", name='" + name + "', email='" + email + "'}";
    }
}

public class UserService {

    /**
     * Load users from a CSV file (id,name,email).
     * Lines are validated; bad lines throw DataFormatException with line number.
     * If the file can’t be opened, wrap IOException into AppConfigException (unchecked).
     */
    public List<User> loadUsers(Path csvPath)
            throws MainApp.DataFormatException {
        List<User> list = new ArrayList<>();

        // try-with-resources ensures the file is closed automatically
        try (BufferedReader br = Files.newBufferedReader(csvPath)) {
            String line;
            int lineNo = 0;

            while ((line = br.readLine()) != null) {
                lineNo++;

                // Skip optional header if present
                if (lineNo == 1 && line.toLowerCase().startsWith("id,")) {
                    continue;
                }

                String[] parts = line.split(",");
                if (parts.length != 3) {
                    throw new MainApp.DataFormatException("Expected 3 columns, got " + parts.length, lineNo);
                }

                // Trim fields
                String idStr = parts[0].trim();
                String name = parts[1].trim();
                String email = parts[2].trim();

                // Validate fields and rethrow with cause when useful
                int id;
                try {
                    id = Integer.parseInt(idStr);
                } catch (NumberFormatException nfe) {
                    throw new MainApp.DataFormatException("ID must be an integer: '" + idStr + "'", lineNo, nfe);
                }

                if (name.isEmpty()) {
                    throw new MainApp.DataFormatException("Name cannot be empty", lineNo);
                }
                if (!email.contains("@")) {
                    throw new MainApp.DataFormatException("Invalid email: '" + email + "'", lineNo);
                }

                list.add(new User(id, name, email));
            }

        } catch (IOException io) {
            // Wrap environment/config I/O errors as unchecked to indicate setup issues
            throw new MainApp.AppConfigException("Cannot read file: " + csvPath, io);
        }

        if (list.isEmpty()) {
            // Business decision: empty file is considered invalid data here
            throw new MainApp.DataFormatException("No user rows found", 0);
        }

        return list;
    }

    /**
     * Find a user by email. Throws a checked exception if not found.
     */
    public User findByEmail(List<User> users, String email)
            throws MainApp.UserNotFoundException {
        return users.stream()
                .filter(u -> u.email.equalsIgnoreCase(email))
                .findFirst()
                .orElseThrow(() -> new MainApp.UserNotFoundException(
                        "User with email '" + email + "' not found"));
    }
}
