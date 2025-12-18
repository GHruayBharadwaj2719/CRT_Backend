package CRT.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;
import java.util.Map;

@Entity
@Table(name = "lessons")
public class Lesson {

    @Id
    private String id;

    private String category;
    private String title;
    private String duration;

    // ===== JSONB FIELDS =====

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private List<String> topics;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private Map<String, Object> notes;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private List<Map<String, String>> problems;

    // ===== GETTERS =====
    public String getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public String getTitle() {
        return title;
    }

    public String getDuration() {
        return duration;
    }

    public List<String> getTopics() {
        return topics;
    }

    public Map<String, Object> getNotes() {
        return notes;
    }

    public List<Map<String, String>> getProblems() {
        return problems;
    }

    // ===== SETTERS =====
    public void setId(String id) {
        this.id = id;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setTopics(List<String> topics) {
        this.topics = topics;
    }

    public void setNotes(Map<String, Object> notes) {
        this.notes = notes;
    }

    public void setProblems(List<Map<String, String>> problems) {
        this.problems = problems;
    }
}
