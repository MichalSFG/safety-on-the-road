package pl.jasm.roadsafety.home;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.jasm.roadsafety.advice.RoadAdvice;
import pl.jasm.roadsafety.advice.RoadAdviceService;
import pl.jasm.roadsafety.advice.comment.CommentService;
import pl.jasm.roadsafety.song.Song;

import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;
    private final RoadAdviceService roadAdviceService;
    private final CommentService commentService;

    public AdminController(AdminService adminService, RoadAdviceService roadAdviceService, CommentService commentService) {
        this.adminService = adminService;
        this.roadAdviceService = roadAdviceService;
        this.commentService = commentService;
    }

    @PostMapping("/addAdvice")
    public String addRoadAdvice(@RequestParam String url) {
        String adjusted = url.replace("watch?v=", "embed/");
        roadAdviceService.add(adjusted);
        return "redirect:/roadAdvice/all";
    }

    @GetMapping("/editAdvice")
    public String editRoadAdviceForm(@RequestParam Long id, Model model) {
        Optional<RoadAdvice> byId = roadAdviceService.findRoadAdviceById(id);
        byId.ifPresent(roadAdvice -> model.addAttribute("roadAdvice", roadAdvice));
        return "roadAdvice/edit";
    }

    @PostMapping("/editAdvice")
    public String editRoadAdvice(RoadAdvice roadAdvice) {
        roadAdviceService.update(roadAdvice);
        return "redirect:/roadAdvice/all";
    }

    @RequestMapping("/deleteAdvice/{id}")
    public String deleteRoadAdvice(@PathVariable Long id) {
        Optional<RoadAdvice> byId = roadAdviceService.findRoadAdviceById(id);
        byId.ifPresent(roadAdvice -> {
            commentService.getOriginalRoadAdviceComments(roadAdvice).forEach(commentService::delete);
            roadAdviceService.delete(roadAdvice);
        });
        return "redirect:/roadAdvice/all";
    }

    @RequestMapping("/")
    public String allSongs(Model model, Pageable pageable) {
        Page<Song> page = adminService.findAllSongs(pageable);
        model.addAttribute("songs", page);
        return "admin";
    }

    @PostMapping("/addSong")
    public String addSong(@RequestParam String url) {
        String modified = url.replace("watch?v=", "embed/");
        adminService.add(modified);
        return "redirect:/admin/";
    }
}
