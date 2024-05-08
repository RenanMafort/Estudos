package br.com.dev.maratonajsf.bean.testebean;

import javax.inject.Named;
import java.io.Serializable;

@Named
public class Professor implements Serializable {
    private School school;

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}
