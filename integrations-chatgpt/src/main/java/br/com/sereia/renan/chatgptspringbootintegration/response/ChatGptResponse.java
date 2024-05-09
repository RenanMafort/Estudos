package br.com.sereia.renan.chatgptspringbootintegration.response;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public class ChatGptResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = 7848076243541308407L;
    private List<Choice> choices;

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }
}
