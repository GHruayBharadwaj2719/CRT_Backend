package CRT.repository;

import CRT.entity.Problems;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProblemsRepository extends JpaRepository<Problems, Long> {
    List<Problems> findByLessonId(String lessonId);
}
