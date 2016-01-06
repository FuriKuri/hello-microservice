package net.furikuri.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    private Logger logger = LoggerFactory.getLogger(BookController.class);

    @Value("${eureka.instance.metadataMap.instanceId:-}")
    private String name;

    @RequestMapping("/")
    public String simple() {
        logger.info("Got request");
        return "{ \"name\" : \"" + name + "\"}";
    }
}
