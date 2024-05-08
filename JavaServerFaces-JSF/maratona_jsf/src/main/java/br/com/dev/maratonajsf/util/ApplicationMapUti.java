package br.com.dev.maratonajsf.util;

import javax.faces.context.FacesContext;

/**
 * Created by Renan on 23/01/2023.
 */
public class ApplicationMapUti {
    public static Object getValueFromApplicationMap(String key){
        return FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().get(key);
    }

    public static void setValueInApplicationMap(String key, Object value){
         FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().put(key,value);
    }
}
