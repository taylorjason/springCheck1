package com.galvanize.springCheck1.demo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class sed {
    @PostMapping("/s/{find}/{replacement}")
    public String postSed (@PathVariable String find, @PathVariable String replacement, @RequestParam String body) {
        return body.replaceAll(find, replacement);
    }
}
