package steklopod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
@SpringBootApplication
public class Application {
    private static final Logger log = LoggerFactory.getLogger("application");

    public static void main(String[] args) {
        log.info("Зайди на: http://192.168.99.100:8080");
        SpringApplication.run(Application.class, args);
    }


    @GetMapping
    public String home() throws UnknownHostException {
        String hostAddress = InetAddress.getLocalHost().getHostAddress();
        log.info("hostAddress: " + hostAddress);
        return "Привет! Твой хост адресс: " + hostAddress;
    }


}
