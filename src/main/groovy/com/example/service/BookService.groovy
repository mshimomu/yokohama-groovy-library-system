package com.example.service

import com.example.Repository.BookRepository
import com.example.domain.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * Created by Masaya on 2015/12/30.
 */
@Service
@Transactional
class BookService {

    @Autowired
    BookRepository bookRepository

    def List<User> findAll() {
        return bookRepository.findAll()
    }

}
