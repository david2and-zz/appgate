package com.appgate.service;

import com.appgate.repository.AppgateRepository;
import com.appgate.repository.model.AppgateEntity;
import com.appgate.util.Utilities;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Slf4j
public class AppgateService {

    private final Utilities fileReaderUtil;
    private final AppgateRepository appgateRepository;

    public AppgateService(Utilities fileReaderUtil, AppgateRepository appgateRepository) {
        this.fileReaderUtil = fileReaderUtil;
        this.appgateRepository = appgateRepository;
    }

    public String processFile() throws IOException {

        log.info("PROCESANDO ARCHIVO");

        List response = fileReaderUtil.getFileData();
        List<AppgateEntity> appgateEntities = new ArrayList<>();
        response.stream().forEach(x->{
            if(appgateEntities.size()<1000){
                appgateEntities.add((AppgateEntity) x);
            }else{
                appgateRepository.saveAll(appgateEntities);
                appgateEntities.clear();
            }
        });
        log.info("PROCESAMIENTO DE ARCHIVO FINALIZADO");

        return "Ok";
    }

    public Collection<AppgateEntity> getDataByIpFront(String ip_front){
        log.info("CONSULTA POR IP : "+ ip_front);
        return appgateRepository.findByIpFront(ip_front);
    }

    public Collection<AppgateEntity> getDataByCountry(String country){
        log.info("CONSULTA POR COUNTRY : "+ country);
        return appgateRepository.findByIpFront(country);
    }
}
