package partie;

import data.Message;
import data.PayloadJoueur;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import plateau.Case;
import plateau.Plateau;

import java.util.ArrayList;

@Component
public class PartieConsumer
{
    private static final String urlAppariement = "http://localhost:8082";
    private static final String myUrl = "localhost:8080";
    private final WebClient.Builder builder;

    public PartieConsumer(WebClient.Builder builder)
    {
        this.builder = builder;
    }

    /*public PartieConsumer()
    {
        this.builder = null;
    }*/

    void subscribe()
    {
        WebClient client = builder.baseUrl(urlAppariement).build();
        client.get()
                .uri("/freePartie/"+myUrl)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Message.class)
                .map(Message::getMessage)
                .block();
    }

    ArrayList<Case> jouer(String url, Plateau plateau, String MainDuJoueur)
    {
        WebClient client = builder.baseUrl(url).build();
        return client.get()
                .uri("/jouer")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(PayloadJoueur.class)
                .map(PayloadJoueur::getPayloadJoueur)
                .block();
    }
}
