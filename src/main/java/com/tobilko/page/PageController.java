package com.tobilko.page;

import com.tobilko.page.entity.Page;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;

import javax.websocket.server.PathParam;

import static com.tobilko.utils.RouterConstant.PageConstant.GET_BY_IDENTIFIER;
import static com.tobilko.utils.RouterConstant.PageConstant.IDENTIFIER;

/**
 *
 * Created by Andrew Tobilko on 20.02.17.
 *
 */
@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PageController {

    private final @NonNull PageService service;

    @GetMapping(path = GET_BY_IDENTIFIER)
    public Page getPageByIdentifier(@Validated(IdentifierValidator.class)
                                    @PathParam(IDENTIFIER) String identifier) {
        return service.getPageByIdentifier(identifier);
    }

}
