/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.stark.invoicer.consumer;

import br.stark.invoicer.dto.InvoiceDto;
import br.stark.invoicer.service.AMQPPublisher;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lucas
 */
public class InvoiceConsumer extends DefaultConsumer{
    
    private final Channel channel;
    
    private final Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();

    public InvoiceConsumer(Channel channel) {
        super(channel);
        this.channel = channel;
    }
    
    @Override
    public void handleDelivery(String csTag, Envelope env, AMQP.BasicProperties props, byte[] body) {
        try {

            var message = new String(body, "UTF-8");

            this.processDelivery(message);

            //tag, ack all messages
            channel.basicAck(env.getDeliveryTag(), false);

        } catch (IOException ex) {
            ex.printStackTrace();
            System.exit(0);

        } catch (Exception ex) {
            Logger.getLogger(InvoiceConsumer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void processDelivery(String message) throws Exception {
        System.out.println(message);
        
        var dto = gson.fromJson(message, InvoiceDto.class);
        
        if("credited".equals(dto.getEvent().getLog().getInvoiceEventType())){
            
            var publisher = new AMQPPublisher();
            
            publisher.sendToQueue("credited_invoices", gson.toJson(dto));
            
            publisher.close();
        }
    }
    
}