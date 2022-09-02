package com.example.planergram.service;

import com.example.planergram.repository.PostStayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostStayService {

    @Autowired
    private PostStayRepository postStayRepository;
}
