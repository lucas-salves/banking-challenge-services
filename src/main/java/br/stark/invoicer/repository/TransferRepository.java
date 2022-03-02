/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.stark.invoicer.repository;

import br.stark.invoicer.model.Transfer;

/**
 *
 * @author lucas
 */
public interface TransferRepository {
    void transfer(Transfer transfer) throws Exception;
}
