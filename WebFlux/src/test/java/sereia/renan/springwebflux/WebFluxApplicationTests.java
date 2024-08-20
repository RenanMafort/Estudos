package sereia.renan.springwebflux;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.blockhound.BlockHound;

@SpringBootTest
class WebFluxApplicationTests {

    static {
        BlockHound.install();
    }

    @Test
    void contextLoads() {
    }

}
