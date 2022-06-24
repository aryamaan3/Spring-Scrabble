package partie;

import data.Message;
import data.PartieToJoueur;
import data.PayloadJoueur;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Component
public class PartieConsumer
{
    private static String myUrl = null;
    static
    {
        try
        {
            myUrl = InetAddress.getLocalHost().getHostAddress();
        }
        catch (UnknownHostException e)
        {
            e.printStackTrace();
        }
    }

    private final WebClient.Builder builder;

    public PartieConsumer(WebClient.Builder builder)
    {
        this.builder = builder;
    }

    void subscribe(String urlAppariement, int port, boolean isDocker)
    {
        String url = isDocker ? myUrl : "localhost";
        WebClient client = builder.baseUrl(urlAppariement).build();
        client.post()
                .uri("/freePartie")
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just("http://" + url + ":" + port), String.class)
                .retrieve()
                .bodyToMono(Message.class)
                .map(Message::getMessage)
                .block();
    }

    PayloadJoueur jouer(String url, PartieToJoueur messageToSend)
    {
        WebClient client = builder.baseUrl(url).build();
        return client.post()
                .uri("/jouer")
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(messageToSend), PartieToJoueur.class)
                .retrieve()
                .bodyToMono(PayloadJoueur.class)
                .block();
    }
}
