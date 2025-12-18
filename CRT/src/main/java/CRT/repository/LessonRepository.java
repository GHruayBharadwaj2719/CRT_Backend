package CRT.repository;

import CRT.dto.LessonResponse;
import CRT.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
public interface LessonRepository extends JpaRepository<Lesson, String> {
    List<Lesson> findByCategory(String category);
}
