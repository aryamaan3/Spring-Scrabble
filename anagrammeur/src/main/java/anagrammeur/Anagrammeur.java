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
    private ArrayList<Case> caseExtension;
    private ArrayList<Case> posedCases;
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

    private void initCasePose(){
        posedCases = plateau.getPosedCase();
        initCaseExtended();
    }

    private void initCaseExtended(){
        posedCases.forEach((letter) -> {
            if(letter.getX()+1 < plateau.getLongeur() && plateau.getCase(letter.getX()+1, letter.getY()).isEmpty()){
                caseExtension.add(plateau.getCase(letter.getX()+1, letter.getY()));
            }
            if(letter.getY()+1 < plateau.getLargeur() && plateau.getCase(letter.getX(), letter.getY()+1).isEmpty()){
                caseExtension.add(plateau.getCase(letter.getX()+1, letter.getY()));
            }
            if(letter.getX()-1 > 0 && plateau.getCase(letter.getX()-1, letter.getY()).isEmpty()){
                caseExtension.add(plateau.getCase(letter.getX()+1, letter.getY()));
            }
            if(letter.getY()-1 > 0 && plateau.getCase(letter.getX(), letter.getY()-1).isEmpty()){
                caseExtension.add(plateau.getCase(letter.getX()+1, letter.getY()));
            }
        });
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
    public ArrayList<String> getMotPossible(String lettres){
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


    /*ArrayList<Case> getPositionMot(String lettres){
        ArrayList<Case> resu = new ArrayList<>();

        //PREMIER TOUR!!!
        //Premier mot trouvé
        if(posedCases.size() == 0){
            String motPossible = getMotPossible(lettres).get(0);
            Case centre = plateau.getCentre();
            int xCentre = centre.getX();
            int yCentre = centre.getY();

            for (int i=0 ; i<motPossible.length() ; i++){
                if(i==0){
                    centre.setValeur(motPossible.charAt(i));
                    resu.add(centre);
                }
                else{
                    plateau.getCase(xCentre + i, yCentre).setValeur(motPossible.charAt(i));
                    resu.add(plateau.getCase(xCentre + i, yCentre));
                }
            }
        }
        else {
            posedCases.forEach((caseRemplie) -> {
                char valPlateau = caseRemplie.getValeur();
                String temp = lettres+valPlateau;
                ArrayList<String> motsPossibles = getMotPossible(temp);
                for(int i = 0; i<motsPossibles.size();i++){
                    if(caseRemplie.getX()+motsPossibles.get(i).length()<plateau.getLongeur() && plateau.getCase(caseRemplie.getX()+1, caseRemplie.getY()).isEmpty()){
                        // ajouter les lettres
                    }
                    if(caseRemplie.getX()-motsPossibles.get(i).length()>0 && plateau.getCase(caseRemplie.getX()-1, caseRemplie.getY()).isEmpty()){
                        // ajouter les lettres
                    }
                    if(caseRemplie.getY()+motsPossibles.get(i).length()<plateau.getLargeur() && plateau.getCase(caseRemplie.getX(), caseRemplie.getY()+1).isEmpty()){
                        // ajouter les lettres
                    }
                    if(caseRemplie.getX()-motsPossibles.get(i).length()>0 && plateau.getCase(caseRemplie.getX()+1, caseRemplie.getY()-1).isEmpty()){
                        // ajouter les lettres
                    }
                }
                for (int i = 0; i<motsPossibles.size(); i++){
                    int position = motsPossibles.get(i).indexOf(valPlateau);
                    String beforePos = motsPossibles.get(i).substring(0, position);
                    String afterPos = motsPossibles.get(i).substring(position, motsPossibles.get(i).length());
                    for(int j = 0; j<motsPossibles.get(i).length(); j++){
                        //char val = motsPossibles.get(i).get(j);
                    }
                }
            });
        }


        return resu;
    }*/

    /*private ArrayList<Case> trouveMotLettre(String lettres, Plateau plateau) throws IOException {
        this.setPlateau(plateau);
        initCasePose();
        ArrayList<Case> cases = getPositionMot(lettres);
        return cases;
    }*/

}
