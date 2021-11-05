package com.gsk.presentation.lucy.form;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lucy/form")
public class XssFormRestController {

    @GetMapping("echo")
    public String echo(@RequestParam String data) {
        return data;
    }
}
