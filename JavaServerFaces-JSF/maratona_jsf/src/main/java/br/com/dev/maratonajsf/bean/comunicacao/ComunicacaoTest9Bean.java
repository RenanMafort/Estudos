package br.com.dev.maratonajsf.bean.comunicacao;

import org.omnifaces.util.Faces;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Map;

/**
 * Created by Renan on 22/01/2023.
 */
@Named
@ViewScoped
public class ComunicacaoTest9Bean implements Serializable {
    private String key;
    private String value;
    public void init(){
        value = Faces.getRequestCookie("renan");
    }



    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
