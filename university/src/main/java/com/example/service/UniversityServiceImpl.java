package com.example.service;

import com.example.pojo.University;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class UniversityServiceImpl implements UniversityService {

    @Autowired
    public RestTemplate restTemplate;

    @Value("${api.url}")
    private String apiUrl;

    @Override
    public List<University> getUniversityListByCountry(List<String> countries){
        List<University> allUniversities = new ArrayList<>();
        for (String country : countries){
            List<University> universities = restTemplate.getForObject(apiUrl + "?country=" + country, List.class);
            if(universities != null)
                allUniversities.addAll(universities);
        }
        return allUniversities;
    }

    @Override
    public List<University> getUniversityList(){
        return restTemplate.getForObject(apiUrl, List.class);
    }
}

