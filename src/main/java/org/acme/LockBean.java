package org.acme;

import io.quarkus.arc.Lock;
import jakarta.enterprise.context.ApplicationScoped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
@Lock
public class LockBean {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public void method1() {
        logger.info("execute method1");
        method2();
    }

    public void method2() {
        logger.info("execute method2");
    }
}
