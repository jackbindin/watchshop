package com.example.watchshop.service;

import java.util.ArrayList;

import com.example.watchshop.model.Watch;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WatchServiceTest {
    @Autowired
    WatchService watchService;

    @Test
    public void testCalculateTotalPrice() throws Exception {
        ArrayList<Watch> watches = new ArrayList<>();
        //100 total
        watches.add(new Watch(1, "rolex", 20, "3 for 40"));
        watches.add(new Watch(1, "rolex", 20, "3 for 40"));
        watches.add(new Watch(1, "rolex", 20, "3 for 40"));
        watches.add(new Watch(1, "rolex", 20, "3 for 40"));
        watches.add(new Watch(1, "rolex", 20, "3 for 40"));
        watches.add(new Watch(1, "rolex", 20, "3 for 40"));
        watches.add(new Watch(1, "rolex", 20, "3 for 40"));
        //120 total
        watches.add(new Watch(2, "appleWatch", 40, "6 for 200"));
        watches.add(new Watch(2, "appleWatch", 40, "6 for 200"));
        watches.add(new Watch(2, "appleWatch", 40, "6 for 200"));
        watches.add(new Watch(2, "appleWatch", 40, "6 for 200"));
        watches.add(new Watch(2, "appleWatch", 40, "6 for 200"));
        watches.add(new Watch(2, "appleWatch", 40, "6 for 200"));
        assertEquals(300, watchService.getTotalPrice(watches));
    }

    @Test
    public void testGettingWatchById() throws Exception {
        ArrayList<String> watchIds = new ArrayList<>();
        watchIds.add("1");
        ArrayList<Watch> watches = watchService.creatWatchListFromIds(watchIds);
        assertEquals("Rolex", watches.get(0).getWatchName());
        assertEquals(1, watches.get(0).getWatchId());
    }

    @Test(expected = Exception.class)
    public void testUsingUnusedWatchId() throws Exception {
        ArrayList<String> watchIds = new ArrayList<>();
        watchIds.add("1");
        watchIds.add("6");
        watchService.creatWatchListFromIds(watchIds);
    }

    @Test(expected = NumberFormatException.class)
    public void testUsingIncorrectString() throws Exception {
        ArrayList<String> watchIds = new ArrayList<>();
        watchIds.add("1,1,1,1,1");
        watchService.creatWatchListFromIds(watchIds);
    }
}
