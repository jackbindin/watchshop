package com.example.watchshop.controller;

import java.util.ArrayList;

import com.example.watchshop.model.Watch;
import com.example.watchshop.service.WatchService;
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
    WatchService watchService;

    @PostMapping
    public ResponseEntity<Double> checkout(@RequestBody ArrayList<String> watchIdStrings) throws Exception {
        ArrayList<Watch> watches = watchService.creatWatchListFromIds(watchIdStrings);
        return ResponseEntity.accepted().body(watchService.getTotalPrice(watches));
    }
}
