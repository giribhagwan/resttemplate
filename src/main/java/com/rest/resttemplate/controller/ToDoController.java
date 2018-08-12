package com.rest.resttemplate.controller;

import com.rest.resttemplate.domain.ToDo;
import com.rest.resttemplate.services.ToDoServices;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableScheduling
public class ToDoController {

    @Autowired
    ToDoServices toDoServices;
    @Autowired
    Logger logger;
/*
0 0/5 * * * ?-----Every 5 mins
0 0/10 * * * ?----Every 10 mins
0 0/15 * * * ?----Every 15 mins


0 0-58/2 * * * ?----Every 1mins--run on even minutes
0 1-59/2 * * * ?----Every 1mins--run on even minutes
0 0-58/4 * * * ?----Every 2mins--run on even minutes
0 2-58/4 * * * ?----Every 2mins--run on odd minutes*/



    @Scheduled(cron = "0 0-58/2 * * * ?")
    @GetMapping("/demo")
    public void save(){
        ToDo toDo=new ToDo("text demo",true);
        logger.info(toDoServices.save(toDo).toString()+"");

    }
}
