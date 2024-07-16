package com.mycompany.app;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        // Introducing some intentional issues
        System.out.println("Hello World!");

        // 1. Null pointer dereference
        String nullString = null;
        // System.out.println(nullString.length()); // Commented out to avoid NullPointerException

        // 2. Unused variable
        int unusedVariable = 10;
        // Commented out to avoid unused variable warning
        // int unusedVariable = 10;

        // 3. Infinite loop
        // Commented out to avoid infinite loop
        /*
        while (true) {
            // Do something
        }
        */

        // 4. SQL Injection vulnerability (intentional example, not a real SQLi)
        String userInput = args.length > 0 ? args[0] : "default";
        String sqlQuery = "SELECT * FROM users WHERE username = '" + userInput + "'";

        // 5. Resource leak
        List<Integer> list = new ArrayList<>();
        // Not closing the list, potential resource leak

        // 6. Hardcoded password (intentional example)
        String password = "admin123";

        // 7. Cross-site scripting (XSS) vulnerability (intentional example)
        String userInput2 = "<script>alert('XSS attack!');</script>";
        System.out.println(userInput2);

        // 8. Unhandled exception
        try {
            int result = 1 / 0; // Division by zero
        } catch (Exception e) {
            // No handling of the exception
        }
    }
}
