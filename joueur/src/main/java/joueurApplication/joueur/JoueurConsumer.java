package joueurApplication.joueur;

import data.Message;
import data.PayloadAnagrammeur;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Component
public class JoueurConsumer {
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
    private String urlAppariement = "";
    private final WebClient.Builder builder;

    public JoueurConsumer(WebClient.Builder builder)
    {
        this.builder = builder;
    }

    void subscribe(String urlAppariement, int port, boolean isDocker)
    {
        this.urlAppariement = urlAppariement;
        String url = isDocker ? myUrl : "localhost";
        WebClient client = builder.baseUrl(urlAppariement).build();
        client.post()
                .uri("/freeJoueur")
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just("http://" + url + ":" + port), String.class)
                .retrieve()
                .bodyToMono(Message.class)
                .map(Message::getMessage)
                .block();
    }

    String getFreeAnagrammeur()
    {
        WebClient client = builder.baseUrl(urlAppariement).build();
        return client.get()
                .uri("/getFreeAnagrammeur")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    PayloadAnagrammeur getMotPossible(String lettres, String urlAnagrammeur){
        WebClient client = builder.baseUrl(urlAnagrammeur).build();
        return client.get()
                .uri("/getMotPossible/"+lettres)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(PayloadAnagrammeur.class)
                .block();
    }
}
