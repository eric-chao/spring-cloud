package com.example.spring.feign.controller;

import com.example.spring.feign.service.HelloFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloFeignController {

    @Autowired
    private HelloFeignService helloFeignService;

    /**
     * e.g http://localhost:3030/search/github/?str=spring-cloud-dubbo
     * @param queryStr
     * @return
     */
    @GetMapping(value = "/search/github")
    public ResponseEntity<byte[]> searchGitHubRepoByStr(@RequestParam("str") String queryStr) {
        return helloFeignService.searchRepo(queryStr);
    }

}
