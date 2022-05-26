package partie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PartieApplication {
    public static void main(String[] args)
    {
        SpringApplication.run(PartieApplication.class, args);
    }

    @Bean
    public CommandLineRunner init(@Autowired PartieConsumer app) {
        return args -> {
            app.subscribe();
        };
    }

    /*sabonnerAPArtie{

    }*/
}
