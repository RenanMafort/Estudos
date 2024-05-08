package br.com.springboot3.data.vo.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@JsonPropertyOrder({"key","firstName","lastName","gender","address"})
public class PersonVO extends RepresentationModel<PersonVO> implements Serializable {
    @Serial
    private static final long serialVersionUID = -5094945975289256352L;

    @Mapping("id")
    @JsonProperty("id")
    private Long key;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    private String address;
    private String gender;
    private boolean enabled;

    public PersonVO() {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PersonVO vo = (PersonVO) o;
        return enabled == vo.enabled && Objects.equals(key, vo.key) && Objects.equals(firstName, vo.firstName) && Objects.equals(lastName, vo.lastName) && Objects.equals(address, vo.address) && Objects.equals(gender, vo.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), key, firstName, lastName, address, gender, enabled);
    }
}
