package anagrammeur;

import data.Message;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Component
public class AnagrammeurConsumer
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

    public AnagrammeurConsumer(WebClient.Builder builder)
    {
        this.builder = builder;
    }

    void subscribe(String urlApp, int port, boolean isDocker)
    {
        String url = isDocker ? myUrl : "localhost";
        System.out.println("isDocker : " + isDocker + ", app : " + urlApp + ", mine :" + url + ":" + port);
        WebClient client = builder.baseUrl(urlApp).build();
        client.post()
                .uri("freeAnagrammeur")
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just("http://" + url + ":" + port), String.class)
                .retrieve()
                .bodyToMono(Message.class)
                .map(Message::getMessage)
                .block();
    }
}
