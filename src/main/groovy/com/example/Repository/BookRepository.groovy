package com.example.Repository

import com.example.domain.Book
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.RowMapper
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

import java.sql.ResultSet
import java.sql.SQLException

/**
 * Created by Masaya on 2015/12/30.
 */
@Repository
@Transactional
class BookRepository {
    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate

    private static final RowMapper<Book> bookRowMapper = new RowMapper<Book>() {
        @Override
        Book mapRow(ResultSet rs, int rowNum) throws SQLException {
            def isbn = rs.getString("isbn")
            def bookTitle = rs.getString("book_title")
            def dateOfPublication = rs.getDate("date_of_publication")
            def authorId = rs.getString("author_id")
            def categoryId = rs.getString("category_id")
            return new Book(isbn, bookTitle, dateOfPublication, authorId, categoryId)
        }
    }

    def List<Book> findAll() {
        def books = jdbcTemplate.query('''
SELECT isbn, book_title, date_of_publication, author_id, category_id FROM Books ORDER BY isbn
''', bookRowMapper
        )
        return books
    }


}
