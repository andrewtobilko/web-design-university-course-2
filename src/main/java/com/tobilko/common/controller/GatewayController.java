package com.tobilko.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import static com.tobilko.utils.ModelViewConstant.VIEW.INDEX;
import static com.tobilko.utils.RouterConstant.Configuration.ROOT;

/**
 *
 * Created by Andrew Tobilko on 25.02.17.
 *
 */
@Controller
public class GatewayController {

    @GetMapping(ROOT)
    public ModelAndView index() {
        return new ModelAndView(INDEX);
    }

}
