package org.omm.controller;

import jakarta.validation.Valid;
import org.omm.model.Student;
import org.omm.service.impl.StudentServiceIMPL;
import org.omm.validator.PhoneValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.text.SimpleDateFormat;

@Controller
public class StudentController {

    @Autowired
    private PhoneValidator validator;
    @Autowired
    private StudentServiceIMPL serviceIMPL;

    @GetMapping("/showAll")
    public String showAllPage(Model model) {
        model.addAttribute("students", serviceIMPL.getAlStudents());
        return "showAllPage";
    }
    @GetMapping("/addPage")
    public String addPage(@ModelAttribute Student student) {
        return "addPage";
    }

    @PostMapping("/save")
    public String saveOrUpdateStudent(@Valid @ModelAttribute Student student,
                              BindingResult bindingResult, Model model) {
        validator.validate(student,bindingResult);
        if (!bindingResult.hasErrors()) {
            if (student.getStudent_id() == 0)
                serviceIMPL.saveStudent(student);
            serviceIMPL.updateStudent(student);
            return "redirect:/showAll";
        }
        else
            return "addPage";
    }

    @GetMapping("/update/{id}")
    public String updateStudent(@PathVariable int id, Model model) {
        model.addAttribute("student", serviceIMPL.findStudentById(id));
        return "addPage";
    }

    @GetMapping("/delete")
    public String deleteStudent(@RequestParam int id) {
        serviceIMPL.deleteStudent(id);
        return "redirect:/showAll";
    }

//    This url is for pagination
    @GetMapping("/viewStudent")
    public String pagination(@RequestParam int id, Model model) {
        int total = 5;

        if (id == 1) {}
        else {
            id = (id-1) * total + 1;
        }
        System.out.println("PageId: "+ id);
        model.addAttribute("students",
                serviceIMPL.getStudentsByPage(id,total));
        return "showAllPage";
    }

    @PostMapping("/filter")
    public String searchStudent(@RequestParam String search, Model model) {
        System.out.println(search);
        model.addAttribute("students", serviceIMPL.getStudentsByAddress(search));
        return "showAllPage";
    }


    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        dataBinder.registerCustomEditor(Date.class,
                new CustomDateEditor(dateFormat, false));
        dataBinder.registerCustomEditor(String.class, "student_phone",
                new StringTrimmerEditor("",true));

//        dataBinder.addValidators(new PhoneValidator());
    }

}

