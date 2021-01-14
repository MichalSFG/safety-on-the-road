package pl.jasm.roadsafety.advice;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/roadAdvice")
public class RoadAdviceController {

    private final RoadAdviceService roadAdviceService;

    public RoadAdviceController(RoadAdviceService roadAdviceService) {
        this.roadAdviceService = roadAdviceService;
    }

    @RequestMapping("/all")
    public String allAdvices(Model model) {
        List<RoadAdvice> all = roadAdviceService.findAll();
        model.addAttribute("date", LocalDate.now());
        model.addAttribute("advices", all);
        return "index";
    }
}
