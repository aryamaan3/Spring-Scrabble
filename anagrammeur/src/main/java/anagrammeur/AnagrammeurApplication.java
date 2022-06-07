package anagrammeur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AnagrammeurApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(AnagrammeurApplication.class, args);
    }

    @Bean
    public CommandLineRunner init(@Autowired AnagrammeurConsumer client)
    {
        return args -> {
            client.subscribe();
        };
    }
}
