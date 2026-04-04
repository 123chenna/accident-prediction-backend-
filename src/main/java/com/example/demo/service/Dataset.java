package com.example.demo.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.AccidentData;
import com.example.demo.repository.AccidentRepository;

@Service
public class Dataset {

    @Autowired
    private AccidentRepository repository;

    public void loadData() {

    	
    	
        try {
        	repository.deleteAll();
        	InputStream is = getClass().getClassLoader().getResourceAsStream("accidents.csv");
            if (is == null) {
                System.out.println("❌ File not found");
                return;
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String line;
            br.readLine(); // skip header

            while ((line = br.readLine()) != null) {

                //String[] data = line.split(",");
            	String[] data = line.split("[,\\t]");
                AccidentData acc = new AccidentData();
                acc.setSpeed(Integer.parseInt(data[0]));
                acc.setWeather(data[1]);
                acc.setRoadType(data[2]);
                acc.setTrafficDensity(data[3]);
                acc.setTimeOfDay((data[4]));
                acc.setRiskLevel(data[5]);   // 🔥 ADD THIS
                repository.save(acc);
            }

            System.out.println("✅ DATA LOADED FROM CSV");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}