package sereia.renan.springwebflux.controller;

import org.springframework.security.crypto.factory.PasswordEncoderFactories;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(PasswordEncoderFactories.createDelegatingPasswordEncoder().upgradeEncoding("{bcrypt}$2a$10$fB2hU4ntzXtOzPfzla8u2OQVF5//DVuSs0BnOo9/pFGNxvXrVHCju"));

    }


}
