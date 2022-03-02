# banking-challenge-services

# Desenho de arquitetura


![Macro](https://user-images.githubusercontent.com/46874823/156423337-07e8ee31-2bb3-41c7-9b1e-57d2b1411c2d.jpg)
 
![aws](https://user-images.githubusercontent.com/46874823/156425848-9911fb3e-3462-44cd-8cf4-8d72e96a3950.jpg)


Foi utilizado um message broker RabbitMQ para reduzir o acoplamento do sistema

Não consegui instalar um certificado SSL na instância EC2, então o projeto do webhook ficou local

Foi utilizado um TimerTask com a biblioteca Joda para verificar se passaram 3h desde o último schedule e se passaram 24h desde o primeiro schedule.
```
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
```

