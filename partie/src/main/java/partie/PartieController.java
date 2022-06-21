package partie;

import data.Message;
import data.PlayerDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class PartieController
{
    @Autowired
    Partie partie;

    @PostMapping("/initPartie")
    public Message initPartie(@RequestBody PlayerDetails playerData)
    {
        partie.setJoueurs(playerData);
        return new Message("game completed with sucess");
    }

    @GetMapping("/test")
    public Message test()
    {
        return new Message("test");
    }
}
