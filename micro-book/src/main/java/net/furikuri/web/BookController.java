package net.furikuri.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    @Value("${eureka.instance.metadataMap.instanceId:-}")
    private String name;

    @RequestMapping("/")
    public String simple() {
        return "{ \"name\" : \"" + name + "\"}";
    }
}
