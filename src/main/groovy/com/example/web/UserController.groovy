package com.example.web

import com.example.domain.User
import com.example.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

/**
 * Created by Masaya on 15/07/19.
 */
@Controller
@RequestMapping("users")
class UserController {
    @Autowired
    UserService userService

    @RequestMapping(method = RequestMethod.GET)
    String list(Model model) {
        def users = userService.findAll()
        model.addAttribute("users", users)
        return "users/list"
    }
}
