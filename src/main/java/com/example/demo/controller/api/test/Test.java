package com.example.demo.controller.api.test;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.ServiceTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class Test {
    @Autowired
    private ServiceTest servicetest;
    @GetMapping("name")
    public String servertest() {
          String name = "name";
          String yellow = servicetest.name();
          return "hi "+name+"  "+yellow;
    }
    

}
