package org.skills;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SearchController {

    @PostMapping("/search")
    public String search() {
        return "redirect:/result";
    }

    @GetMapping("/result")
    public String result() {
        return "result";
    }

}