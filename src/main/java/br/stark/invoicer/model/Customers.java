/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.stark.invoicer.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author lucas
 */
@Getter
@Setter
public class Customers {

    List<Customer> customers;

    @Data
    @AllArgsConstructor
    public class Customer {

        private String taxId;

        private String name;

    }

    public Customers() {
        this.customers = new ArrayList<>();
        this.customers.add(new Customer("20.018.183/0001-80", "Iron Bank S.A."));
        this.customers.add(new Customer("450.539.870-68", "João"));
        this.customers.add(new Customer("349.954.990-59", "Joyce"));
        this.customers.add(new Customer("855.465.870-16", "Lucas"));
        this.customers.add(new Customer("197.397.400-22", "Mariana"));
        this.customers.add(new Customer("987.033.880-18", "Teste Teste"));
        
    }
    
    public Customer getRandomCustomer(){
        var max = 5;
        var min = 0;
        Random random = new Random();
        return this.customers.get(
              random.ints(min, max).findFirst().getAsInt()
        );
    }

}
