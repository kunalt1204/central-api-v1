package com.bms.central_api_v1.integration;

import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Map;

public abstract class RestAPI {

    public String addQueryParams(String url,Map<String,String> queryParams){

        if(queryParams.isEmpty()){
            return url;
        }

        url += "?";

        int count = 1;

        for(String key : queryParams.keySet()){
            url += key;
            if(count< queryParams.size()){
                url += "&";
            }
            count++;
        }
        return url;
    }

    public Object makePostCall(String apiBaseUrl, String apiEndPoint, Object requestBody, Map<String,String> queryParams){

        String url = apiBaseUrl+apiEndPoint;

        url = this.addQueryParams(url,queryParams);
        URI finalUrl = URI.create(url);

        RequestEntity<Class<Object>> request = RequestEntity.post(finalUrl).body(Object.class);

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Object> responseEntity = restTemplate.exchange(finalUrl, HttpMethod.POST,request, Object.class);
        return responseEntity.getBody();

    }

    public Object makeGetCall(String apiEndPoint,String apiBaseUrl, Map<String,String> queryParams,Object responseBody){

        String url = apiBaseUrl + apiEndPoint;

        url = this.addQueryParams(url,queryParams);
        //URI finalUrl = URI.create(url);

        RequestEntity<Void> request = RequestEntity.get(url).build();

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Object> response = restTemplate.exchange(url,HttpMethod.GET,request, Object.class);

        return response.getBody();

    }

    public Object makePutCall(String apiBaseUrl, String apiEndPoint, Object requestBody, Map<String,String> queryParams){
        String url = apiBaseUrl+apiEndPoint;

        url = this.addQueryParams(url,queryParams);
        URI finalUrl = URI.create(url);

        RequestEntity<Class<Object>> request = RequestEntity.post(finalUrl).body(Object.class);

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Object> responseEntity = restTemplate.exchange(finalUrl, HttpMethod.POST,request, Object.class);
        return responseEntity.getBody();

    }

    public Object makeDeleteCall(String apiBaseUrl,String apiEndPoint,Map<String,String> queryParams,Object requestBody){

        String url = apiBaseUrl+apiEndPoint;
        url = this.addQueryParams(url,queryParams);

        RequestEntity<Void> request = RequestEntity.delete(url).build();

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Object> responseEntity = restTemplate.exchange(url, HttpMethod.DELETE,request, Object.class);

        return responseEntity.getBody();

    }





}
