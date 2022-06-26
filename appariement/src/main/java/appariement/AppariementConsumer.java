package appariement;

import data.Message;
import data.PlayerDetails;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

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

    //only for travis to finish sucessfully
    void killAll(String partieUrl, List<String> urls, Queue<String> anagrammeurUrls)
    {
        urls.add(partieUrl);

        while (anagrammeurUrls.size() > 0)
        {
            urls.add(anagrammeurUrls.poll());
        }

        for (var url : urls)
        {
            WebClient client = builder.baseUrl(url).build();
            client.get()
                    .uri("/kill")
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
        }
    }

    void killMySelf()
    {
        Thread t = new Thread(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.exit(0);
            }

        });
        t.start();
    }
}
