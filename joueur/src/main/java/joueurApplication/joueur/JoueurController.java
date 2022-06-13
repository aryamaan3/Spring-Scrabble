package joueurApplication.joueur;

import data.PayloadJoueur;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import plateau.Case;

import java.util.ArrayList;

@RestController
public class JoueurController {

    static ArrayList<Case> getJoueurResponse()
    {
        String MainDuJoueur = "axbfrhl";
        ArrayList<Case> List = new ArrayList<>();
        Case center = new Case(5);
        center.setX(6);
        center.setY(7);
        center.setValeur(MainDuJoueur.charAt(0));
        List.add(center);
        for (int i = 1; i < 3; i++) {
            Case c = new Case(0);
            c.setX(center.getX()+i);
            c.setY(center.getY());
            c.setValeur(MainDuJoueur.charAt(i));
            List.add(c);
        }
        return List;
    }

    @GetMapping("/jouer")
    public PayloadJoueur jouer(){
        return new PayloadJoueur(getJoueurResponse());
    }
}
