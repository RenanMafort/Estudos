package com.sereia.renan.learningkotlin.rest.extension

import com.sereia.renan.learningkotlin.rest.controller.PostCustumerRequest
import com.sereia.renan.learningkotlin.rest.model.CustumerModel

fun PostCustumerRequest.toModelCustumer(): CustumerModel{
    return CustumerModel(null,name = this.name, emai = this.email)
}


fun String.toFirst3Char(): String{
    return this.substring(0,3);
}

fun String.printMyMane(value: String){
    return print(value);
}