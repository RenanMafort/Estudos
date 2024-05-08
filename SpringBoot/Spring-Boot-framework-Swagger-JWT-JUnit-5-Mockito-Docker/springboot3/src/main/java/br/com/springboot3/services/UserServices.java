package br.com.springboot3.services;

import br.com.springboot3.controller.PersonController;
import br.com.springboot3.data.vo.v1.PersonVO;
import br.com.springboot3.data.vo.v2.v1.PersonVOV2;
import br.com.springboot3.exception.ResourceNotFoundException;
import br.com.springboot3.mapper.DozzerMapper;
import br.com.springboot3.mapper.custom.PersonMapper;
import br.com.springboot3.model.Person;
import br.com.springboot3.model.User;
import br.com.springboot3.repositories.PersonRepositorie;
import br.com.springboot3.repositories.UserRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class UserServices implements UserDetailsService {
    private Logger logger = Logger.getLogger(UserServices.class.getName());

    @Autowired
    private UserRepositorie userRepositorie;

    public UserServices(UserRepositorie userRepositorie) {
        this.userRepositorie = userRepositorie;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("Finding one User!");
        User user = userRepositorie.findByUserName(username);
        if (user != null) {
            return user;
        }else {
            throw new UsernameNotFoundException("UserName " + username + " not found!");
        }
    }
}
