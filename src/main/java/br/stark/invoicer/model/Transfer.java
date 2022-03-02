/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.stark.invoicer.model;

import java.math.BigDecimal;
import lombok.Data;

/**
 *
 * @author lucas
 */
@Data
public class Transfer {
    private BigDecimal fee;
    
    private BigDecimal amount;
    
    private String bankCode="20018183";
    
    private String branchCode="0001";
    
    private String accountNumber="6341320293482496";
    
    private String taxId="20.018.183/0001-80";
    
    private String name="Stark Bank S.A.";
}
