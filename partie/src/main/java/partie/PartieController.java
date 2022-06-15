package partie;

import data.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class PartieController
{
    @Autowired
    Partie partie;

    @GetMapping("/initPartie/{id1}/{url1}")
    public Message initPartie(@RequestParam(required = false) String val, @PathVariable("id1") int id, @PathVariable("url1") String playerUrl)
    {
        Message g = new Message("id = " + id + ", url = " + playerUrl);
        ArrayList<Integer> j = new ArrayList<>();
        j.add(id);
        ArrayList<String> urls = new ArrayList<>();
        urls.add(playerUrl);
        partie.setJoueurs(j, urls);
        return g;
    }
}
