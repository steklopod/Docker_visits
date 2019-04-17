package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
@SpringBootApplication
public class Application {

    @GetMapping
    public String home() throws UnknownHostException {
        String hostAddress = InetAddress.getLocalHost().getHostAddress();
        System.out.println(hostAddress);
        return "Привет!  " + hostAddress;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
