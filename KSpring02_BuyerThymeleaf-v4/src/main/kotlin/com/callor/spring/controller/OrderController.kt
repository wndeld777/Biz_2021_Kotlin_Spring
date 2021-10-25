package com.callor.spring.controller

import com.callor.spring.ConfigData
import com.callor.spring.models.Buyer
import com.callor.spring.service.BuyerService
import com.callor.spring.service.OrderService
import com.callor.spring.service.impl.BuyerServiceImplV1
import org.hibernate.criterion.Order
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

@Controller
@RequestMapping(value = ["order"])
class OrderController(val orService:OrderService) {

    // localhost:8080/order/ 또는
    // localhost:8080/order 요청을 모두 수용["","/"]
    @RequestMapping(value = ["","/"],method=[RequestMethod.GET])
    fun list(model: Model):String{
        val salesList = orService.selectAll()
        model["SALES"] = salesList
        return "order/list"
    }


    // localhost:8080/order/detail
    @RequestMapping(value=["/detail"],method=[RequestMethod.GET])
    fun detail( model:Model, @RequestParam("seq") seq:Long):String {

        val sales = orService.findById(seq)
        model["SALE"] = sales
        return "order/detail" // detail.html 을 열어라

    }


}