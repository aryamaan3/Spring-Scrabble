package anagrammeur;

import data.PayloadAnagrammeur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

@RestController
public class AnagrammeurController {

    @Autowired
    Anagrammeur anagrammeur;

    @GetMapping("/getMotPossible/{lettres}")
    public PayloadAnagrammeur getMotPossible(@RequestParam(required = false) String val, @PathVariable("lettres") String lettres) throws IOException {
        //ArrayList<String> test = new ArrayList<>();
        //test.add("yakuzas");
        //return new PayloadAnagrammeur(anagrammeur.getMotPossible(lettres)) ;
        ArrayList<String> resultats = anagrammeur.getMotPossible(lettres);
        return new PayloadAnagrammeur(resultats) ;

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
