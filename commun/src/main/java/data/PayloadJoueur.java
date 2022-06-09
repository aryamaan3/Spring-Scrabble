package data;

import plateau.Case;

import java.util.ArrayList;

public class PayloadJoueur {

    private ArrayList<Case> response;

    public PayloadJoueur() {
    }

    public PayloadJoueur(ArrayList<Case> message) {
        this.response = message;
    }

    public ArrayList<Case> getPayloadJoueur() {
        return this.response;
    }

    public void setPayloadJoueur(ArrayList<Case> message) {
        this.response = message;
    }

    @Override
    public String toString() {
        return "PayloadJoueur{" +
                "response=" + response +
                '}';
    }
}
