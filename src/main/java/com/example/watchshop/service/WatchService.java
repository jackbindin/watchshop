package com.example.watchshop.service;

import java.util.ArrayList;

import com.example.watchshop.model.Watch;

public interface WatchService {
    double getTotalPrice(ArrayList<Watch> watches) throws Exception;
}
