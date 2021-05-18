package com.costinel.Workshop.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WorkshopService implements GenericWelcomeService {

    @Override
    public List<String> getWelcomeMessage(String name) {
        List<String> myList = new ArrayList<>();
        myList.add("Hello ");
        myList.add(name);
        myList.add(", Welcome to the Workshop");
        return myList;
    }
}
