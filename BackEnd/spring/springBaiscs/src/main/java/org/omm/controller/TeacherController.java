package org.omm.controller;

import org.omm.model.Teacher;
import org.omm.service.impl.TeacherServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TeacherController {
    @Autowired
    private TeacherServiceIMPL serviceIMPL;

    @GetMapping("/showAllTeachers")
    public String getALlTeachers(Model model) {
        model.addAttribute("teachers",serviceIMPL.getALLTeacher());
        return "showAllTeachers";
    }
    @GetMapping("/addTeacherPage")
    public String getAddPage(@ModelAttribute Teacher teacher) {
        return "addTeacherPage";
    }
    @PostMapping("/saveTeacher")
    public String saveOrUpdate(@ModelAttribute Teacher teacher) {
        if (teacher.getTeacher_id() == 0)
            serviceIMPL.saveTeacher(teacher);
        serviceIMPL.updateTeacher(teacher);
        return "redirect:/showAllTeachers";
    }
    @GetMapping("/updateTeacher")
    public String update(@RequestParam int id, Model model) {
        model.addAttribute("teacher",serviceIMPL.findTeacherById(id));
        return "addTeacherPage";
    }
    @DeleteMapping("/deleteTeacher")
    public String delete(@RequestParam int id) {
        return "redirect:/showALLTeachers";
    }
}
