package br.com.sereia.renan.chatgptspringbootintegration.request;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Message implements Serializable {

    @Serial
    private static final long serialVersionUID = -4751757548301548022L;
    private String role;
    private String content;

    public Message(String role, String content) {
        this.role = role;
        this.content = content;
    }


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return Objects.equals(role, message.role) && Objects.equals(content, message.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(role, content);
    }
}
