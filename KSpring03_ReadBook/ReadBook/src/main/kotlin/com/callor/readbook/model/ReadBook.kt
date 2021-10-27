package com.callor.readbook.model

import javax.persistence.*

@Entity
@Table(name = "tbl_readbook", schema = "naradb")
data class ReadBook {

    @Id
    @Column(columnDefinition = "BIGINT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var seq:Long? = null

    @Column(columnDefinition = "VARCHAR(25)", nullable = false)
    var isbn : String? = null

    @Column(columnDefinition = "VARCHAR(25)", nullable = true)
    var rdate : String? = null

    @Column(nullable = true)
    var stime : String? = null

    @Column(columnDefinition = "VARCHAR(25)", nullable = true)
    var etime : String? = null

    @Column(nullable = true)
    var rating : String? = null

    @Column(columnDefinition = "VARCHAR(25)", nullable = true)
    var comment : String? = null
}