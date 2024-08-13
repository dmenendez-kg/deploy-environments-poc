// package com.backend_team.main_backend.controllers;

// import jakarta.servlet.http.HttpServletRequest;
// import org.springframework.web.bind.annotation.*;

// import java.io.File;
// import java.io.IOException;

// @RestController
// public class VulnerableController {
//     // Vulnerability: Hardcoded credentials
//     private final String SECRET_KEY = "SuperSecretKey";

//     // Insecure endpoint: Command injection vulnerability
//     @GetMapping("/exec")
//     @ResponseBody
//     public String executeCommand(@RequestParam String cmd) {
//         StringBuilder output = new StringBuilder();
//         try {
//             Process process = Runtime.getRuntime().exec(cmd);
//             process.getInputStream().transferTo(System.out);
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//         return "Executed: " + cmd;
//     }

//     // Vulnerability: Path traversal
//     @GetMapping("/readFile")
//     @ResponseBody
//     public String readFile(@RequestParam String fileName) {
//         File file = new File("uploads/" + fileName);
//         return "Reading file: " + file.getAbsolutePath();
//     }

//     // Vulnerability: XSS
//     @PostMapping("/greet")
//     @ResponseBody
//     public String greetUser(@RequestParam String name) {
//         return "Hello, " + name + "!";
//     }

//     // Vulnerability: CSRF
//     @PostMapping("/updateProfile")
//     @ResponseBody
//     public String updateProfile(@RequestParam String username, @RequestParam String bio) {
//         // Simulated profile update
//         return "Profile updated for " + username;
//     }

//     // Vulnerability: Unvalidated redirects
//     @GetMapping("/redirect")
//     public String redirectTo(@RequestParam String url) {
//         return "redirect:" + url;
//     }

//     // Vulnerability: Logging sensitive information
//     @PostMapping("/login")
//     @ResponseBody
//     public String login(HttpServletRequest request, @RequestParam String username, @RequestParam String password) {
//         // Log sensitive information (bad practice)
//         System.out.println("Login attempt: username=" + username + ", password=" + password);
//         if (username.equals("admin") && password.equals("admin123")) {
//             return "Welcome, admin!";
//         } else {
//             return "Invalid credentials.";
//         }
//     }
// }