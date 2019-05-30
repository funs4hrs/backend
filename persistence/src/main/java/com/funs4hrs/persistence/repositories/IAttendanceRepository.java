package com.funs4hrs.persistence.repositories;

import com.funs4hrs.domain.models.Attendance;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository("AttendanceRepository")
@RepositoryRestResource(collectionResourceRel = "results",path = "attendances")
public interface IAttendanceRepository extends PagingAndSortingRepository<Attendance,Long> {
}
