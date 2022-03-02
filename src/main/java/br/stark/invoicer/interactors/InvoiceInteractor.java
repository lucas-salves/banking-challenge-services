/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.stark.invoicer.interactors;

import br.stark.invoicer.repository.InvoiceRepository;
import com.starkbank.Invoice;
import java.util.List;

/**
 *
 * @author lucas
 */
public class InvoiceInteractor {
    private final InvoiceRepository repository;

    public InvoiceInteractor(InvoiceRepository transferRepository) {
        this.repository = transferRepository;
    }

    public List<Invoice> listInvoicesUseCase() throws Exception {
       return repository.getInvoices();
        
    }
}
