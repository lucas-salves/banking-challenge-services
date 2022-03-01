/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.stark.invoicer.dto;

import com.google.gson.annotations.SerializedName;
import java.math.BigDecimal;
import lombok.Data;

/**
 *
 * @author lucas
 */
@Data
public class InvoiceDto {
    
    @SerializedName("event")
    private Event event;
    
    @Data
    public class Event {
        @SerializedName("log")
        private Log log;
    }
    
    @Data
    public class Log {
        @SerializedName("type")
        private String invoiceEventType;
        
        @SerializedName("invoice")
        private Invoice invoice;
        
    }
    
    @Data
    public class Invoice{
        @SerializedName("amount")
        private BigDecimal amount;
        
        @SerializedName("fineAmount")
        private BigDecimal fineAmount;
        
        @SerializedName("interestAmount")
        private BigDecimal interestAmount;
        
        @SerializedName("fee")
        private BigDecimal fee;
    }
}
