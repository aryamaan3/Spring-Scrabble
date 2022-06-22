package anagrammeur;

import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;
import plateau.Plateau;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class Anagrammeur {

    private ArrayList<String> dictionnaire = new ArrayList<String>();
    private Plateau plateau;

    public Anagrammeur() {
    }

    /**
     * Ouvre le fichier : ./anagrammeur/liste_francais.txt
     * et place son contenu dans l'ArrayList dictionnaire
     */
    public void initialiseDictionnaire() throws IOException {
        String fileName = "anagrammeur/liste_francais.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                dictionnaire.add(line);
            }
        }
    }


    ArrayList<String> getDictionnaire(){
        return dictionnaire;
    }

    public Plateau getPlateau() {
        return plateau;
    }

    public void setPlateau(Plateau plateau) {
        this.plateau = plateau;
    }

    /**
     * Recherche dans le dictionnaire les mots possibles
     */
    public ArrayList<String> getMotPossible(String lettres) throws IOException {
        //Trouve les mots possible par rapport au lettres 1 er tour
        this.initialiseDictionnaire();
        ArrayList<String> motsPossibles = new ArrayList<>();
        List<String> lettresSplit = new ArrayList<String>(Arrays.asList(lettres.split("")));
        for (String s : dictionnaire) {
            List<String> motSplit = new ArrayList<String>(Arrays.asList(s.split("")));
            if ((motSplit.containsAll(lettresSplit)) && (motSplit.size() == lettresSplit.size())){
                motsPossibles.add(s);
            }
        }
        System.out.println("Lettres envoyés par un joueur : " + lettres);
        System.out.println("Listes de mots possible : " + motsPossibles);
        return motsPossibles;
    }

}
