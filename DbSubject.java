package com.mathpar.web.db.dao;

import com.mathpar.web.db.entity.Subject;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DbSubject {

    private NamedParameterJdbcTemplate jdbcTpl;

    public void save(Subject subj) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("name", subj.getSubjectName());
        parameters.put("teacher_id", subj.getTeacherId());
        jdbcTpl.update("INSERT INTO subject(name, teacher_id) VALUES (:name, :teacher_id)", parameters);
    }

}