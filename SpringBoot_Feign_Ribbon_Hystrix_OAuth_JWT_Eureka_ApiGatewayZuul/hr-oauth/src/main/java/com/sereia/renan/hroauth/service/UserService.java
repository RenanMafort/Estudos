package com.sereia.renan.hroauth.service;

import com.sereia.renan.hroauth.entities.User;
import com.sereia.renan.hroauth.feignclients.UserFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserFeignClient userFeignClient;

    public User findByEmail(String email){
        User body = userFeignClient.findByEmail(email).getBody();
        if (body == null){
            logger.error("Email not found: {}",email);
            throw new IllegalArgumentException("User notfound");
        }

        logger.info("Email found: {}",email);
        return body;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User body = userFeignClient.findByEmail(email).getBody();
        if (body == null){
            logger.error("Email not found: {}",email);
            throw new UsernameNotFoundException("User notfound");
        }
        logger.info("Email found: {}",email);
        return body;
    }
}
