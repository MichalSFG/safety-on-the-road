package pl.jasm.roadsafety.forum.subject;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Entity
@Data
@Table(name = "forumSubjects")
public class ForumSubject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String created;

    @PrePersist
    public void prePersist() {
        created = LocalDate.now().atTime(LocalTime.parse(LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm", Locale.GERMANY)))).toString().replace("T", " ");
    }
}
