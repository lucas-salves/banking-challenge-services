/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.stark.invoicer.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author lucas
 */
public class DecimalUtil {
    public static BigDecimal toDecimal(BigDecimal value){
        NumberFormat nf = NumberFormat.getNumberInstance(Locale.US);
        
        DecimalFormat formatter = (DecimalFormat) nf;
        
        formatter.applyPattern("##,##");
        
        String decimal = formatter.format(value);
        
        decimal = decimal.replaceFirst(",", "");
        
        System.out.println(decimal);
        
        return new BigDecimal(decimal.replaceAll(",", ".")).setScale(2, RoundingMode.HALF_EVEN);
    }
}
