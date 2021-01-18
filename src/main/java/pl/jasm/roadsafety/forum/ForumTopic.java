package pl.jasm.roadsafety.forum;

import lombok.Data;
import pl.jasm.roadsafety.forum.subject.ForumSubject;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

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
        created = LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT, FormatStyle.SHORT));
    }
}
