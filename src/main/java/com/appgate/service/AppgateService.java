package com.appgate.service;

import com.appgate.util.Utilities;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class AppgateService {

    private final Utilities fileReaderUtil;

    public AppgateService(Utilities fileReaderUtil) {
        this.fileReaderUtil = fileReaderUtil;
    }

    public String processFile() throws IOException {
        List response = fileReaderUtil.getFileData();
        response.stream().forEach(x->{
            System.out.println(x);
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
