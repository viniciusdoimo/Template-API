/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viniciusdoimo.template.api.utils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * Vinicius Doimo
 * E-mail: vinicius.rodrigues.doimo@gmail.com
 *
 */
public class NumberUtils implements Serializable {

    public static BigDecimal formatBigDecimal(Object valor) {
        DecimalFormat df = new DecimalFormat("0.000000");
        df.setRoundingMode(RoundingMode.HALF_EVEN);
        return new BigDecimal(df.format(Double.valueOf(valor.toString())).replace(",", "."));
    }

    public static BigDecimal formatForFourDecimalDigits(BigDecimal valor) {
        DecimalFormat df = new DecimalFormat("0.0000");
        df.setRoundingMode(RoundingMode.HALF_EVEN);
        return new BigDecimal(df.format(Double.valueOf(valor.toString())).replace(",", "."));
    }

    public static String formatForBrazilianMoney(Object valor) {
        Locale locale = new Locale("pt", "BR");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
        if (valor != null) {
            return currencyFormatter.format(valor).replace("R$ ", "");
        }
        return "00,00";
    }

    /**
     * If vlDouble is an integer it will return vlDouble
     * If vlDouble is a fractional value, it will return the next integer value.
     * @param vlDouble
     * @return
     */
    public static BigInteger roundUp(double vlDouble) {
        double roundDown = Math.floor(vlDouble);

        if(roundDown ==  vlDouble){
            return BigDecimal.valueOf(roundDown).toBigInteger();
        }
        return  BigDecimal.valueOf(roundDown).toBigInteger().add(BigInteger.ONE);
    }
}