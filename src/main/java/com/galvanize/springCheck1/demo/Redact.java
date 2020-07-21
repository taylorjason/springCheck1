package com.galvanize.springCheck1.demo;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.Map;

@RestController
public class Redact {
    @GetMapping("/redact")
    public String getRedact(@RequestParam MultiValueMap queryString){
        String redact = "*";
        String[] splitStr = queryString.get("original").toString().replace("[","").replace("]","").split(" ");
        LinkedList<String> lst = new LinkedList<>();
        lst = (LinkedList<String>) queryString.get("badWord");

//        StringBuilder strBld = new StringBuilder(splitStr.length);
        String[] output = new String[splitStr.length];

        for (int i =0; i < splitStr.length; i ++) {
            String txt = splitStr[i];
            if(lst.contains(txt)){
                output[i] = redact.repeat(txt.length());
            } else {
                output[i] = txt;
            }
        }
        return String.join(" ",output);
//        return output[0];

    }

}
