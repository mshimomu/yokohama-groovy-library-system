package com.example.domain

import groovy.transform.TupleConstructor

/**
 * Created by Masaya on 2015/12/30.
 */
@TupleConstructor
class Book {
    def isbn
    def bookTitle
    def dateOfPublication
    def authorId
    def categoryId
}
