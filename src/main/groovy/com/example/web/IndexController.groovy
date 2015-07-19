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
@RequestMapping("/")
class IndexController {
    @RequestMapping(method = RequestMethod.GET)
    String index(Model model) {
        model.addAttribute("message", "こんにちは図書館")
        return "index"
    }

}
