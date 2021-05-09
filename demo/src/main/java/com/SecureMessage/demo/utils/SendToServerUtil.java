package com.SecureMessage.demo.utils;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
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
}
