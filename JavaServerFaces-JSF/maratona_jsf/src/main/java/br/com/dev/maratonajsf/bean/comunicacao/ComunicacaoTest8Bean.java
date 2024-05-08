package br.com.dev.maratonajsf.bean.comunicacao;

import br.com.dev.maratonajsf.model.Estudante;
import org.omnifaces.util.Faces;

import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.Cookie;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;

/**
 * Created by Renan on 22/01/2023.
 */
@Named
@ViewScoped
public class ComunicacaoTest8Bean implements Serializable {
    private String key;
    private String value;
    public void init(){
        Map<String, Object> requestCookieMap = FacesContext.getCurrentInstance().getExternalContext().getRequestCookieMap();
        String renan = Faces.getRequestCookie("renan");
        System.out.println( renan);


        System.out.println(requestCookieMap);
    }

    public String salvarCookie(){
        Faces.addResponseCookie(key,value,-1);

        return "comunicacao9?faces-redirect=true";
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
