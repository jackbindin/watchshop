package com.example.watchshop.service;

import java.util.ArrayList;

import com.example.watchshop.model.Watch;
import org.springframework.stereotype.Service;

@Service
public class DiscountServiceImpl implements DiscountService {
    public double calculateDiscount(ArrayList<Watch> watches) throws Exception {
        double discountAmount = 0;
        if (watches.get(0).getDiscount() != null) {
            double totalPriceBeforeDiscount = watches.stream().mapToDouble(Watch::getUnitPrice).sum();
            int numOfWatches = watches.size();
            int[] discountOffer = parseDiscount(watches.get(0).getDiscount());
            int offerMultiplication = numOfWatches / discountOffer[0];
            int discountedAmount = offerMultiplication * discountOffer[1];
            int discountedWatches = offerMultiplication * discountOffer[0];
            int fullPriceWatches = numOfWatches - discountedWatches;
            double totalPriceAfterDiscount = (watches.get(0).getUnitPrice() * fullPriceWatches) + discountedAmount;
            discountAmount += totalPriceBeforeDiscount - totalPriceAfterDiscount;
        }
        return discountAmount;
    }

    private int[] parseDiscount(String discountString) throws Exception {
        int[] discount = new int[2];
        discountString = discountString.replace(" for ", ",");
        String[] discountStringArray = discountString.split(",");
        try {
            discount[0] = Integer.parseInt(discountStringArray[0]);
            discount[1] = Integer.parseInt(discountStringArray[1]);
        } catch (NumberFormatException e) {
            throw new Exception("Error parsing discount strings: ", e);
        }
        return discount;
    }
}
