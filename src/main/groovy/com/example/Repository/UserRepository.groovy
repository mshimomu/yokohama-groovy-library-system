package com.example.Repository

import com.example.domain.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.jdbc.core.namedparam.SqlParameterSource
import org.springframework.jdbc.core.simple.SimpleJdbcInsert
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

import javax.annotation.PostConstruct
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

    SimpleJdbcInsert insert

    @PostConstruct
    public void init() {
        insert = new SimpleJdbcInsert(jdbcTemplate.getJdbcOperations() as JdbcTemplate)
                .withTableName("Users")
                .usingGeneratedKeyColumns("user_id")
    }


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
        return users
    }

    def User findOne(Integer userId) {
        def param = new MapSqlParameterSource().addValue("user_id", userId)
        def user = jdbcTemplate.queryForObject('''
SELECT user_id, user_name, user_address FROM Users WHERE user_id = : user_id
''', param, userRowMapper
        )
        return user
    }

    def User save(User user) {
        SqlParameterSource param = new BeanPropertySqlParameterSource(user)

        if(!user.userId) {
            def key = insert.executeAndReturnKey(param)
            user.userId = key.intValue()
        }
        return user
    }
}
