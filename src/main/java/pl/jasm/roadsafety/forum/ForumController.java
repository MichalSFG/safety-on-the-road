package pl.jasm.roadsafety.forum;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.jasm.roadsafety.forum.subject.ForumSubject;
import pl.jasm.roadsafety.forum.subject.ForumSubjectService;
import pl.jasm.roadsafety.forum.topicComment.TopicComment;
import pl.jasm.roadsafety.forum.topicComment.TopicCommentService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/forum")
@Slf4j
public class ForumController {

    private final ForumService forumService;
    private final ForumSubjectService forumSubjectService;
    private final TopicCommentService topicCommentService;

    public ForumController(ForumService forumService, ForumSubjectService forumSubjectService, TopicCommentService topicCommentService) {
        this.forumService = forumService;
        this.forumSubjectService = forumSubjectService;
        this.topicCommentService = topicCommentService;
    }

    @RequestMapping("/")
    public String forum(Model model) {
        List<ForumSubject> subjects = forumSubjectService.findAll();
        model.addAttribute("subjects", subjects);
        model.addAttribute("date", LocalDate.now());
        return "forum";
    }

    @RequestMapping("/subjectTopics")
    public String getForumSubjectTopics(@RequestParam Long id, Model model) {
        Optional<ForumSubject> byId = forumSubjectService.findById(id);
        byId.ifPresent(subject -> {
            model.addAttribute("subject", subject);
            model.addAttribute("topics", forumService.findAllByForumSubject(subject));
        });
        return "forum/topics";
    }

    @GetMapping("/addTopic/{subjectId}")
    public String addForumTopicForm(@PathVariable Long subjectId, Model model) {
        model.addAttribute("subjectId", subjectId);
        model.addAttribute("forumTopic", new ForumTopic());
        return "forum/addTopic";
    }

    @PostMapping("/addTopic")
    public String addForumTopic(@RequestParam Long subjectId, ForumTopic forumTopic) {
        Optional<ForumSubject> byId = forumSubjectService.findById(subjectId);
        byId.ifPresent(forumTopic::setForumSubject);
        forumService.add(forumTopic);
        return "redirect:/forum/";
    }

    @RequestMapping("/topicDetails/{topicId}")
    public String getTopicDetails(@PathVariable Long topicId, Model model) {
        Optional<ForumTopic> topicById = forumService.findTopicById(topicId);
        topicById.ifPresent(forumTopic -> {
            model.addAttribute("topic", forumTopic);
            model.addAttribute("comments", topicCommentService.findTopicCommentsByForumTopic(forumTopic));
        });
        model.addAttribute("topicComment", new TopicComment());
        return "forum/topicDetails";
    }

    @PostMapping("/addTopicComment")
    public String addTopicComment(TopicComment topicComment, @RequestParam Long topicId) {
        Optional<ForumTopic> topicById = forumService.findTopicById(topicId);
        topicById.ifPresent(forumTopic -> {
            topicComment.setAuthor("user");
            topicComment.setForumTopic(forumTopic);
            topicCommentService.add(topicComment);
        });
        return "redirect:/forum/";
    }
}
