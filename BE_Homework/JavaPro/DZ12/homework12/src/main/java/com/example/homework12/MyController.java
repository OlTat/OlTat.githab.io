package com.example.homework12;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;

@Controller
public class MyController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public MyController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/")
    public String index(Model model) {
        User user = getCurrentUser();

        String login = user.getUsername();
        CustomUser dbUser = userService.findByLogin(login);

        model.addAttribute("login", login);
        model.addAttribute("roles", user.getAuthorities());
        model.addAttribute("admin", isAdmin(user));
        model.addAttribute("email", dbUser.getEmail());
        model.addAttribute("phone", dbUser.getPhone());
        model.addAttribute("address", dbUser.getAddress());
        model.addAttribute("photo", dbUser.getPhoto());

        return "index";
    }

    @PostMapping(value = "/update")
    public String update(@RequestParam(required = false) String email,
                         @RequestParam(required = false) String phone,
                         @RequestParam(required = false) String address,
                         @RequestParam(required = false) MultipartFile photo) {
        User user = getCurrentUser();

        String login = user.getUsername();
        CustomUser dbUser = userService.findByLogin(login);
        String fileName = dbUser.getPhoto();
        // загружаем фото на сервер в виде login_photo.jpg
        if (! photo.isEmpty()) {
            fileName = login + "_photo.jpg";
            uploadPhoto(photo, fileName);
        }

        userService.updateUser(login, email, phone, address, fileName);

        return "redirect:/";
    }

    @PostMapping(value = "/newuser")
    public String update(@RequestParam String login,
                         @RequestParam String password,
                         @RequestParam(required = false) String email,
                         @RequestParam(required = false) String phone,
                         @RequestParam(required = false) String address,
                         @RequestParam(required = false) MultipartFile photo,
                         Model model) {
        if (password.length() < 8) {
            model.addAttribute("minlength", true);
            return "register";
        }
        String passHash = passwordEncoder.encode(password);

        String fileName = "";
        if (! photo.isEmpty()) { fileName = login + "_photo.jpg";}

        if ( ! userService.addUser(login, passHash, UserRole.USER, email, phone, address, fileName)) {
            model.addAttribute("exists", true);
            model.addAttribute("login", login);
            return "register";
        }

        // загружаем фото на сервер в виде login_photo.jpg
        if (! fileName.equals("") && ! photo.isEmpty()) {
            uploadPhoto(photo, fileName);
        }

        return "redirect:/";
    }

    private void uploadPhoto(MultipartFile file, String filename) {
        try {
            // Сохраняем файл на сервере
            byte[] bytes = file.getBytes();
            Path path = Paths.get("./target/classes/META-INF/resources/uploads/" + filename);
            Files.write(path, bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PostMapping(value = "/delete")
    public String delete(@RequestParam(name = "toDelete[]", required = false) List<Long> ids,
                         Model model) {
        userService.deleteUsers(ids);
        model.addAttribute("users", userService.getAllUsers());

        return "admin";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/uploadFile")
    public String upload() { return "upload"; }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ROLE_ADMIN')") // SpEL !!!
    public String admin(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "admin";
    }

    @GetMapping("/unauthorized")
    public String unauthorized(Model model) {
        User user = getCurrentUser();
        model.addAttribute("login", user.getUsername());
        return "unauthorized";
    }

    // ----

    private User getCurrentUser() {
        return (User) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
    }

    private boolean isAdmin(User user) {
        Collection<GrantedAuthority> roles = user.getAuthorities();

        for (GrantedAuthority auth : roles) {
            if ("ROLE_ADMIN".equals(auth.getAuthority()))
                return true;
        }

        return false;
    }
}
