package com.galvanize.springCheck1.demo;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;

@RestController
public class Encode {
    @PostMapping("/encode")
    public String getEncode(@RequestParam String message, @RequestParam String key){
        String alph = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder strBld = new StringBuilder(message.length());
        for (String ltr : message.split("")){
            if (ltr.equals(" ")) {
                System.out.println("ltr is " + ltr);
                strBld.append(ltr);
            } else {
                int idx = alph.indexOf(ltr);
                System.out.println("ltr is " + ltr + " at idx " + idx);
                strBld.append(key.substring(idx, idx + 1));
            }
        }
        return strBld.toString();
    }

}
