package br.com.dev.maratonajsf.bean.Validation;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by Renan on 25/01/2023.
 */
@Named
@ViewScoped
public class ValidationTestbean implements Serializable{
    private String password;

    public void save(){
        System.out.println(password);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
