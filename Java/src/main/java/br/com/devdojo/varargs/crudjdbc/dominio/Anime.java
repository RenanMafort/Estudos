package br.com.devdojo.varargs.crudjdbc.dominio;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Anime {
    Integer id;
    String name;
    int episodes;
    Producer producer;
}
