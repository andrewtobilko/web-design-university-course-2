package com.tobilko.page;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import static com.tobilko.utils.ModelViewConstant.MODEL;
import static com.tobilko.utils.ModelViewConstant.VIEW;
import static com.tobilko.utils.RouterConstant.PageConstant.*;

/**
 *
 * Created by Andrew Tobilko on 20.02.17.
 *
 */
@Controller
@RequestMapping(path = PUBLISHED_PAGES_PATH)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PageController {

    private final @NonNull PageService service;

    @GetMapping(path = PAGE_IDENTIFIER_PATH_PARAM)
    public ModelAndView publishPageByIdentifier(@Validated(IdentifierValidator.class)
                                                @PathVariable(IDENTIFIER) String identifier) {
        return new ModelAndView(VIEW.PAGE, MODEL.PAGE, service.getPageByIdentifier(identifier));
    }

}
