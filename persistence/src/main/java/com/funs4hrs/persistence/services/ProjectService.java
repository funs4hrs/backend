package com.funs4hrs.persistence.services;

import com.funs4hrs.domain.interfaces.ICRUD;
import com.funs4hrs.domain.models.Project;
import com.funs4hrs.domain.models.User;
import com.funs4hrs.persistence.repositories.IProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;

@Service
public class ProjectService implements ICRUD<Project,Long> {


    @Qualifier("ProjectRepository")
    @Autowired
    private IProjectRepository repository;


    @Override
    public Project create(Project entity) {
        return repository.save(entity);
    }

    @Override
    public Project read(Long id) {
        if (repository.findById(id).isPresent())
            return repository.findById(id).get();
        else
            return null;
    }

    @Override
    public Iterable<Project> readAll() {
        return repository.findAll();
    }

    @Override
    public Project update(Project entity) {
        try {
            Project project = repository.findById(entity.getIdentifier()).get();

            Field[] fields = project.getClass().getDeclaredFields();

            for (Field f : fields){
                f.setAccessible(true);
                f.get(entity);
                f.set(project, f.get(entity));
            }

            return repository.save(project);

        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean delete(Long id) {
        repository.deleteById(id);
        return true;
    }

    public List<Project> readByUser(User user){ return null;}
}
