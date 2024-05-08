package br.com.springboot3.config;

import br.com.springboot3.SerializationConverter.YamlJacksonToHttpMessageConverter;
import br.com.springboot3.utils.constants.Constants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Value("${cors.originPatterns:default}") //:default podemos colocar qualquer valor default
    private String corsOriginPatterns = "";

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
//        EXPLICAÇÃO DE CONTENT NEGOTIATION
//        https://www.baeldung.com/spring-mvc-content-negotiation-json-xml
//        Deprecated .EXTENSION ON SpringBoot 2
//        {{localhost}}/api/person/v1.xml

//        USANDO VIA QUERY PARAM
//        {{localhost}}/api/person/v1?mediaType=xml
        Map<String,MediaType> mediaTypeMap = new HashMap<>();
        mediaTypeMap.put("json",MediaType.APPLICATION_JSON);
        mediaTypeMap.put("xml",MediaType.APPLICATION_XML);
        mediaTypeMap.put("x-yaml", MediaType.valueOf(Constants.MEDIA_TYPE_APPLICATION_YAML));

       configurer.favorParameter(false)
               .ignoreAcceptHeader(false)
               .useRegisteredExtensionsOnly(false)
               .defaultContentType(MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML)
               .mediaTypes(mediaTypeMap);

    }

    //UTILIZADO PARA CONVERTER O RESPONSE PARA YAML
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new YamlJacksonToHttpMessageConverter());
    }


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        String[] allowrdOrigins = corsOriginPatterns.split(",");
        registry
                .addMapping("/**")
//                .allowedMethods("GET","POST","PUT")
                .allowedMethods("*")
                .allowedOrigins(allowrdOrigins)
                .allowCredentials(true);
    }
}
