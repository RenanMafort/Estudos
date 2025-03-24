package br.com.devdojo.varargs.padroesdeprojeto.dominio;

import lombok.Getter;

@Getter
public class ReportDTO {
    private String aircraftName;
    private Country country;
    private Currency currency;
    private String personName;


    public static final class ReportDTOBuilder {
        private String aircraftName;
        private Country country;
        private Currency currency;
        private String personName;

        private ReportDTOBuilder() {
        }

        public static ReportDTOBuilder builder() {
            return new ReportDTOBuilder();
        }

        public ReportDTOBuilder aircraftName(String aircraftName) {
            this.aircraftName = aircraftName;
            return this;
        }

        public ReportDTOBuilder country(Country country) {
            this.country = country;
            return this;
        }

        public ReportDTOBuilder currency(Currency currency) {
            this.currency = currency;
            return this;
        }

        public ReportDTOBuilder personName(String personName) {
            this.personName = personName;
            return this;
        }

        public ReportDTO build() {
            ReportDTO reportDTO = new ReportDTO();
            reportDTO.country = this.country;
            reportDTO.personName = this.personName;
            reportDTO.currency = this.currency;
            reportDTO.aircraftName = this.aircraftName;
            return reportDTO;
        }
    }

    @Override
    public String toString() {
        return "ReportDTO{" +
                "aircraftName='" + aircraftName + '\'' +
                ", country=" + country +
                ", currency=" + currency.getSymbol() +
                ", personName='" + personName + '\'' +
                '}';
    }
}
