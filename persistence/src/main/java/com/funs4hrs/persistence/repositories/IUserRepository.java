package com.funs4hrs.persistence.repositories;

import com.funs4hrs.domain.models.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository("UserRepository")
public interface IUserRepository extends PagingAndSortingRepository<User,Long> {
}
