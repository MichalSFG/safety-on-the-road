package pl.jasm.roadsafety.forum;

import lombok.Data;
import pl.jasm.roadsafety.forum.subject.ForumSubject;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Entity
@Data
@Table(name = "forumTopics")
public class ForumTopic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String author;
    private String title;
    private String content;
    private String created;

    @ManyToOne
    private ForumSubject forumSubject;

    @PrePersist
    public void prePersist() {
        created = LocalDate.now().atTime(LocalTime.parse(LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm", Locale.GERMANY)))).toString().replace("T", " ");
    }
}
