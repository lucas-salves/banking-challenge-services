/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.stark.invoicer.service;

import br.stark.invoicer.http.TransferStarkApi;
import br.stark.invoicer.interactors.TransferUseCase;
import br.stark.invoicer.model.Transfer;
import java.math.BigDecimal;

/**
 *
 * @author lucas
 */
public class TransferService {

    public void transfer(BigDecimal amount, BigDecimal fee) throws Exception {
        //façade
        var transferCreator = new TransferUseCase(new TransferStarkApi());

        Transfer transfer = new Transfer();
        transfer.setAmount(amount);
        transfer.setFee(fee);

        transferCreator.execute(transfer);
    }
}
