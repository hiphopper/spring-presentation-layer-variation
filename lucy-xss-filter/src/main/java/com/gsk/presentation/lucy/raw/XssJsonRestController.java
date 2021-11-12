package com.gsk.presentation.lucy.raw;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("lucy/json")
public class XssJsonRestController {

    @PostMapping("echo")
    public String echo(@RequestBody Data data) {
        return "data.param: " + data.getParam();
    }

    @Getter
    @Setter
    static class Data {
        private String param;
    }
}
