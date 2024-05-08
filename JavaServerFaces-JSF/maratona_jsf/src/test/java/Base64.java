import br.com.dev.maratonajsf.model.Estudante;
import org.apache.commons.lang3.SerializationUtils;

import javax.crypto.KeyGenerator;
import javax.xml.transform.sax.SAXSource;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

/**
 * Created by Renan on 01/02/2023.
 */
public class Base64 {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(256);
        String key = java.util.Base64.getEncoder().encodeToString(keyGenerator.generateKey().getEncoded());

        System.out.println(key);

        System.out.println("UUID" + UUID.randomUUID());
    }
}
