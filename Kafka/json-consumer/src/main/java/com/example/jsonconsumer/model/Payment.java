package com.example.jsonconsumer.model;

import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@ToString
public class Payment implements Serializable {

    private Long id;
    private Long idUser;
    private Long idProduct;
    private String cardNumber;


}
