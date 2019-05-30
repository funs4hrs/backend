package com.funs4hrs.persistence.services;

import com.funs4hrs.domain.interfaces.ICRUD;
import com.funs4hrs.domain.models.Attendance;
import com.funs4hrs.persistence.repositories.IAttendanceRepository;
import com.funs4hrs.persistence.repositories.ICompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class AttendanceService implements ICRUD<Attendance, Long> {

    @Qualifier("AttendanceRepository")
    @Autowired
    private IAttendanceRepository repository;


    @Override
    public Attendance create(Attendance entity) {
        return repository.save(entity);
    }

    @Override
    public Attendance read(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Iterable<Attendance> readAll() {
        return repository.findAll();
    }

    @Override
    public Attendance update(Attendance entity) {
        return repository.save(entity);
    }

    @Override
    public boolean delete(Long id) {
        repository.deleteById(id);
        return true;
    }


    public Attendance readAllOpenByUserAndProject(Long user, Long project) {
        return repository.readAllOpenByUserAndProject(user,project);
    }
}
