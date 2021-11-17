package com.gsk.presentation.lucy.form;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lucy/form")
public class XssFormController {

    @RequestMapping("echo")
    public String echoForm() {
        return "form/echo";
    }
}
