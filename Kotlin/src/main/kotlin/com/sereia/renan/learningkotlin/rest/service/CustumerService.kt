package com.sereia.renan.learningkotlin.rest.service

import com.sereia.renan.learningkotlin.rest.controller.PostCustumerRequest
import com.sereia.renan.learningkotlin.rest.controller.PutCustumerRequest
import com.sereia.renan.learningkotlin.rest.model.CustumerModel
import com.sereia.renan.learningkotlin.rest.repository.CustumerRepository
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestBody

@Service
class CustumerService(
    val customerRepository: CustumerRepository
) {
    var custumer = mutableListOf<CustumerModel>()

    fun listAll(name:String?): List<CustumerModel> {
     return customerRepository.findAll().toList();
    }

    fun update(id: Int): CustumerModel {
        return this.custumer.filter { it.id == id }.first();
    }

    fun update(id: Int, @RequestBody putCustumerRequest: PutCustumerRequest) {
        this.custumer.filter { it.id == id }.first().let {
            it.name = putCustumerRequest.name
            it.emai = putCustumerRequest.email
        };
    }

    fun delete(id: Int) {
       customerRepository.deleteById(id)
    }

    fun create(custumer: CustumerModel) {
        customerRepository.save(custumer);

    }
}