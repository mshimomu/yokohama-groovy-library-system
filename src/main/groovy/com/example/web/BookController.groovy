package com.example.web

import com.example.service.BookService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

/**
 * Created by Masaya on 2015/12/30.
 */
@Controller
@RequestMapping("books")
class BookController {
    @Autowired
    BookService bookService

    @RequestMapping(method = RequestMethod.GET)
    String list(Model model) {
        def books = bookService.findAll()
        model.addAttribute("books", books)
        return "books/list"
    }
}
