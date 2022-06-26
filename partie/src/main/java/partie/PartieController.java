package partie;

import data.Message;
import data.PlayerDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

@RestController
public class PartieController
{
    @Autowired
    Partie partie;

    public void setPartieLinker(PartieConsumer linker)
    {
        partie.linker = linker;
    }

    @PostMapping("/initPartie")
    public Message initPartie(@RequestBody PlayerDetails playerData)
    {
        partie.setJoueurs(playerData);
        return new Message("game completed with sucess");
    }

    @GetMapping("/kill")
    public void kill()
    {
        killMySelf();
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
