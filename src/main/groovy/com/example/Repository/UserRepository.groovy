package com.example.Repository

import com.example.domain.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.RowMapper
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

import java.sql.ResultSet
import java.sql.SQLException

/**
 * Created by Masaya on 15/07/19.
 */
@Repository
@Transactional
class UserRepository {
    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate

    private static final RowMapper<User> userRowMapper = new RowMapper<User>() {
        @Override
        User mapRow(ResultSet rs, int rowNum) throws SQLException {
            def userId = rs.getInt("user_id")
            def userName = rs.getString("user_name")
            def userAddress = rs.getString("user_address")
            return new User(userId, userName, userAddress)
        }
    }

    def List<User> findAll() {
        def users = jdbcTemplate.query('''
SELECT user_id, user_name, user_address FROM Users ORDER BY user_id
''', userRowMapper
        )
    }

}
