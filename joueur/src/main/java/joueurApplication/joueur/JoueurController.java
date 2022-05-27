package joueurApplication.joueur;

import data.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JoueurController {

    @GetMapping("/jouer")
    public Message jouer(){
        Message g = new Message("Hello Partie, tu m'as trouvé!");
        return g;
    }
}
