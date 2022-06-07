package anagrammeur;

import data.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnagrammeurController {

    @GetMapping("/anagrammeur")
    public Message anagrammeur(){
        Message g = new Message("Hello Partie, tu m'as trouvé!");
        return g;
    }
}
