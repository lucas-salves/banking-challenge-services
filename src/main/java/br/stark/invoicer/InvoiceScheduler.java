/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.stark.invoicer;

import br.stark.invoicer.model.Customers;
import br.stark.invoicer.model.Customers.Customer;
import br.stark.invoicer.service.SchedulerService;
import com.google.common.collect.Iterables;
import com.starkbank.Invoice;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.joda.time.DateTime;

/**
 *
 * @author lucas
 */
public class InvoiceScheduler {

    public static void main(String[] args) throws Exception {

        SchedulerService scheduleService = new SchedulerService();

        var beginDay = DateTime.now().dayOfYear().get();

        var wrapper = new Object() {
            String lastScheduled = "";
        };

        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                try {

                    var currentDay = DateTime.now().dayOfYear().get();

                    if (beginDay != currentDay) {
                        System.out.println("Scheduler encerrado 24H depois.");
                        timer.cancel();
                        timer.purge();
                    }

                    var scheduledInvoice = scheduleService.isScheduledTime();
                    
                    if (scheduledInvoice != null) {
                        
                        wrapper.lastScheduled = scheduledInvoice.id;
                        
                        var newInvoices = createInvoicesForRandomCustomers();

                        scheduleService.setLastId(Iterables.getLast(newInvoices).id);
                    }
                    
                } catch (MalformedURLException ex) {
                    Logger.getLogger(InvoiceScheduler.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(InvoiceScheduler.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }, 0, 2000);

    }

    private static List<Invoice> createInvoicesForRandomCustomers() throws Exception {
        Customers customers = new Customers();

        List<Invoice> invoices = new ArrayList<>();
        HashMap<String, Object> data = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            Customer customer = customers.getRandomCustomer();

            Random random = new Random();

            var max = 25000;
            var min = 1000;

            var randomAmount = random.ints(min, max).findFirst().getAsInt();

            data.put("taxId", customer.getTaxId());
            data.put("name", customer.getName());
            data.put("amount", randomAmount);

            invoices.add(new Invoice(data));
        }
        System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
        System.out.println("Creted Invoices for random Customers::: " + invoices);
        System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
        return Invoice.create(invoices);
    }
}
