package anagrammeur;

import data.Message;
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
    public ArrayList<String> getMotPossible(@RequestParam(required = false) String val, @PathVariable("lettres") String lettres){
        return anagrammeur.getMotPossible(lettres) ;
    }
}
