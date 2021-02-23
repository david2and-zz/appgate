package com.appgate.controller;

import com.appgate.service.AppgateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class AppgateController {

    private final AppgateService appgateService;

    public AppgateController(AppgateService appgateService) {
        this.appgateService = appgateService;
    }

    @GetMapping("/process_file")
    public ResponseEntity<String> processFile() throws IOException {
        return new ResponseEntity<>(appgateService.processFile(), HttpStatus.OK);
    }
}
