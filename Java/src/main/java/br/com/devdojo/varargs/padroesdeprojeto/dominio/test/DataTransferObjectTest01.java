package br.com.devdojo.varargs.padroesdeprojeto.dominio.test;

import br.com.devdojo.varargs.padroesdeprojeto.dominio.*;

public class DataTransferObjectTest01 {
    public static void main(String[] args) {
        AirCraft airCraft = new AirCraft("777");
        Country country = Country.BRAZIL;
        Currency currency = CurrencyFactory.newCurrency(country);
        Person build = Person.PersonBuilder.builder().firstName("Renan")
                .lastName("Sereia").build();

        ReportDTO build1 = ReportDTO.ReportDTOBuilder.builder()
                .aircraftName(airCraft.getName()).country(country)
                .currency(currency)
                .personName(build.getFirstName()).build();

        System.out.println(build1.toString());
    }
}
