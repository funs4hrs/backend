package com.funs4hrs.rest.config;

import com.funs4hrs.domain.models.Attendance;
import com.funs4hrs.domain.models.Company;
import com.funs4hrs.domain.models.Project;
import com.funs4hrs.domain.models.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

@Configuration
public class RepositoryConfig extends RepositoryRestConfigurerAdapter {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(User.class);
        config.exposeIdsFor(Project.class);
        config.exposeIdsFor(Company.class);
        config.exposeIdsFor(Attendance.class);
    }
}
