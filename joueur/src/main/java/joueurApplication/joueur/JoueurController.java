package joueurApplication.joueur;

import data.PartieToJoueur;
import data.PayloadJoueur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import plateau.Placement;

import java.util.ArrayList;

@RestController
public class JoueurController {
    @Autowired
    Joueur joueur;

    static ArrayList<Placement> getJoueurResponse(String main)
    {
        ArrayList<Placement> List = new ArrayList<>();
        Placement center = new Placement(main.charAt(0), 6, 7);
        List.add(center);
        for (int i = 1; i < 3; i++) {
            Placement c = new Placement(main.charAt(i), center.getX()+i, center.getY());
            List.add(c);
        }
        return List;
    }

    @PostMapping("/jouer")
    public PayloadJoueur jouer(@RequestBody PartieToJoueur message) {
        return new PayloadJoueur(joueur.jouer(message.getBoard(), message.getMain()));
    }
}
