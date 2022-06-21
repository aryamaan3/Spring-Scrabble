package joueurApplication.joueur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JoueurApplication
{
    @Value("${server.port}")
    private int port;

    public static void main(String[] args)
    {
        SpringApplication.run(JoueurApplication.class, args);
    }

    @Bean
    public CommandLineRunner init(@Autowired JoueurConsumer client)
    {
        return args ->
        {
            if (args.length > 1)
            {
                client.subscribe(args[0], port, Boolean.parseBoolean(args[1]));
            }
            else if(args.length == 1)
            {
                String[] newArgs = args[0].split(" ");
                if (newArgs.length > 1)
                {
                    client.subscribe(newArgs[0], port, Boolean.parseBoolean(newArgs[1]));
                }
            }
        };
    }
}
