package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration
public class App {

    public static void main( String[] args ) {
        SpringApplication.run(App.class, args);
    }

// エラー出る
//        String sql2 = "SELECT b.user_name, c.book_title FROM Books_Out_On_Loan a " +
//                "LEFT OUTER JOIN Users b ON a.user_id = b.user_id " +
//                "LEFT OUTER JOIN Books c ON a.isbn = c.isbn " +
//                "WHERE b.user_id = :user_id;";
//        SqlParameterSource param2 = new MapSqlParameterSource()
//                .addValue("user_id", 1);
//        String result2 = jdbcTemplate.queryForObject(sql2, param2,
//                (resultSet, rowNum) -> resultSet.getString("user_name") + resultSet.getString("book_title"));
//        System.out.println("result2 = " + result2);

}
