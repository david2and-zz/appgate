package com.appgate.service;

import com.appgate.repository.AppgateRepository;
import com.appgate.repository.model.AppgateEntity;
import com.appgate.util.Utilities;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class AppgateService {

    private final Utilities fileReaderUtil;
    private final AppgateRepository appgateRepository;

    public AppgateService(Utilities fileReaderUtil, AppgateRepository appgateRepository) {
        this.fileReaderUtil = fileReaderUtil;
        this.appgateRepository = appgateRepository;
    }

    public String processFile() throws IOException {

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

        return "Ok";
    }

    public Collection<AppgateEntity> getDataByIpFront(String ip_front){
        return appgateRepository.findByIpFront(ip_front);
    }

    public Collection<AppgateEntity> getDataByCountry(String ip_front){
        return appgateRepository.findByIpFront(ip_front);
    }
}
