package br.com.sereia.renan.chatgptspringbootintegration.response;

import br.com.sereia.renan.chatgptspringbootintegration.request.Message;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Choice implements Serializable {
    @Serial
    private static final long serialVersionUID = -4943550550004854687L;

    private Integer index;
    private Message message;
    private String logprobs;

    @JsonProperty("finish_reason")
    private String finishReason;

    public Choice() {
    }


    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public String getLogprobs() {
        return logprobs;
    }

    public void setLogprobs(String logprobs) {
        this.logprobs = logprobs;
    }

    public String getFinishReason() {
        return finishReason;
    }

    public void setFinishReason(String finishReason) {
        this.finishReason = finishReason;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Choice choice = (Choice) o;
        return Objects.equals(index, choice.index) && Objects.equals(message, choice.message) && Objects.equals(logprobs, choice.logprobs) && Objects.equals(finishReason, choice.finishReason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, message, logprobs, finishReason);
    }
}
