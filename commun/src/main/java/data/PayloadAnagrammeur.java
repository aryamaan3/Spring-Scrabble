package data;

import java.util.ArrayList;

public class PayloadAnagrammeur {

    private ArrayList<String> response;

    public PayloadAnagrammeur() {
    }

    public PayloadAnagrammeur(ArrayList<String> message) {
        this.response = message;
    }

    public ArrayList<String> getPayloadJoueur() {
        return this.response;
    }

    public void setPayloadJoueur(ArrayList<String> message) {
        this.response = message;
    }

    @Override
    public String toString() {
        return "PayloadAnagrammeur{" +
                "response=" + response +
                '}';
    }
}
