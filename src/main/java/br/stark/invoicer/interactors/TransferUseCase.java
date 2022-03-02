/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.stark.invoicer.interactors;

import br.stark.invoicer.repository.TransferRepository;
//import com.starkbank.*;
import br.stark.invoicer.model.Transfer;

/**
 *
 * @author lucas
 */
public class TransferUseCase {

    private final TransferRepository transferRepository;

    public TransferUseCase(TransferRepository transferRepository) {
        this.transferRepository = transferRepository;
    }

    public void execute(Transfer transfer) throws Exception {
       transferRepository.transfer(transfer);
        
    }

}
