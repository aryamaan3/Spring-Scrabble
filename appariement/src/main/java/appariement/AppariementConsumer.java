package appariement;

import data.Message;
import data.PlayerDetails;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class AppariementConsumer
{
    private static final String kHttp = "http://";
    WebClient.Builder builder;
    public AppariementConsumer(WebClient.Builder builder)
    {
        this.builder = builder;
    }

    void creerPartie(String partieUrl, PlayerDetails playerData)
    {
        System.out.println("trying on : " + partieUrl);
        WebClient client = builder.baseUrl(partieUrl).build();
        client.post()
                .uri("/initPartie")
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(playerData), PlayerDetails.class)
                .retrieve()
                .bodyToMono(Message.class)
                .map(Message::getMessage)
                .block();
    }
}
