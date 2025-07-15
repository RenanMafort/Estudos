package pt.com.teste;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class TemplateService {

    private final ResourceBundle bundle = ResourceBundle.getBundle("messages", new Locale("pt", "PT"));

    public String formatar(String chave, Object... params) {
        if (!bundle.containsKey(chave)) {
            return "Template não encontrado: " + chave;
        }
        String template = bundle.getString(chave);
        return MessageFormat.format(template, params);
    }
}
