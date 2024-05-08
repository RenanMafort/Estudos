package br.com.springboot3.services;

import br.com.springboot3.controller.PersonController;
import br.com.springboot3.data.vo.v1.PersonVO;
import br.com.springboot3.data.vo.v2.v1.PersonVOV2;
import br.com.springboot3.exception.ResourceNotFoundException;
import br.com.springboot3.mapper.DozzerMapper;
import br.com.springboot3.mapper.custom.PersonMapper;
import br.com.springboot3.model.Person;
import br.com.springboot3.repositories.PersonRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonServices {
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    private PersonRepositorie personRepositorie;

    @Autowired
    private PersonMapper mapper;

    @Autowired
    private PagedResourcesAssembler<PersonVO> assembler;

    public PersonVO createPerson(PersonVO person){
        logger.info("Creating person!");
        var entity = DozzerMapper.parseObject(person,Person.class);

        var vo =  DozzerMapper.parseObject(personRepositorie.save(entity), PersonVO.class);
        vo.add(linkTo(methodOn(PersonController.class).findById(vo.getKey())).withSelfRel());
        return vo;
    }

    public PersonVOV2 createPersonV2(PersonVOV2 personv2){
        logger.info("Creating person with version v2!");
        Person entity = mapper.converterVoToEntity(personv2);

        return mapper.converterEntityToVo(personRepositorie.save(entity));
    }

    public PersonVO updatePerson(PersonVO person){
        logger.info("Update person!");
        var entity = personRepositorie.findById(person.getKey()).orElseThrow(() ->
                new ResourceNotFoundException("No records found for this ID! "));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        var vo  =  DozzerMapper.parseObject(personRepositorie.save(entity), PersonVO.class);
        vo.add(linkTo(methodOn(PersonController.class).findById(vo.getKey())).withSelfRel());
        return vo;
    }

    public PersonVO findById(Long id){
        logger.info("Finding one Person!");

        var entity =  personRepositorie.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("No records found for this ID! "));

        var vo = DozzerMapper.parseObject(entity, PersonVO.class);
        vo.add(linkTo(methodOn(PersonController.class).findById(vo.getKey())).withSelfRel());
        return vo;
    }

    @Transactional
    public PersonVO disablePerson(Long id){
        logger.info("Disabling one Person!");

        var entity =  personRepositorie.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("No records found for this ID! "));

        personRepositorie.disablePerson(id);
        var vo = DozzerMapper.parseObject(entity, PersonVO.class);
        vo.add(linkTo(methodOn(PersonController.class).findById(vo.getKey())).withSelfRel());
        return vo;
    }

    public void delete(Long id){
        var entity = personRepositorie.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("No records found for this ID! "));

        personRepositorie.delete(entity);
    }

    public PagedModel<EntityModel<PersonVO>> findAll(Pageable pageable){
        Page<Person> personPage = personRepositorie.findAll(pageable);
        Page<PersonVO> map = personPage.map(p -> DozzerMapper.parseObject(p, PersonVO.class));
        Link link = linkTo(methodOn(PersonController.class).
                findAll(pageable.getPageNumber(), pageable.getPageSize(),pageable.getSort().toString())).withSelfRel();
        return assembler.toModel(map,link);
    }


}
