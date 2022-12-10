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
public class DiscountServiceTest {
    @Autowired
    DiscountService discountService;

    @Test
    public void testCalculateDiscount() throws Exception {
        ArrayList<Watch> watches = new ArrayList<>();
        watches.add(new Watch(1, "rolex", 200, "3 for 500"));
        watches.add(new Watch(1, "rolex", 200, "3 for 500"));
        watches.add(new Watch(1, "rolex", 200, "3 for 500"));
        watches.add(new Watch(1, "rolex", 200, "3 for 500"));
        watches.add(new Watch(1, "rolex", 200, "3 for 500"));
        watches.add(new Watch(1, "rolex", 200, "3 for 500"));
        watches.add(new Watch(1, "rolex", 200, "3 for 500"));
        assertEquals(200, discountService.calculateDiscount(watches));
    }

    @Test(expected = Exception.class)
    public void testShouldThrowParseExceptionIfDiscountNotValid() throws Exception {
        ArrayList<Watch> watches = new ArrayList<>();
        watches.add(new Watch(1, "rolex", 20, "3for2"));
        watches.add(new Watch(1, "rolex", 20, "3for2"));
        discountService.calculateDiscount(watches);

    }
}
