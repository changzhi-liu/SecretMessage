package com.SecureMessage.demo.utils;

import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
@Component
public class SendToServerUtil {

    public String sendGetMessageToServer(String url, HttpServletRequest request) {
        HttpHeaders header = new HttpHeaders();
        List<String> cookies = new ArrayList<>();
        Cookie[] cc = request.getCookies();
        for (int i = 0; i < cc.length; i++) {
            cookies.add(cc[i].getName() + "=" + cc[i].getValue());
        }
        header.put(HttpHeaders.COOKIE, cookies);
        HttpEntity httpEntity = new HttpEntity(header);
        RestTemplate restTemplate = new RestTemplate();
        ;
        ResponseEntity<String> res = restTemplate.exchange(
                url, HttpMethod.GET, httpEntity, String.class);
        return res.getBody();
    }

    public String sendXorMessageToServer(String url, int row, String msg, HttpServletRequest request) {
        HttpHeaders header = new HttpHeaders();
        List<String> cookies = new ArrayList<>();
        Cookie[] cc = request.getCookies();
        for (int i = 0; i < cc.length; i++)
        {
            cookies.add(cc[i].getName() + "=" + cc[i].getValue());
        }
        header.put(HttpHeaders.COOKIE, cookies);
        header.setContentType(MediaType.APPLICATION_JSON);
        String requestBody = "{\"index\": "+String.valueOf(row) + ", \"message\" : \""+msg+"\"}";
        HttpEntity httpEntity = new HttpEntity(requestBody, header);
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> res = restTemplate.exchange(
                url,  HttpMethod.POST,httpEntity, String.class);
        return "res";
    }

}
