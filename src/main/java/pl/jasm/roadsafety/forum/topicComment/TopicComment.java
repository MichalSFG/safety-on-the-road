package pl.jasm.roadsafety.forum.topicComment;

import lombok.Data;
import pl.jasm.roadsafety.forum.ForumTopic;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

@Entity
@Data
@Table(name = "forumTopicComments")
public class TopicComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String author;
    private String content;
    private String created;

    @ManyToOne
    private ForumTopic forumTopic;

    @PrePersist
    public void prePersist() {
        created = LocalDate.now().atTime(LocalTime.parse(LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm", Locale.GERMANY)))).toString().replace("T", " ");
    }
}
