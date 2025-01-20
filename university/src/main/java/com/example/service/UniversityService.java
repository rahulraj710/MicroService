package com.example.service;

import com.example.pojo.University;

import java.util.List;

public interface UniversityService {
    public List<University> getUniversityList();
    public List<University> getUniversityListByCountry(List<String> countries);
}

