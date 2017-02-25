package com.tobilko.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * Created by Andrew Tobilko on 25.02.17.
 *
 */
@Controller
public class GatewayController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

}
