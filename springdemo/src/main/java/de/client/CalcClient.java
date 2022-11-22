package de.client;

import de.math.Calculator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


@Component
public class CalcClient {

    private final Calculator calculator;

    public CalcClient(@Qualifier("secure") Calculator calculator) {
        this.calculator = calculator;
    }

    @PostConstruct
    public void go() {

        System.out.println(calculator.add(3,2));
    }

    @PreDestroy
    public void dispose() {

        System.out.println("... und Tschuess");
    }
}
