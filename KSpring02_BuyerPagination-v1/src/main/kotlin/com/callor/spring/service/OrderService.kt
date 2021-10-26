package com.callor.spring.service

import com.callor.spring.models.Sales
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface OrderService {

    fun selectAll():Array<Sales>
    fun findById(seq:Long):Sales

    fun findByUserId(userid:String):Array<Sales>
    fun findByPname(pname:String):Array<Sales>

    // 날짜범위를 지정하여 검색하기
    fun findByDateDestance(sDate:String, eDate:String):Array<Sales>

    fun insert(sales: Sales):Sales
    fun delete(seq: Long)
    fun update(sales: Sales):Sales
    fun selectAll(pageable: Pageable): Page<Sales>
    fun selectWithPageable(intPage: Int): Array<Sales>
}