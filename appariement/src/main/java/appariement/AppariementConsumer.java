package appariement;

import data.Message;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class AppariementConsumer
{
    WebClient.Builder builder;
    public AppariementConsumer(WebClient.Builder builder)
    {
        this.builder = builder;
    }

    void creerPartie(String partieUrl, int joueurId, String joueurUrl)
    {
        WebClient client = builder.baseUrl(partieUrl).build();
        client.get()
                .uri("/initPartie/"+joueurId+"/"+joueurUrl)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Message.class)
                .map(Message::getMessage)
                .block();
    }
}
