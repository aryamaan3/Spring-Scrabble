package partie;

import data.Message;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

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

    String jouer(String url)
    {
        WebClient client = builder.baseUrl(url).build();
        return client.get()
                .uri("/jouer")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Message.class)
                .map(Message::getMessage)
                .block();
    }
}
