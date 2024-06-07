package com.sereia.renan.hrapigatewayzuul.handler;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
@SuppressWarnings("deprecation")

public class CustomizeHandler implements ErrorController {
    public String error() {
        // handle error
        // ..
        return "";
    }

    public String getErrorPath() {
        return null;
    }


}
