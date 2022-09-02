package com.example.planergram.controller;

import com.example.planergram.service.PostStayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostStayController {

    @Autowired
    private PostStayService postStayService;
}
