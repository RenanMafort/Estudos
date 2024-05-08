package br.com.springboot3.repositories;

import br.com.springboot3.model.Person;
import br.com.springboot3.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepositorie extends JpaRepository<Person,Long> {

    @Modifying
    @Query("UPDATE Person p SET p.enabled = false WHERE p.id=:id")
    void disablePerson(@Param("id") Long id);


}
