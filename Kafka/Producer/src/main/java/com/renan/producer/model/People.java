package com.renan.producer.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.apache.kafka.common.serialization.Serializer;

import java.io.*;

@Getter
@Setter
@RequiredArgsConstructor
@EqualsAndHashCode
public class People implements Serializable, Serializer<People> {

    private String name;
    private String middleName;

    private String lastName;
    private Short old;

    @Override
    public byte[] serialize(String s, People people) {
        try {
            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(bytes);
            objectOutputStream.writeObject(people);
            objectOutputStream.flush();
            return bytes.toByteArray();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return new byte[0];
    }
}
