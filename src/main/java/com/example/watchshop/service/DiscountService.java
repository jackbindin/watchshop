package com.example.watchshop.service;

import java.util.ArrayList;

import com.example.watchshop.model.Watch;

public interface DiscountService {
    double calculateDiscount(ArrayList<Watch> watches) throws Exception;
}
