package com.example.demo.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.AccidentData;
import com.example.demo.service.Prediction;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://127.0.0.1:5500")   
public class AccidentController {

    @Autowired
    private Prediction ps;

    @PostMapping("/predict")
    public String predict(@RequestBody AccidentData data) {
        return ps.predict(data);
    }
}