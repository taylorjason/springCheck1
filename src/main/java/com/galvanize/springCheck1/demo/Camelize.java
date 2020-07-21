package com.galvanize.springCheck1.demo;

        import org.graalvm.compiler.nodes.StructuredGraph;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.RequestParam;
        import org.springframework.web.bind.annotation.RestController;

        import java.util.ArrayList;
        import java.util.Map;

@RestController
public class Camelize {
    @GetMapping("/camelize")
    public String getCamelize(@RequestParam String original, @RequestParam boolean initialCap){
        StringBuilder strBld = new StringBuilder(original.length());
        String[] spltStr= original.split("_");

        if (initialCap) {
           strBld.append(spltStr[0].substring(1,2).toUpperCase() + spltStr[0].substring(2));
        }else {
            strBld.append(spltStr[0].substring(1));
        }

        for (int i = 1; i < spltStr.length; i++){
            strBld.append(spltStr[i].substring(0,1).toUpperCase() + spltStr[i].substring(1));
        }
        System.out.println(strBld.toString());

        return strBld.toString().substring(0,strBld.toString().length()-1);
        }

    }