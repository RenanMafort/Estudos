package br.com.dev.maratonajsf.bean.taglifunction;

import org.apache.commons.lang3.text.WordUtils;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Renan on 03/02/2023.
 */
@Named
@ViewScoped
public class TagLibFunctionTesteBean implements Serializable {
    private List<String> names = Arrays.asList("Renan sereia","Mafort sereia","Sereia mafort");

    public void init(){
        names.forEach(name -> System.out.println(WordUtils.capitalizeFully(name)));
    }
    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }
}
