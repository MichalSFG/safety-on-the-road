package pl.jasm.roadsafety.advice.comment;

import lombok.Data;
import pl.jasm.roadsafety.advice.RoadAdvice;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nickname;
    private String opinion;
    private String created;

    @ManyToOne
    private RoadAdvice roadAdvice;

    @PrePersist
    public void prePersist() {
        created = LocalDateTime.now().toString();
    }
}
