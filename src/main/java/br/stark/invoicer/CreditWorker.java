/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.stark.invoicer;

import br.stark.invoicer.config.AMQPConfig;
import br.stark.invoicer.consumer.CreditConsumer;

/**
 *
 * @author lucas
 */
public class CreditWorker {
    private static final String QUEUE_NAME = "credited_invoices";

    public static void main(String[] args) throws Exception {

        var connection = AMQPConfig.getConnection();

        var channel = connection.createChannel();

        channel.basicQos(0);

//        queue, durable, exclusive, autoDelete, properties
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);

        //requeue
        channel.basicRecover(true);

        var callback = new CreditConsumer(channel);

        //queue, autoAck, callback
        channel.basicConsume(QUEUE_NAME, false, callback);

        System.out.println("waiting message");
    }
}
