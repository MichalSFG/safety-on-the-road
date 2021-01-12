package pl.jasm.roadsafety.home;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.jasm.roadsafety.advice.RoadAdvice;
import pl.jasm.roadsafety.advice.RoadAdviceService;
import pl.jasm.roadsafety.song.Song;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;
    private final RoadAdviceService roadAdviceService;

    public AdminController(AdminService adminService, RoadAdviceService roadAdviceService) {
        this.adminService = adminService;
        this.roadAdviceService = roadAdviceService;
    }

    @PostMapping("/addAdvice")
    public String addRoadAdvice(@RequestParam String url) {
        String adjusted = url.replace("watch?v=", "embed/");
        roadAdviceService.add(adjusted);
        return "redirect:/admin/advices";
    }

    @RequestMapping("/advices")
    public String allAdvices(Model model) {
        List<RoadAdvice> all = roadAdviceService.findAll();
        model.addAttribute("advices", all);
        return "index";
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
