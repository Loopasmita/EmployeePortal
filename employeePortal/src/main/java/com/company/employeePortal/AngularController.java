package com.company.employeePortal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Handles requests for the application home page.
 */
@Controller
public class AngularController {

    public static final String FORWARD_INDEX_HTML = "forward:/index.html";

    @GetMapping(value = {
            "/main"
    })
    public String home() {
        return FORWARD_INDEX_HTML;
    }

}


