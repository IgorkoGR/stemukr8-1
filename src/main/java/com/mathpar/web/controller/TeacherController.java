package com.mathpar.web.controller;

import com.mathpar.web.db.dao.DbGroups;
import com.mathpar.web.db.dao.DbUser;
import com.mathpar.web.db.dao.DbTasks;
import com.mathpar.web.db.entity.EduGroup;
import com.mathpar.web.db.entity.Task;
import com.mathpar.web.db.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/view/teacher")
public class TeacherController {

    private static final Logger LOG = LoggerFactory.getLogger(TeacherController.class);

    @Autowired
    private DbUser dbUser;

    @Autowired
    private DbGroups dbGroups;

    @RequestMapping(value = "/{teacherId}", method = RequestMethod.GET)
    public ModelAndView getTeacherCabineet(@PathVariable("teacherId") long teacherId) {
        String teacherName = dbUser.getUsernameByUserId(teacherId);

        Map<String, Object> model = new HashMap<>();
        model.put("teacher_name", teacherName);
        model.put("teacher_id", teacherId);
        System.out.println(teacherId + " " + teacherName);
        return new ModelAndView("teacher-cabinet", model);
    }

    @RequestMapping(value = "/{teacherId}/groups", method = RequestMethod.GET)
    public ModelAndView getTeacherGroups(@PathVariable("teacherId") long teacherId) {
        List<EduGroup> listGroups = dbGroups.getGroups();
        //HashMap<String, List<EduGroup>> model = new HashMap<>();
        HashMap<String, Object> model = new HashMap<>();
        model.put("group_list", listGroups);
        model.put("teacher_id", teacherId);
        return new ModelAndView("groups", model);
    }

    @RequestMapping(value = "/{teacherId}/groups/{groupId}", method = RequestMethod.GET)
    public ModelAndView getStudentsOfGroup(@PathVariable("groupId") long groupId) {
        List<User> listOfStudents = dbUser.getStudentsByGroup(groupId);
        HashMap<String, List<User>> model = new HashMap<>();
        model.put("student_list", listOfStudents);
        return new ModelAndView("studentOfGroups", model);
    }

    /*@RequestMapping(value = "/{teacherId}/tasks", method = RequestMethod.GET)
    public ModelAndView getAllTasks() {
        List<Task> listTask = dbTask.getAllTasks();
        HashMap<String, List<Task>> model = new HashMap<>();
        model.put("listTasks", listTask);
        return new ModelAndView("tasks", model);
    }

    @RequestMapping(value = "/{teacherId}/tasks/new_tasks", method = RequestMethod.GET)
    public ModelAndView setNewTasks() {
        return new ModelAndView("new-tasks");
    }

    @RequestMapping(value = "/{teacherId}/tasks/new_tasks", method = RequestMethod.POST)
    public ModelAndView setNewTask(@ModelAttribute("task") Task task) {
        dbTask.saveTask(task);
        return new ModelAndView("redirect:/view/teacher/{teacherId}/tasks");
    }*/

}
