package com.gym_admin.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {
            int statusCode = Integer.parseInt(status.toString());
            model.addAttribute("status", statusCode);

            switch (statusCode) {
                case 400:
                    return "error/error400"; // This must match a file "error400.mustache" in templates/error/
                case 404:
                    return "error/error404"; // This must match a file "error404.mustache" in templates/error/
                default:
                    return "error/error"; // Generic error page
            }
        }
        return "error/error"; // Default error page
    }

    // Optional method for Spring Boot < 2.3 (not required in newer versions)
    public String getErrorPath() {
        return "/error";
    }
}

