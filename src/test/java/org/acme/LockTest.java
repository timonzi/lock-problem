package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.junit.jupiter.api.Test;

@QuarkusTest
class LockTest {

    private final ExecutorService threadPool = Executors.newCachedThreadPool();

    @Inject
    LockBean lockBean;

    @Test
    void testLocks() throws ExecutionException, InterruptedException {
        final var futures = new ArrayList<Future<String>>();
        for (int i = 0; i < 10; i++) {
            final Future<String> submit = threadPool.submit(() -> {
                lockBean.method1();
                return "value";
            });
            futures.add(submit);
        }

        for (final var future : futures) {
            future.get();
        }

    }

}