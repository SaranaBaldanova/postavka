package ibs_gradle.demo.repository;

import ibs_gradle.demo.model.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentsRepository extends JpaRepository<Students, Long> {
    List<Students> findByFullNameContaining(String fullName);

    void deleteById(Long id);

    @Query("SELECT MAX(s.id) FROM Students s")
    Long findMaxId();
}
