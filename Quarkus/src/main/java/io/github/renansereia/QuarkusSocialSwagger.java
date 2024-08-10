package io.github.renansereia;

import jakarta.ws.rs.core.Application;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;

@OpenAPIDefinition(
        info = @Info(
                title = "RENAN MAFORT SEREIA",
                version = "1.0",
                contact = @Contact(
                        name = "Renan seire",
                        url = "www.google.com",
                        email = "renan__mafort@hotmail.com"
                ),
                license = @License(
                        name = "apacheeeeeee",
                        url = "https://apache.com"
                )
        )
)
public class QuarkusSocialSwagger extends Application {
}
