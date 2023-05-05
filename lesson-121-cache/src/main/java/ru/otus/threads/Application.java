package ru.otus.threads;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Component;


@Component
@Slf4j
class Evaluator {

    @Cacheable("Evaluator-sum")
    public int sum(int a, int b) {
        log.info("... sum called: {} + {}", a, b);
        return a + b;
    }

    @Cacheable("Evaluator-mult")
    public int mult(int a, int b) {
        log.info("... mult called: {} * {}", a, b);
        return a * b;
    }

    @CacheEvict("Evaluator-sum")
    public void recalc(int a, int b) {
    }

    @CacheEvict(value = {"Evaluator-sum", "Evaluator-mult"}, allEntries = true)
    public void clearCache() {
    }
}

@SpringBootApplication
@EnableCaching
@Slf4j
public class Application {

    public static void main(String[] args) {
        var ctx = SpringApplication.run(Application.class, args);
        var bean = ctx.getBean(Evaluator.class);

        log.info("{}", bean.getClass());

        log.info("1. {}", bean.sum(1, 2));
        log.info("1. mult {}", bean.mult(1, 2));
        log.info("1. mult {}", bean.mult(1, 2));
        log.info("2. {}", bean.sum(1, 2));
        log.info("3. {}", bean.sum(1, 2));
        log.info("4. {}", bean.sum(1, 3));
        bean.recalc(1, 2);

        log.info("5. {}", bean.sum(1, 2));
        log.info("4. {}", bean.sum(1, 3));

        bean.recalc(1, 2);
        log.info("6. {}", bean.sum(1, 2));

    }

}
