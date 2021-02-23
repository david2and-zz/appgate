package com.appgate.controller;

import com.appgate.repository.model.AppgateEntity;
import com.appgate.service.AppgateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Collection;

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

    @GetMapping("/get_data")
    public ResponseEntity<Collection<AppgateEntity>> getData(@RequestParam(defaultValue = "") String ip_front,@RequestParam(defaultValue = "test") String country) throws IOException {
        if(!ip_front.equals("")) {
            return new ResponseEntity<>(appgateService.getDataByIpFront(ip_front), HttpStatus.OK);
        }
        if(!country.equals("")) {
            return new ResponseEntity<>(appgateService.getDataByCountry(country), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
}
