/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.stark.invoicer.http;

import br.stark.invoicer.repository.TransferRepository;
import br.stark.invoicer.util.DecimalUtil;
import com.starkbank.Project;
import com.starkbank.Settings;
import com.starkbank.Transfer;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author lucas
 */
public class TransferStarkApi implements TransferRepository {

    @Override
    public void transfer(br.stark.invoicer.model.Transfer transferData) throws Exception {
        String privateKeyContent = "-----BEGIN EC PRIVATE KEY-----\n"
                + "MHQCAQEEIBCUgqBo7v84iMpoyciqqe8pabsv5vh7VjBaXYM5XbEroAcGBSuBBAAK\n"
                + "oUQDQgAElvMZeKIdKxTeNQ398gmBj9/Txii7Sf71irgxW2UHzsgedgTbm6LcLAju\n"
                + "hB5AVxt9A/yZWsnSi+nz4J3NaXV0Dw==\n"
                + "-----END EC PRIVATE KEY-----";

        Project project = new Project("sandbox", "4750343523008512", privateKeyContent);

        Settings.user = project;

        var invoiceFee = transferData.getFee();

        var amount = transferData.getAmount();

         if (invoiceFee != null) {
            amount = this.subtractFee(invoiceFee, amount);
         }

        List<Transfer> transfers = new ArrayList<>();

        HashMap<String, Object> data = new HashMap<>();
        
        data.put("amount", amount);
        data.put("bankCode", transferData.getBankCode());
        data.put("branchCode", transferData.getBranchCode());
        data.put("accountNumber", transferData.getAccountNumber());
        data.put("taxId", transferData.getTaxId());
        data.put("name", transferData.getName());

        Transfer transfer = new Transfer(data);

        transfers.add(transfer);

        transfers = Transfer.create(transfers);

        for (var transferItem : transfers) {
            System.out.println("Transferencia: " + transferItem);
        }

    }
    
    private BigDecimal subtractFee(BigDecimal feeValue, BigDecimal amount){
        
            amount = DecimalUtil.toDecimal(amount);

            feeValue = DecimalUtil.toDecimal(feeValue);
            
            amount = amount.subtract(feeValue);
            
            return new BigDecimal(amount.toString().replace(".",""));
    }

}
