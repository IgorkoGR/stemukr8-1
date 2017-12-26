package com.mathpar.web.db.dao;

import com.mathpar.web.db.entity.EduGroup;
import com.mathpar.web.db.entity.mappers.EduGroupMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DbGroups {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<EduGroup> getGroups() {
        return jdbcTemplate.query("SELECT * FROM edu_groups", new EduGroupMapper());
    }

}