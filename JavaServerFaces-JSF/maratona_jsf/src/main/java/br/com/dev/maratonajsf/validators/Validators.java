package br.com.dev.maratonajsf.validators;


import br.com.dev.maratonajsf.bean.login.LoginBean;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Renan on 25/01/2023.
 */
@Named
@RequestScoped
public class Validators implements Serializable{
    private final List<String> emailsDB = Arrays.asList("renan@mafort","renan@sereia","wil.gg@ee");

    @Inject
    private LoginBean loginBean;

    public void validateDuplicatedEmail(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        System.out.println(loginBean.getLanguage());
        String email = (String) o;
        if (emailsDB.contains(email)){
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"O email já existe cadastrado","");
            throw new ValidatorException(message);
        }

    }

    public void validateFile(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException{
        Part file =(Part) o ;
        try {
            validateFileNameLenght(file);
            validateContentType(file);
            validateFileSize(file);

        }catch (RuntimeException e){
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,e.getMessage(),"");
            throw new ValidatorException(message);
        }
    }

    public void validateFileNameLenght(Part file){
        if (file.getSubmittedFileName().length() > 15){
            throw new RuntimeException("O nome + extensão não pode ser maior que 10 car");
        }
    }

    public void validateContentType(Part file){
        String contentType = file.getContentType();
        if (!contentType.equals("image/png") && !contentType.equals("image/jpge")){
            throw new RuntimeException("Apenas PNG e JPEG são permitidas");
        }
    }

    private void validateFileSize(Part file){
        if (file.getSize() > 1048576){
            throw new RuntimeException("O arquivo não pode exceder 1Mb");
        }
    }
}
