package com.tobilko.publishing;

import com.tobilko.page.entity.Page;
import com.tobilko.page.entity.PageConfiguration;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import static com.tobilko.utils.RouterConstant.PublishingConstant.CREATE;
import static com.tobilko.utils.RouterConstant.PublishingConstant.PATH;
import static org.springframework.http.HttpStatus.OK;

/**
 *
 * Created by Andrew Tobilko on 20.02.17.
 *
 */
@Controller
@RequestMapping(path = PATH)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PublishingController {

    private final @NonNull PublishingService service;

    @PostMapping(path = CREATE)
    @ResponseStatus(code = OK)
    public Page publishPageFromConfiguration(PageConfiguration configuration) {
        return service.publishPageFromConfiguration(configuration);
    }

}
