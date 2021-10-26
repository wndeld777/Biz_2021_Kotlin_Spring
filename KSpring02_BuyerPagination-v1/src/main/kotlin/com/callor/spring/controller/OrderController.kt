package com.callor.spring.controller

import com.callor.spring.ConfigData
import com.callor.spring.config.logger
import com.callor.spring.models.Buyer
import com.callor.spring.service.BuyerService
import com.callor.spring.service.OrderService
import com.callor.spring.service.impl.BuyerServiceImplV1
import org.hibernate.criterion.Order
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping(value = ["order"])
class OrderController(val orService:OrderService) {

    // localhost:8080/order/ 또는
    // localhost:8080/order 요청을 모두 수용["","/"]
    @RequestMapping(value = ["","/"],method=[RequestMethod.GET])
    fun list(model: Model,pageable: Pageable):String{
        val salesList = orService.selectAll(pageable)
        model["SALES"] = salesList
        return "order/list"
    }

    @RequestMapping(value = ["/sub_page"],method = [RequestMethod.GET])
    fun subPage(model: Model, pageable: Pageable):String{
        val orderList = orService.selectAll(pageable)
        model["SALES"]= orderList
        return "order/sub_page"
    }
    @RequestMapping(value = ["/{page}"],method = [RequestMethod.GET])
    fun list(model: Model,@PathVariable("page") page:String="0"):String{
        val intPage = try{
            page.toInt()
        }catch (e:Exception){
            logger().debug("매개변수 오류")
            0
        }
        val orderList = orService.selectWithPageable(intPage)
        model["SALES"] = orderList
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