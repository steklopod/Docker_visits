package steklopod;

import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@SpringBootApplication
public class Application {
    private static final Logger log = LoggerFactory.getLogger("application");
    private static final Map<String, AtomicInteger> visits = new HashMap<>();


    public static void main(String[] args) {
        log.info("Зайди на: http://192.168.99.100:8080 если запуск производиться из DOCKER");
        log.info("или   на: http://localhost:8080      если запускаешь локально");
        SpringApplication.run(Application.class, args);
    }


    @GetMapping
    public String home() throws UnknownHostException {
        String hostAddress = InetAddress.getLocalHost().getHostAddress();
        return "Привет! Твой хост адресс: " + hostAddress +
                "\n >>> Колличество визитов: [ " + getCountOfVisits(hostAddress) + " ] <<<";
    }

    @NotNull
    private static synchronized Integer getCountOfVisits(String hostAddress) {
        visits.putIfAbsent(hostAddress, new AtomicInteger(0));
        return visits.get(hostAddress).incrementAndGet();
    }


}
