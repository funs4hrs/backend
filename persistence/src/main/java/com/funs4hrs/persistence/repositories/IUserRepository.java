package com.funs4hrs.persistence.repositories;

import com.funs4hrs.domain.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("UserRepository")
public interface IUserRepository extends PagingAndSortingRepository<User,Long> {

    @Query("SELECT u FROM User u WHERE u.Email = :email AND u.Password = :password")
    public User findByEmailAndPassword(@Param("email") String email, @Param("password") String password);
}
