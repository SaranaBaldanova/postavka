package ibs_gradle.demo.controller;


import ibs_gradle.demo.model.Students;
import ibs_gradle.demo.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;


@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentsService studentsService;

    @GetMapping
    public String getAllStudents(Model model, @RequestParam(required = false) String sort) {
        List<Students> students;
        if (Objects.nonNull(sort) && sort.equals("fullName")) {
            students = studentsService.getAllStudentsSortedByFullName();
        } else if (Objects.nonNull(sort) && sort.equals("email")) {
            students = studentsService.getAllStudentsSortedByEmail();
        } else if(Objects.nonNull(sort) && sort.equals("phone")) {
            students=studentsService.getAllStudentsSortedByPhone();
        }else {
            students = studentsService.getAllStudents();
        }
        model.addAttribute("students", students);
        return "students";
    }

    @GetMapping("/{id}")
    public String getStudentById(@PathVariable Long id, Model model) {
        Students student = studentsService.getStudentById(id);
        model.addAttribute("student", student);
        return "student-details";
    }

    @GetMapping("/add")
    public String showAddStudentForm(Model model) {
        model.addAttribute("student", new Students());
        return "add-student";
    }

    @PostMapping("/add")
    public String addStudent(@ModelAttribute Students student) {

        studentsService.createStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentsService.deleteStudent(id);
        return "redirect:/students";
    }

    @GetMapping("/filter")
    public String filterStudentsByFullName(@RequestParam String fullName, Model model) {
        List<Students> students = studentsService.filterStudentsByFullName(fullName);
        model.addAttribute("students", students);
        return "students";
    }
}