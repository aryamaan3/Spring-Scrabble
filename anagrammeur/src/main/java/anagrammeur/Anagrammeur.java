package anagrammeur;

import plateau.Plateau;

import java.io.*;
import java.util.ArrayList;

public class Anagrammeur {

    private ArrayList<String> dictionnaire;
    private ArrayList<String> motPossible;
    private Plateau plateau;

    public Anagrammeur() throws IOException {
        //Instanciation du dictionnaire de mots
        dictionnaire = new ArrayList<>();
        initialiseDictionnaire();
    }

    /**
     * Ouvre le fichier : ./anagrammeur/liste_francais.txt
     * et place son contenu dans l'ArrayList dictionnaire
     * @throws IOException
     */
    private void initialiseDictionnaire() throws IOException {
        String fileName = "./anagrammeur/liste_francais.txt";
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        try {
            String line;
            while ((line = br.readLine()) != null) {
                dictionnaire.add(line);
            }
        } finally {
            br.close();
        }
    }

    private ArrayList<String> getDictionnaire(){
        return dictionnaire;
    }

    private ArrayList<String> getMotPossible(String lettres){
        //Trouve les mots possible par rapport au lettres
        return null;
    }

    private ArrayList<String> trouveMotLettre(String lettres, Plateau plateau){
        return null;
    }



}
