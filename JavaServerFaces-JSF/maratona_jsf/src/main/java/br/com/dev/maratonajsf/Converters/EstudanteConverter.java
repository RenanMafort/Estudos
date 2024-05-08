package br.com.dev.maratonajsf.Converters;

import br.com.dev.maratonajsf.model.Estudante;
import org.apache.commons.lang3.SerializationUtils;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import java.util.List;
import java.util.Map;

/**
 * Created by Renan on 25/01/2023.
 */
@FacesConverter(value = "estudanteConverter")
public class EstudanteConverter implements Converter {
    List<Estudante> estudanteList = Estudante.estudanteList();
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
     if (value == null || !value.matches("\\d+"))
        return null;

//     Estudante estudante = new Estudante();
//     estudante.setId(Integer.parseInt(value));
//     int index = estudanteList.indexOf(estudante);
//     return  estudanteList.get(index);


        return this.getAttributesFrom(uiComponent).get(value);
    }


    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        if (value != null && !value.equals("")){
            Estudante estudante = (Estudante) value;
            if (estudante.getId() != null){
                this.addAttribute(uiComponent,estudante);
                return estudante.getId().toString();
            }
        }

        return null;
    }

    private Map<String , Object> getAttributesFrom(UIComponent component){
        return component.getAttributes();

    }

    private void addAttribute(UIComponent component,Estudante estudante){
        this.getAttributesFrom(component).put(estudante.getId().toString(),estudante);
    }
}
