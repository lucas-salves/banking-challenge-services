/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.stark.invoicer;

import br.stark.invoicer.TestRunner;
import br.stark.invoicer.service.SchedulerService;
import java.net.MalformedURLException;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Interval;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author lucas
 */
@RunWith(TestRunner.class)
public class SchedulerTest {

 

    @Test
    public void checkIf24hHavePassedTest() throws Exception {

        var beginDay = 1;

        var currentDay = DateTime.now().dayOfYear().get();

        boolean dayPassed = false;

        if (beginDay != currentDay) {

            System.out.println("Scheduler encerrado 24H depois.");

            dayPassed = true;
        }

        Assertions.assertTrue(dayPassed);
    }

    @Test
    public void checkIf3hHavePassedTestFromTheLastTimeTimestamp() {

        boolean success = false;

        var timestamp = String.valueOf(new DateTime("2022-03-01T02:59:02.815762+00:00").getMillis());

        Long lastTime = Long.parseLong(timestamp);

        var now = DateTime.now(DateTimeZone.UTC);

        var currentTime = now.getMillis();

        var interval = new Interval(lastTime, currentTime).toDurationMillis();

        // 1h=3600000 / 3h=10800000
        if (interval >= 10800000) {

            success = true;
        }
        Assertions.assertTrue(success);
    }

    @Test
    public void hasLastItemTest() throws MalformedURLException {
        SchedulerService service = new SchedulerService();

        var result = service.hasLastItem();

        Assertions.assertNotNull(result);
    }

}
