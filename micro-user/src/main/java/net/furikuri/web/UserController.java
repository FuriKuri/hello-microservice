package net.furikuri.web;

import net.furikuri.client.BookClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private BookClient bookClient;

    @RequestMapping("/")
    public String getBookInfo() {
        return bookClient.getBookInfo();
    }
}
