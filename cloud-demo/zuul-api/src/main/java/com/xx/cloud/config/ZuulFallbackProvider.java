package com.xx.cloud.config;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Component
public class ZuulFallbackProvider implements FallbackProvider {

    @Override
    public String getRoute() {//匹配微服务名字，*表示匹配所有
        return "*";
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.BAD_REQUEST;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return HttpStatus.BAD_REQUEST.value();
            }

            @Override
            public String getStatusText() throws IOException {
                return HttpStatus.BAD_REQUEST.getReasonPhrase();
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() throws IOException {
                return new ByteArrayInputStream("error".getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.TEXT_HTML);
                return headers;
            }
        };
    }
}
