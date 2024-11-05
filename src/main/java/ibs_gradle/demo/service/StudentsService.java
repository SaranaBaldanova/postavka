package ibs_gradle.demo.service;

import ibs_gradle.demo.model.Students;
import ibs_gradle.demo.repository.StudentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentsService {

    private final StudentsRepository studentsRepository;

    public List<Students> getAllStudents() {
        return studentsRepository.findAll();
    }

    public Students getStudentById(Long id) {
        return studentsRepository.findById(id).orElse(null);
    }

    public Students createStudent(Students student) {
        // Устанавливаем id вручную
        Long maxId = studentsRepository.findMaxId();
        student.setId(maxId + 1);
        return studentsRepository.save(student);
    }
    public void deleteStudent(Long id) {
        studentsRepository.deleteById(id);
    }

    public List<Students> filterStudentsByFullName(String fullName) {
        return studentsRepository.findByFullNameContaining(fullName);
    }

    public List<Students> getAllStudentsSortedByFullName() {
        return studentsRepository.findAll(Sort.by("fullName"));
    }

    public List<Students> getAllStudentsSortedByEmail() {
        return studentsRepository.findAll(Sort.by("email"));
    }

    public List<Students> getAllStudentsSortedByPhone() {
        return studentsRepository.findAll(Sort.by("phoneNumber"));
    }

}