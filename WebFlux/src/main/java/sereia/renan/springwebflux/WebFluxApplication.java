package sereia.renan.springwebflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import reactor.blockhound.BlockHound;

@SpringBootApplication
public class WebFluxApplication {
    static {
        BlockHound.install(s -> s.allowBlockingCallsInside("java.io.InputStream",
                "readNBytes")
                .allowBlockingCallsInside("java.io.FilterInputStream","read"));
    }

    public static void main(String[] args) {
        System.out.println(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("devrenan"));
        SpringApplication.run(WebFluxApplication.class, args);
    }

}
