package com.example;

import com.example.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.sql.ResultSet;
import java.sql.SQLException;

@EnableAutoConfiguration
public class App implements CommandLineRunner{
    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;


    public static void main( String[] args ) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {

        String sql = "SELECT user_id, user_name, user_address FROM Users WHERE user_id = :user_id;";
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("user_id", 2);
        User result = jdbcTemplate.queryForObject(sql, param,
                (resultSet, rowNum) -> new User(resultSet.getInt("user_id"),
                        resultSet.getString("user_name"),
                        resultSet.getString("user_address")));


        String sql2 = "SELECT b.user_name, c.book_title FROM Books_Out_On_Loan a " +
                "LEFT OUTER JOIN Users b ON a.user_id = b.user_id " +
                "LEFT OUTER JOIN Books c ON a.isbn = c.isbn " +
                "WHERE b.user_id = :user_id;";
        SqlParameterSource param2 = new MapSqlParameterSource()
                .addValue("user_id", 1);
        String result2 = jdbcTemplate.queryForObject(sql2, param2,
                (resultSet, rowNum) -> resultSet.getString("user_name") + resultSet.getString("book_title"));



        System.out.println("result = " + result.getUserName() + result.getUserAddress());
        System.out.println("result2 = " + result2);
    }
}
