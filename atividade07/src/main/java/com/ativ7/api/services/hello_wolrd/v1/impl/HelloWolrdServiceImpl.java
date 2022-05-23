package com.ativ7.api.services.hello_wolrd.v1.impl;

import com.ativ7.api.services.hello_wolrd.v1.HelloWolrdService;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HelloWolrdServiceImpl implements HelloWolrdService{

    @Override
    public String helloWolrd() {
        String ola = "Olá gentem";
        return ola;
    }
}
