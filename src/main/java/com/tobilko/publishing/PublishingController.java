package com.tobilko.publishing;

import com.tobilko.publishing.entity.Page;
import com.tobilko.publishing.entity.PageConfiguration;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.tobilko.utils.RouterConstant.PublishingConstant.*;
import static org.springframework.http.HttpStatus.*;

@Controller
@RequestMapping(path = PATH)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PublishingController {

    private final @NonNull PublishingService service;

    @PostMapping(path = CREATE)
    @ResponseStatus(code = OK)
    public Page publishPageFromConfiguration(@Valid PageConfiguration configuration) {
        return service.publishPageFromConfiguration(configuration);
    }

}
