package joueurApplication.joueur;

import data.Message;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class JoueurConsumer {

    static final String urlAppariement = "http://localhost:8082";
    static final String myUrl = "localhost:8081";
    static final String kHttp = "http://";
    //TODO : get id from dockerfile
    private static final int myId = 1;
    private final WebClient.Builder builder;

    public JoueurConsumer(WebClient.Builder builder)
    {
        this.builder = builder;
    }

    void subscribe()
    {
        WebClient client = builder.baseUrl(urlAppariement).build();
        client.get()
                .uri("/findPartie/"+myId+"/"+myUrl)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Message.class)
                .map(Message::getMessage)
                .block();
    }
}
