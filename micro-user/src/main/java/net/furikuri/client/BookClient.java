package net.furikuri.client;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BookClient {
    private RestTemplate restTemplate;
    private LoadBalancerClient loadBalancer;

    @Autowired
    public BookClient(LoadBalancerClient loadBalancer) {
        this.restTemplate = new RestTemplate();
        this.loadBalancer = loadBalancer;
    }

    @HystrixCommand(
            fallbackMethod = "bookInfoDummy",
            commandProperties = {
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "2") })
    public String getBookInfo() {
        ServiceInstance instance = loadBalancer.choose("BOOK");
        String url = "http://" + instance.getHost() + ":" + instance.getPort();
        return restTemplate.getForObject(url, String.class);
    }

    private String bookInfoDummy() {
        return "dummy";
    }

}
