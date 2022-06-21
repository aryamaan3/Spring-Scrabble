package anagrammeur;

import data.PayloadAnagrammeur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class AnagrammeurController {

    @Autowired
    Anagrammeur anagrammeur;

    @GetMapping("/getMotPossible/{lettres}")
    public PayloadAnagrammeur getMotPossible(@RequestParam(required = false) String val, @PathVariable("lettres") String lettres){
        ArrayList<String> test = new ArrayList<>();
        test.add("yakuzas");
        //return new PayloadAnagrammeur(anagrammeur.getMotPossible(lettres)) ;
        return new PayloadAnagrammeur(test) ;

    }
}
