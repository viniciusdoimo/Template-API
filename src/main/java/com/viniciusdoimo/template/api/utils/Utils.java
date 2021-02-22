/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viniciusdoimo.template.api.utils;

import java.util.List;

/**
 *
 * Vinicius Doimo
 * E-mail: vinicius.rodrigues.doimo@gmail.com
 *
 */
public class Utils {

    public static String listToString(List list) {
        String retorno = "";
        if (list != null && list.size() > 0) {
            for (Object i : list) {
                if (i != null) {
                    if (!retorno.equals("")) {
                        retorno += ", ";
                    }
                    if (i instanceof String) {
                        retorno += "'" + i + "'";
                    } else {
                        retorno += i.toString();
                    }
                }
            }
            return retorno;
        }
        return "";
    }

    public static String convertListToString(List<String> lista) {
        return lista.stream().reduce((a, b) -> a + "'" + "," + "'" + b).get();
    }

    public static String concat(Object... items) {
        String objectsConcatenated = "";
        for (Object i : items) {
            if (i != null) {
                objectsConcatenated = objectsConcatenated.concat(i.toString());
            }
        }
        return objectsConcatenated;
    }

    public static Object coalesce(Object... items) {
        for (Object i : items) {
            if (i != null) {
                return i;
            }
        }
        return "";
    }

    public static String LeftZero(Integer DigitAmount, String number) {
        Integer loop = DigitAmount - number.length();
        String numFinal = "";
        for (int i = 1; i <= loop; i++) {
            numFinal += "0";
        }
        return numFinal + number;
    }



}
