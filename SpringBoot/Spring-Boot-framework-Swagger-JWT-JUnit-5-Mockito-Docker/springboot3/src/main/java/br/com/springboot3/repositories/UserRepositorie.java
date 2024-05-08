package br.com.springboot3.repositories;

import br.com.springboot3.model.Person;
import br.com.springboot3.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositorie extends JpaRepository<User,Long> {

    @Query("SELECT u FROM User u WHERE u.userName =:userName")
    User findByUserName(@Param("userName") String userName);
}
