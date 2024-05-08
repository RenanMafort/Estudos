package br.com.dev.maratonajsf.taglibfunction;

import org.apache.commons.lang3.text.WordUtils;

/**
 * Created by Renan on 04/02/2023.
 */
public class TagLibFunction {
    public static String capitalize(String str){
        return WordUtils.capitalize(str);
    }
}
