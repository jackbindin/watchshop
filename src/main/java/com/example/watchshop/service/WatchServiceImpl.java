package com.example.watchshop.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

import com.example.watchshop.model.Watch;
import com.example.watchshop.repository.WatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WatchServiceImpl implements WatchService {
    @Autowired
    DiscountService discountService;
    @Autowired
    WatchRepository watchRepository;

    @Override
    public double getTotalPrice(ArrayList<Watch> watches) throws Exception {
        double totalPrice = watches.stream().mapToDouble(Watch::getUnitPrice).sum();

        HashMap<String, ArrayList<Watch>> sortedWatches = sortWatches(watches);
        for (ArrayList<Watch> watchArrayList : sortedWatches.values()) {
            totalPrice -= discountService.calculateDiscount(watchArrayList);
        }

        return totalPrice;
    }

    public ArrayList<Watch> creatWatchListFromIds(ArrayList<String> watchIdStrings) throws Exception {
        ArrayList<Watch> watches = new ArrayList<>();
        ArrayList<Integer> watchIds = parseStringIds(watchIdStrings);
        for (Integer watchId : watchIds) {
            Optional<Watch> watch = watchRepository.findByWatchId(watchId);
            if (watch.isEmpty()) {
                throw new Exception("Watch with id: " + watchId + " does not exist in database.");
            }
            watch.ifPresent(watches::add);
        }
        return watches;
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

    private ArrayList<Integer> parseStringIds(ArrayList<String> watchIdStrings) {
        ArrayList<Integer> watchIds = new ArrayList<>();
        try {
            for (String idString : watchIdStrings) {
                watchIds.add(Integer.parseInt(idString));
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Error parsing watch ids from json");
        }
        return watchIds;
    }
}
