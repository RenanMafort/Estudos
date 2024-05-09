package br.com.sereia.renan.chatgptspringbootintegration.request;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ChatGptRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = 271229825683480131L;
    private String model;
    private List<Message> messages;

    public ChatGptRequest(String model,String content) {
        this.model = model;
        this.messages = new ArrayList<>();
        this.messages.add(new Message("user",content));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatGptRequest that = (ChatGptRequest) o;
        return Objects.equals(model, that.model) && Objects.equals(messages, that.messages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, messages);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
