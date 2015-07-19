package com.example.service

import com.example.Repository.UserRepository
import com.example.domain.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * Created by Masaya on 15/07/19.
 */
@Service
@Transactional
class UserService {

    @Autowired
    UserRepository userRepository

    def List<User> findAll() {
        return userRepository.findAll()
    }
}
