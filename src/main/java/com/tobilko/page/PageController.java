package com.tobilko.page;

import com.tobilko.page.entity.Page;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

import static com.tobilko.utils.RouterConstant.PageConstant.*;

/**
 *
 * Created by Andrew Tobilko on 20.02.17.
 *
 */
@RestController
@RequestMapping(path = PUBLISHED_PAGES_PATH)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PageController {

    private final @NonNull PageService service;

    @GetMapping(path = PAGE_IDENTIFIER_PATH_PARAM)
    public String publishPageByIdentifier(@Validated(IdentifierValidator.class)
                                          @PathParam(IDENTIFIER) String identifier) {
        Page page = service.getPageByIdentifier(identifier);
        // todo : template the given page
        return null;
    }

}
