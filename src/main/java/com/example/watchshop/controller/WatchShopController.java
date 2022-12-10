package com.example.watchshop.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Optional;

import com.example.watchshop.model.Watch;
import com.example.watchshop.repository.WatchRepository;
import com.example.watchshop.service.WatchService;
import com.example.watchshop.utils.WatchUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/checkout")
public class WatchShopController {
    @Autowired
    WatchRepository watchRepository;
    @Autowired
    WatchService watchService;
    @Autowired
    WatchUtil watchUtil;

    @PostMapping
    public ResponseEntity<Double> checkout(@RequestBody ArrayList<String> watchIdStrings) throws Exception {
        ArrayList<Watch> watches = new ArrayList<>();
        ArrayList<Integer> watchIds = watchUtil.parseStringIds(watchIdStrings);
        for (Integer watchId : watchIds) {
            Optional<Watch> watch = watchRepository.findByWatchId(watchId);
            if (watch.isEmpty()) {
                throw new Exception("Watch with id: " + watchId + " does not exist in database.");
            }
            watch.ifPresent(watches::add);
        }
        return ResponseEntity.accepted().body(watchService.getTotalPrice(watches));
    }
}
