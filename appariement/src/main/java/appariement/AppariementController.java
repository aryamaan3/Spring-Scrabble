package appariement;

import data.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppariementController
{
    @Autowired
    Appariement app;

    @GetMapping("findPartie/{id}/{playerUrl}")
    public Message findPartie(@RequestParam(required = false) String val, @PathVariable("id") int id, @PathVariable("playerUrl") String playerUrl)
    {
        Message g = new Message("id = " + id + ", url = " + playerUrl);
        app.addJoueur(id, playerUrl);
        return g;
    }

    @GetMapping("freePartie/{partieUrl}")
    public Message freePartie(@RequestParam(required = false) String val, @PathVariable("partieUrl") String url)
    {
        Message g = new Message("url = " + url);
        app.addPartie(url);
        return g;
    }
}
