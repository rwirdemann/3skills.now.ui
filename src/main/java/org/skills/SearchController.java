package org.skills;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class SearchController {

    @PostMapping("/search")
    public String search(@ModelAttribute Query query) {
        return "redirect:/result/" + query.getQ();
    }

    @GetMapping("/result/{q}")
    public String result(Model model, @PathVariable String q) {
        if (q != null && !"".equals(q)) {
            String[] split = q.split(",");
            if (split.length == 2) {
                q = split[0];
            }
        }

        model.addAttribute("cards", new ArrayList<>());

        if (q.toLowerCase().equals("java")) {
            model.addAttribute("cards", java());
        }

        if (q.toLowerCase().equals("c++")) {
            model.addAttribute("cards", cpp());
        }

        if (q.toLowerCase().equals("aws")) {
            model.addAttribute("cards", aws());
        }

        return "result";
    }

    private List<Card> java() {
        Card c1 = createCard("ralf", "Java");
        Card c2 = createCard("jing", "Java");
        Card c4 = createCard("baustert", "Java");
        return Arrays.asList(c1, c2, c4);
    }

    private List<Card> cpp() {
        Card c1 = createCard("frank", "C++");
        return Arrays.asList(c1);
    }

    private List<Card> aws() {
        Card c1 = createCard("marco", "AWS");
        return Arrays.asList(c1);
    }

    private Card createCard(String placeholder, String skill) {
        Card c2 = new Card();
        c2.setDescription("Ich programmiere seit 18 Jahren in Java und habe alles gesehen. Ich kann sehr gut lehren und programmiere gerne selber. ");
        c2.setImage(placeholder);
        c2.setSkill(skill);
        return c2;
    }

}