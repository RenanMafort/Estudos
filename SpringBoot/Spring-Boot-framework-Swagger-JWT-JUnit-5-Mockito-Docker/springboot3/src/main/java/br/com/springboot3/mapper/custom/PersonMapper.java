package br.com.springboot3.mapper.custom;

import br.com.springboot3.data.vo.v2.v1.PersonVOV2;
import br.com.springboot3.model.Person;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonMapper {

    public PersonVOV2 converterEntityToVo(Person person){
        PersonVOV2 vo = new PersonVOV2();
        vo.setId(person.getId());
        vo.setFirstName(person.getFirstName());
        vo.setLastName(person.getLastName());
        vo.setAddres(person.getAddress());
        vo.setGender(person.getGender());
        vo.setBirthDay(new Date());
        return vo;
    }

    public Person converterVoToEntity(PersonVOV2 person){
        Person vo = new Person();
        vo.setId(person.getId());
        vo.setFirstName(person.getFirstName());
        vo.setLastName(person.getLastName());
        vo.setAddress(person.getAddres());
        vo.setGender(person.getGender());
        return vo;
    }

}
