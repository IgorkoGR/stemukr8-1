package com.mathpar.web.controller;

import com.mathpar.web.db.dao.DbSubject;
import com.mathpar.web.db.dao.DbUser;
import com.mathpar.web.db.entity.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/view/teacher")
public class TeacherController {
    private static final Logger LOG = LoggerFactory.getLogger(TeacherController.class);

    private DbUser dbUser;
    private DbSubject dbSubject;

    @Autowired
    public void setDbUser(DbUser dbUser) {
        this.dbUser = dbUser;
    }

    @RequestMapping(value = "/{teacherId}", method = RequestMethod.GET)
    public ModelAndView getTeacherCabineet(@PathVariable("teacherId") long teacherId) {
        String teacherName = dbUser.getUsernameByUserId(teacherId);

        Map<String, Object> model = new HashMap<>();
        model.put("teacher_name", teacherName);
        return new ModelAndView("teacher-cabinet", model);
    }

    @RequestMapping(value = "/{teacherId}/subjects", method = RequestMethod.GET)
    public ModelAndView getTeacherSubject(@PathVariable("teacherId") long teacherId) {
        List<Subject> subjectList = dbSubject.getSubjectByTeacherId(teacherId);
        HashMap<String, List<Subject>> model = new HashMap<>();
        model.put("subject_list", subjectList);
        return new ModelAndView("teacher_subject", model);
    }

}
