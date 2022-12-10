package com.example.watchshop.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.watchshop.model.Watch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WatchServiceImpl implements WatchService {
    @Autowired
    DiscountService discountService;

    @Override
    public double getTotalPrice(ArrayList<Watch> watches) throws Exception {
        double totalPrice = watches.stream().mapToDouble(Watch::getUnitPrice).sum();

        HashMap<String, ArrayList<Watch>> sortedWatches = sortWatches(watches);
        for (ArrayList<Watch> watchArrayList : sortedWatches.values()) {
            totalPrice -= discountService.calculateDiscount(watchArrayList);
        }

        return totalPrice;
    }

    private HashMap<String, ArrayList<Watch>> sortWatches(ArrayList<Watch> watches) {
        HashMap<String, ArrayList<Watch>> sortedWatches = new HashMap<>();
        for (Watch watch : watches) {
            if (sortedWatches.containsKey(watch.getWatchName())) {
                sortedWatches.get(watch.getWatchName()).add(watch);
            } else {
                ArrayList<Watch> newWatchList = new ArrayList<>();
                newWatchList.add(watch);
                sortedWatches.put(watch.getWatchName(), newWatchList);
            }
        }
        return sortedWatches;
    }
}
