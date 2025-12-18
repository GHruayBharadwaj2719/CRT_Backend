package CRT.repository;
import CRT.entity.Notes;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface NoteRepository extends JpaRepository<Notes, Long> {
    List<Notes> findByLessonId(String lessonId);
}