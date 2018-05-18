package org.skills;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class SearchController {

    @PostMapping("/search")
    public String search() {
        return "redirect:/result";
    }

    @GetMapping("/result")
    public String result(Model model) {
        Card c1 = createCard("r1", "Java");
        Card c2 = createCard("jing", "C++");
        Card c4 = createCard("baustert", "Java");

        List<Card> cards = Arrays.asList(c1, c2, c4);
        model.addAttribute("cards", cards);
        return "result";
    }

    private Card createCard(String placeholder, String skill) {
        Card c2 = new Card();
        c2.setDescription("Ich programmiere seit 18 Jahren in Java und habe alles gesehen. Ich kann sehr gut lehren und programmiere gerne selber. ");
        c2.setImage(placeholder);
        c2.setSkill(skill);
        return c2;
    }

}