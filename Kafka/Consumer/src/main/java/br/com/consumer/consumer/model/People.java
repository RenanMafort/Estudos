package br.com.consumer.consumer.model;

import lombok.*;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.*;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class People implements Serializable, Deserializer<People> {
    private String name;
    private String middleName;

    private String lastName;
    private Short old;

    @Override
    public People deserialize(String s, byte[] bytes) {
        try{
            ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            return (People) objectInputStream.readObject();

        }catch (IOException |ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
