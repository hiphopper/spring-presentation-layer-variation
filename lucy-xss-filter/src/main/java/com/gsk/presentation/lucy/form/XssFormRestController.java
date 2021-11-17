package com.gsk.presentation.lucy.form;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lucy/form")
public class XssFormRestController {

    @GetMapping("echo/search")
    public String echo(@RequestParam String data,
                       @RequestParam(required = false) String globalParameter) {
        return "data: " + data + ", globalParameter: " + globalParameter;
    }

    @PostMapping("echo")
    public String postEcho(@RequestParam String data,
                       @RequestParam(required = false) String globalParameter) {
        return "data: " + data + ", globalParameter: " + globalParameter;
    }
}
