package com.example.web

import com.example.domain.User
import com.example.service.UserService
import org.springframework.beans.BeanUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.ModelAttribute
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

    @ModelAttribute
    UserForm setUpForm() {
        return new UserForm()
    }

    @RequestMapping(method = RequestMethod.GET)
    String list(Model model) {
        def users = userService.findAll()
        model.addAttribute("users", users)
        return "users/list"
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    String create(@Validated UserForm form, BindingResult result, Model model) {

        if(result.hasErrors()) {
            return list(model)
        }

        def user = new User()
        BeanUtils.copyProperties(form, user)
        userService.create(user)
        return "redirect:/users"
    }
}
