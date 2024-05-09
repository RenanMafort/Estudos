package com.sereia.renan.learningkotlin.rest.controller

import com.sereia.renan.learningkotlin.rest.model.CustumerModel
import com.sereia.renan.learningkotlin.rest.service.CustumerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/custumer")
class CustumerController(
    var custumerService: CustumerService
) {

    @GetMapping
    fun listAll(@RequestParam name:String?): List<CustumerModel> {
       return custumerService.listAll(name);
    }

    @GetMapping("/{id}")
    fun update(@PathVariable id: Int): CustumerModel {
        return custumerService.update(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: Int, @RequestBody putCustumerRequest: PutCustumerRequest) {
         this.custumerService.update(id,putCustumerRequest);
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int) {
       custumerService.delete(id)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody custumer: CustumerModel) {
        custumerService.create(custumer);
    }

}