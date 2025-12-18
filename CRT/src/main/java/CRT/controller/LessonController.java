package CRT.controller;

import CRT.dto.LessonResponse;
import CRT.entity.Lesson;
import CRT.service.LessonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/lessons")
@CrossOrigin(origins = "*")
public class LessonController {

    private final LessonService service;

    public LessonController(LessonService service) {
        this.service = service;
    }

    @PostMapping
    public void addLessons(@RequestBody List<Lesson> lessons) {
        service.addLessons(lessons);
    }

    @GetMapping("/{category}")
    public List<Lesson> getLessons(@PathVariable String category) {
        return service.getLessonsByCategory(category);
    }
}
