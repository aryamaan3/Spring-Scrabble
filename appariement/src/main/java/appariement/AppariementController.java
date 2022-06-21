package appariement;

import data.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AppariementController
{
    @Autowired
    Appariement app;

    @PostMapping("freeJoueur")
    public Message freeJoueur(@RequestBody String url)
    {
        System.out.println("player added");
        Message g = new Message("Player added");
        app.addJoueur(url);
        return g;
    }

    @PostMapping("freePartie")
    public Message freePartie(@RequestBody String url)
    {
        System.out.println("partie added");
        Message g = new Message("Partie added");
        app.addPartie(url);
        return g;
    }

    @PostMapping("freeAnagrammeur")
    public Message freeAnagrammeur(@RequestBody String url)
    {
        System.out.println("anagrammeur added");
        Message g = new Message("Anagrammeur added");
        app.addAnagrammeur(url);
        return g;
    }

    @GetMapping("getFreeAnagrammeur")
    public String getFreeAnagrammeur()
    {
        return app.getFreeAnagrammeur();
    }
}
