package pl.jasm.roadsafety.advice.comment;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.jasm.roadsafety.advice.RoadAdvice;
import pl.jasm.roadsafety.advice.RoadAdviceService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;
    private final RoadAdviceService roadAdviceService;

    public CommentController(CommentService commentService, RoadAdviceService roadAdviceService) {
        this.commentService = commentService;
        this.roadAdviceService = roadAdviceService;
    }

    @RequestMapping("/all/{roadAdviceId}")
    public String allComments(@PathVariable Long roadAdviceId, Model model) {
        Optional<RoadAdvice> roadAdviceById = roadAdviceService.findRoadAdviceById(roadAdviceId);
        roadAdviceById.ifPresent(roadAdvice -> {
            List<Comment> comments = commentService.findRoadAdviceComments(roadAdvice);
            if (comments.size() == 0) {
                model.addAttribute("message", "Na razie nikt nie komentował tej porady!");
            }
            model.addAttribute("comments", comments);
        });
        return "roadAdvice/comment/all";
    }

    @GetMapping("/add/{id}")
    public String addCommentForm(Model model, @PathVariable Long id) {
        Optional<RoadAdvice> byId = roadAdviceService.findRoadAdviceById(id);
        byId.ifPresent(roadAdvice -> model.addAttribute("advice", roadAdvice));
        model.addAttribute("roadAdviceId", id);
        model.addAttribute("comment", new Comment());
        return "roadAdvice/comment/add";
    }

    @PostMapping("/add/{roadAdviceId}")
    public String addComment(Comment comment, @PathVariable Long roadAdviceId) {
        Optional<RoadAdvice> roadAdviceById = roadAdviceService.findRoadAdviceById(roadAdviceId);
        roadAdviceById.ifPresent(comment::setRoadAdvice);
        commentService.add(comment);
        return "redirect:/roadAdvice/all";
    }
}
