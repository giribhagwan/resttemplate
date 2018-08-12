package com.rest.resttemplate.services.impl;

import com.rest.resttemplate.domain.ToDo;
import com.rest.resttemplate.services.ToDoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class ToDoServicesImpl implements ToDoServices {


    @Autowired
    RestTemplate restTemplate;

    final String ROOT_URI = "http://localhost:8080/todo";
    @Override
    public ToDo save(ToDo toDo)  {
        ToDo result = null;
        try {
            result = restTemplate.postForObject( ROOT_URI, toDo, ToDo.class);
        } catch (RestClientException e) {
            e.printStackTrace();
        }
        return result;
    }
}
