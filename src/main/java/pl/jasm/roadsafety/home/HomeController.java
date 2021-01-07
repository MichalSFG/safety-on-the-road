package pl.jasm.roadsafety.home;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.jasm.roadsafety.song.Song;

@Controller
@RequestMapping("/admin")
public class HomeController {

    private final AdminService adminService;

    public HomeController(AdminService adminService) {
        this.adminService = adminService;
    }

    @RequestMapping("/")
    public String hello(Model model, Pageable pageable) {
        Page<Song> page = adminService.findAllSongs(pageable);
        model.addAttribute("songs", page);
        return "index";
    }
}
