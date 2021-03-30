package kr.co.shopwizard.web;

import kr.co.shopwizard.svc.MantncService;
import kr.co.shopwizard.web.dto.MantncResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final MantncService mantncService;

    @GetMapping("/")
    //public String index() { return "index"; }
    public String index(Model model) {
        model.addAttribute("mantncList", mantncService.findAll());
        return "index";
    }

    @GetMapping("/mantnc/save")
    public String mantncSave() { return "mantncSave"; }

    @GetMapping("/mantnc/update/{id}")
    public String mantncUpdate(@PathVariable Long id, Model model) {
        MantncResponseDto dto = mantncService.findById(id);
        model.addAttribute("mantnc", dto);
        return "mantncUpdate";
    }
}
