package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.AccidentData;
import com.example.demo.repository.AccidentRepository;

import java.util.List;

@Service
public class Prediction {

    @Autowired
    private AccidentRepository repository;

    public String predict(AccidentData input) {

        List<AccidentData> dataset = repository.findAll();

        if (dataset.isEmpty()) {
            return "Dataset is empty. Please load data first.";
        }

        int maxScore = -1;
        String result = "LOW";

        for (AccidentData d : dataset) {

            int score = 0;

            if (Math.abs(d.getSpeed() - input.getSpeed()) <= 10) score++;

            if (d.getWeather() != null && input.getWeather() != null &&
                d.getWeather().equalsIgnoreCase(input.getWeather())) score++;

            if (d.getRoadType() != null && input.getRoadType() != null &&
                d.getRoadType().equalsIgnoreCase(input.getRoadType())) score++;

            if (d.getTrafficDensity() != null && input.getTrafficDensity() != null &&
                d.getTrafficDensity().equalsIgnoreCase(input.getTrafficDensity())) score++;

            if (d.getTimeOfDay() != null && input.getTimeOfDay() != null &&
                d.getTimeOfDay().equalsIgnoreCase(input.getTimeOfDay())) score++;

            if (score > maxScore) {
                maxScore = score;

                if (d.getRiskLevel() != null && !d.getRiskLevel().isEmpty()) {
                    result = d.getRiskLevel().trim();
                } else {
                    result = "LOW";
                }
            }
        }

        if (result == null || result.isEmpty()) {
            result = "LOW";
        }

        System.out.println("✅ Best score: " + maxScore);
        System.out.println("✅ Prediction: " + result);

        return result;
    }}