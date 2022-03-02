/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.stark.invoicer.http;

import br.stark.invoicer.repository.InvoiceRepository;
import br.stark.invoicer.util.ApiUtils;
import com.starkbank.Invoice;
import com.starkbank.utils.Generator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.joda.time.DateTime;

/**
 *
 * @author lucas
 */
public class InvoiceStarkApi implements InvoiceRepository {

    @Override
    public List<Invoice> getInvoices() throws Exception {
        List<Invoice> invoicesResult = new ArrayList<>();
        
        ApiUtils.setProject();

        HashMap<String, Object> params = new HashMap<>();
        
        DateTime date = DateTime.now();
        
        var year = date.yearOfEra();
        var month = date.monthOfYear();
        var day = date.dayOfMonth(); 
        
        String dateTemplate = year.get()+"-"+month.get()+"-"+day.get();
        
        params.put("before", dateTemplate);
        
        Generator<Invoice> invoices = Invoice.query(params);

        for (Invoice invoice : invoices) {
            invoicesResult.add(invoice);
        }

        
        return invoicesResult;
    }

}
