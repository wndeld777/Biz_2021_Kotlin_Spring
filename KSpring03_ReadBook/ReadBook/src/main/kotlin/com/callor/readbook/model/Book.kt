package com.callor.readbook.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "tbl_book" , schema = "naraDB")
class Book {
    @Id
    @Column(columnDefinition = "CHAR(4)",
        nullable = false, // not null
        unique = true, // UNIQUE
        name="userid")
    var isbn : String? = null

    @Column(columnDefinition = "VARCHAR(25)", nullable = false)
    var title : String? = null

    @Column(columnDefinition = "VARCHAR(25)", nullable = true)
    var comp : String? = null

    @Column(nullable = true)
    var author : String? = null

    @Column(columnDefinition = "VARCHAR(25)", nullable = true)
    var price : String? = null

}