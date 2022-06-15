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

    @GetMapping("/initPartie/{id1}/{url1}")
    public Message initPartie(@RequestParam(required = false) String val, @PathVariable("id1") int id, @PathVariable("url1") String playerUrl)
    {
        Message g = new Message("game completed with sucess");
        ArrayList<Integer> j = new ArrayList<>();
        j.add(id);
        ArrayList<String> urls = new ArrayList<>();
        urls.add(playerUrl);
        partie.setJoueurs(j, urls);
        return g;
    }

    @PostMapping("/initPartie")
    public Message initPartie(@RequestBody PlayerDetails playerData)
    {
        partie.setJoueurs(playerData);
        return new Message("game completed with sucess");
    }
}
