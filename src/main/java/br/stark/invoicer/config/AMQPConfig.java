/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.stark.invoicer.config;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lucas
 */
public class AMQPConfig {

    // replace with environment variables
    private static final String URI = "amqps://b-c08254a4-b29f-4304-aa2b-64c6b056d97d.mq.us-east-2.amazonaws.com:5671";

    private static final String USERNAME = "admin";

    private static final String PASSWORD = "rabbitpassword";

    public static Connection getConnection() {
        
        Connection connection = null;
        
        try {
            var factory = new ConnectionFactory();
            
            factory.setUri(URI);
            factory.setConnectionTimeout(5000);
            factory.setRequestedHeartbeat(5);
            factory.setUsername(USERNAME);
            factory.setPassword(PASSWORD);
            
            var exec = Executors.newCachedThreadPool();
            
            connection = factory.newConnection(exec);
            
            return connection;
        } catch (IOException ex) {
            Logger.getLogger(AMQPConfig.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TimeoutException ex) {
            Logger.getLogger(AMQPConfig.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(AMQPConfig.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AMQPConfig.class.getName()).log(Level.SEVERE, null, ex);
        } catch (KeyManagementException ex) {
            Logger.getLogger(AMQPConfig.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }

}
