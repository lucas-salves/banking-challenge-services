/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.stark.invoicer.repository;

import com.starkbank.Invoice;
import java.util.List;

/**
 *
 * @author lucas
 */
public interface InvoiceRepository {
    List<Invoice> getInvoices() throws Exception;
}
