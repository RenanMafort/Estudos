package br.com.dev.maratonajsf.bean.flowbuilder;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.flow.FlowScoped;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by Renan on 17/01/2023.
 */
@Named
@FlowScoped(value = "newpendecies")
public class TestFlowBuilderNestedBean implements Serializable {
    private String userName;
    private String userSurname;
    public  String validar(){
        System.out.println("Fazendo consulta no SERASA");
        System.out.println("Fazendo consulta no SPC");
        if (true){
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Users not passed in the pendecies","Algum detalhe utilizado"));
            return null;
        }
        return "proceedToNewRegistration3";
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
