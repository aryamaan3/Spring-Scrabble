package data;

import plateau.Placement;

import java.util.ArrayList;

public class PayloadJoueur {

    private ArrayList<Placement> response;

    public PayloadJoueur() {
    }

    public PayloadJoueur(ArrayList<Placement> message) {
        this.response = message;
    }

    public ArrayList<Placement> getPayloadJoueur() {
        return this.response;
    }

    public void setPayloadJoueur(ArrayList<Placement> message) {
        this.response = message;
    }

    @Override
    public String toString() {
        return "PayloadJoueur{" +
                "response=" + response +
                '}';
    }
}
