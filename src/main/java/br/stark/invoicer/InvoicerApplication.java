package br.stark.invoicer;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InvoicerApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(InvoicerApplication.class, args);

        Thread scheduler = new Thread(new Runnable() {
            @Override
            public void run() {
                
                try {
                    InvoiceScheduler.main(null);
                } catch (Exception ex) {
                    Logger.getLogger(InvoicerApplication.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        Thread  invoiceConsumerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    InvoiceWorker.main(null);
                } catch (Exception ex) {
                    Logger.getLogger(InvoicerApplication.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        Thread creditedStatusThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    CreditWorker.main(null);
                } catch (Exception ex) {
                    Logger.getLogger(InvoicerApplication.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        scheduler.start();
        invoiceConsumerThread.start();
        creditedStatusThread.start();
        
        scheduler.join();
        invoiceConsumerThread.join();
        creditedStatusThread.join();
        
    }

}
