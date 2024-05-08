package br.com.devdojo.varargs.collections.dominio;

import java.util.Objects;

public class SmartPhone {
    private String seriaNumber;
    private String marca;

    public SmartPhone(String seriaNumber, String marca) {
        this.seriaNumber = seriaNumber;
        this.marca = marca;
    }

    public String getSeriaNumber() {
        return seriaNumber;
    }

    public void setSeriaNumber(String seriaNumber) {
        this.seriaNumber = seriaNumber;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    //Equals tem que ser reflexivo : x.equals(x) tem que ser true para tudo que for diferente de null
    //Simetrico: para x e y diferentes de null, se x.equals(y) ==true logo, y.equals(x) == true
    //Transitividade: para x,y,z diferentes de null, se x.equals(y) == true, e x.equals(z) == true logo y.equals(z )== true
    //Consistente: x.equals(x) sempre retorna true se x for diferente de null
    // para x diferente de null, x.equals(null) tem que retornar false.
    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (this == obj) return true;
        if (this.getClass() != obj.getClass()) return false;
        SmartPhone s = (SmartPhone) obj;
         return  seriaNumber != null && seriaNumber.equals(s.seriaNumber) ||
                 marca != null && marca.equals(s.marca);
    }

    //if x.equals(y) ==true , y.hashcode() == x.hashcode()
    //y.hashCode() == x.hashCode não necessariamente o equals de x.quals(x) tem que ser true
    // x.equals(y) == false
    //
//    @Override
//    public int hashCode() {
//        int i = this.seriaNumber.hashCode();
//        int i1 = this.marca.hashCode();
//
//        int i2 = seriaNumber == null ? 0 : this.seriaNumber.hashCode();
//        int i3 = marca == null ? 0 : this.marca.hashCode();
//
//        return  i2 || i3 ;
//    }


    @Override
    public int hashCode() {
        return Objects.hash(seriaNumber, marca);
    }
}
