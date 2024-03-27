package sku.lesson.blog.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import sku.lesson.blog.dto.AddUserRequest;
import sku.lesson.blog.service.UserService;

@RequiredArgsConstructor
@Controller
public class UserApiController {
    private final UserService userService;


    @PostMapping("/user")
    public String signup(AddUserRequest request){
        userService.save(request);
        return "redirect:/login";
    }
}
