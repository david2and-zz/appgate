package com.appgate.service;

import com.appgate.repository.AppgateRepository;
import com.appgate.repository.model.AppgateEntity;
import com.appgate.util.Utilities;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
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

    public static String decToIp(long ten){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<4;i++){
            sb.insert(0,Long.toString(ten&0xff));
            if(i<3){
                sb.insert(0,'.');
            }
            ten=ten>>8;
        }
        return sb.toString();
    }
}
