package anagrammeur;

import plateau.Case;
import plateau.Plateau;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Anagrammeur {

    private ArrayList<String> dictionnaire;
    private ArrayList<String> motsPossibles;
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
        String fileName = "liste_francais.txt";
        //String fileName = "./anagrammeur/liste_francais.txt";
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
     * @param lettres
     * @return
     */
    ArrayList<String> getMotPossible(String lettres){
        //Trouve les mots possible par rapport au lettres 1 er tour
        motsPossibles = new ArrayList<>();
        List<String> lettresSplit = new ArrayList<String>(Arrays.asList(lettres.split("")));
        for (int i =0; dictionnaire.size()>i; i++){
            List<String> motSplit = new ArrayList<String>(Arrays.asList(dictionnaire.get(i).split("")));
            if ((motSplit.containsAll(lettresSplit)) && (motSplit.size() == lettresSplit.size())){
                motsPossibles.add(dictionnaire.get(i));
                //dictionnaire.remove(i); après
            }
        }
        return motsPossibles;
    }

    ArrayList<Case> getPositionMot(String lettres){
        ArrayList<Case> resu = new ArrayList<>();

        //Premier mot trouvé
        String motPossible = getMotPossible(lettres).get(0);

        //PREMIER TOUR!!!
        Case centre = plateau.getCentre();
        int xCentre = centre.getX();
        int yCentre = centre.getY();

        for (int i=0 ; i<motPossible.length() ; i++){
            if(i==0){
                centre.setValeur(motPossible.charAt(i));
                resu.add(centre);
            }
            else{
                resu.add(plateau.getCase(xCentre + i, yCentre));
            }

        }
        //

        return resu;
    }

    private ArrayList<Case> trouveMotLettre(String lettres, Plateau plateau) throws IOException {
        this.setPlateau(plateau);
        ArrayList<Case> cases = getPositionMot(lettres);
        return cases;
    }

}