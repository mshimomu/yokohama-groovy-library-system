package com.example.web

import com.example.domain.User
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

    @RequestMapping(method = RequestMethod.GET)
    String list(Model model) {
        def users = new ArrayList<User>()
        users.add(new User(1, "test1", "yokohama"))
        users.add(new User(2, "test2", "yokohama"))
        model.addAttribute("users", users)
        return "users/list"
    }
}
