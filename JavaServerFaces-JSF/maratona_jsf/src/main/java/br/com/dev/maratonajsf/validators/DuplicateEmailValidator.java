package br.com.dev.maratonajsf.validators;

import br.com.dev.maratonajsf.bean.login.LoginBean;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Renan on 25/01/2023.
 */
@FacesValidator
public class DuplicateEmailValidator implements Validator{
    private List<String> emailsDB = Arrays.asList("renan@mafort","renan@sereia","wil.gg@ee");

    @Inject
    private LoginBean loginBean;

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        System.out.println(loginBean.getLanguage());
        String email = (String) o;
        if (emailsDB.contains(email)){
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"O email já existe cadastrado","");
            throw new ValidatorException(message);
        }

    }
}
