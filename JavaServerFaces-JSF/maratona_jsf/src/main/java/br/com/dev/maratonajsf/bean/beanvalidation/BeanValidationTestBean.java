package br.com.dev.maratonajsf.bean.beanvalidation;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * Created by Renan on 30/01/2023.
 */
@Named
@ViewScoped
public class BeanValidationTestBean implements Serializable {
    @Size(min = 3,max = 10, message = "O nome deve ter entre 3 e 10 caracteres")
    @NotNull(message = "O nome é obrigatorio")
    private String nome;
    @Pattern(regexp = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$",message = "Digite um email válido")
    private String email;
    @DecimalMax(value = "30.00",message = "O valor decimal não pode ser maior que 30.50")
    @DecimalMin(value = "5.00",message = "O valor decimal não pode ser maior que 5.00")
    private double decimal;
    @Digits(integer = 3,fraction = 2, message = "O valor não pode ser maior que 999 e casa decimal maior que 2")
    private double numero;

    public void salvar(){
        System.out.println(nome);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getDecimal() {
        return decimal;
    }

    public void setDecimal(double decimal) {
        String replace = String.valueOf(decimal).replace(",",".");
        this.decimal = Double.parseDouble(replace);
    }

    public double getNumero() {
        return numero;
    }

    public void setNumero(double numero) {
        this.numero = numero;
    }
}
