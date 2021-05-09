package com.SecureMessage.demo.config;
import org.springframework.context.annotation.Bean;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.CookieSerializer;
import org.springframework.session.web.http.DefaultCookieSerializer;

@EnableRedisHttpSession
public class Config {

    @Bean
    public CookieSerializer cookieSerializer() {
        DefaultCookieSerializer serializer = new DefaultCookieSerializer();
        serializer.setUseHttpOnlyCookie(false);
        return serializer;
    }

}
