/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.stark.invoicer.http;

import br.stark.invoicer.repository.InvoiceRepository;
import com.starkbank.Invoice;
import com.starkbank.Project;
import com.starkbank.Settings;
import com.starkbank.utils.Generator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author lucas
 */
public class InvoiceStarkApi implements InvoiceRepository {

    @Override
    public List<Invoice> getInvoices() throws Exception {
        List<Invoice> invoicesResult = new ArrayList<>();
        String privateKeyContent = "-----BEGIN EC PRIVATE KEY-----\n"
                + "MHQCAQEEIBCUgqBo7v84iMpoyciqqe8pabsv5vh7VjBaXYM5XbEroAcGBSuBBAAK\n"
                + "oUQDQgAElvMZeKIdKxTeNQ398gmBj9/Txii7Sf71irgxW2UHzsgedgTbm6LcLAju\n"
                + "hB5AVxt9A/yZWsnSi+nz4J3NaXV0Dw==\n"
                + "-----END EC PRIVATE KEY-----";

        Project project = new Project("sandbox", "4750343523008512", privateKeyContent);
        
        Settings.user = project;

        HashMap<String, Object> params = new HashMap<>();
        params.put("after", "2020-10-01"); // mudar para "before": "data de hoje"
        Generator<Invoice> invoices = Invoice.query(params);

        for (Invoice invoice : invoices) {
            invoicesResult.add(invoice);
        }

        
        return invoicesResult;
    }

}
