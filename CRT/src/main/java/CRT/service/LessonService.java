package CRT.service;

import CRT.dto.LessonResponse;
import CRT.entity.Lesson;
import CRT.repository.LessonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
public class LessonService {

    private final LessonRepository repo;

    public LessonService(LessonRepository repo) {
        this.repo = repo;
    }

    @Transactional
    public void addLessons(List<Lesson> lessons) {
        for (Lesson lesson : lessons) {
            if (!repo.existsById(lesson.getId())) {
                repo.save(lesson);
            }
        }
    }

    public List<Lesson> getLessonsByCategory(String category) {
        return repo.findByCategory(category);
    }
}
