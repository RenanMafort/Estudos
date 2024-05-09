package com.sereia.renan.learningkotlin.rest.repository

import com.sereia.renan.learningkotlin.rest.model.CustumerModel
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CustumerRepository : CrudRepository<CustumerModel, Int>{
}