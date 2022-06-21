package partie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PartieApplication
{
    @Value("${server.port}")
    private int port;

    public static void main(String[] args)
    {
        SpringApplication.run(PartieApplication.class, args);
    }

    @Bean
    public CommandLineRunner init(@Autowired PartieConsumer app)
    {
        return args ->
        {
            if (args.length > 1)
            {
                app.subscribe(args[0], port, Boolean.parseBoolean(args[1]));
            }
            else if(args.length == 1)
            {
                String[] newArgs = args[0].split(" ");
                if (newArgs.length > 1)
                {
                    app.subscribe(newArgs[0], port, Boolean.parseBoolean(newArgs[1]));
                }
            }
        };
    }
}
