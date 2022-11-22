package de.atruvia.consoleapp.runner;

import de.atruvia.consoleapp.demo.Demo;
import org.springframework.boot.CommandLineRunner;


import javax.inject.Inject;
import javax.inject.Named;

@Named
public class MyCommandlineRunner implements CommandLineRunner {

    @Inject
    private Demo demo;

    @Override
    public void run(String... args) throws Exception {
        demo.foo();
    }
}
