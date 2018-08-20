import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yjw on 18-7-30.
 */

@RestController
@EnableAutoConfiguration
public class BbsDaemon {

    @RequestMapping("/")
    public String index() {
        return "welcome";
    }

    public static void main(String[] args ) {
        SpringApplication.run(BbsDaemon.class, args);
    }
}
