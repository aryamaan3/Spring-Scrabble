package joueurApplication.joueur;

import data.PartieToJoueur;
import data.PayloadJoueur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import plateau.Placement;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

@RestController
public class JoueurController {
    @Autowired
    Joueur joueur;

    @PostMapping("/jouer")
    public PayloadJoueur jouer(@RequestBody PartieToJoueur message)
    {
        return new PayloadJoueur(joueur.jouer(message.getBoard(), message.getMain()));
    }

    @GetMapping("/kill")
    public void kill()
    {
        killMySelf();
    }

    void killMySelf()
    {
        Thread t = new Thread(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.exit(0);
            }

        });
        t.start();
    }
}
