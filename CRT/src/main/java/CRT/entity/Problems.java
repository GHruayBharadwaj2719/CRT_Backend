package CRT.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "problems")
public class Problems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "lesson_id")
    private String lessonId;

    private String name;

    @Column(nullable = false)
    private String url;   // 🔗 WEBSITE LINK ONLY

    public Long getId() { return id; }

    public String getLessonId() { return lessonId; }
    public void setLessonId(String lessonId) { this.lessonId = lessonId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
}
