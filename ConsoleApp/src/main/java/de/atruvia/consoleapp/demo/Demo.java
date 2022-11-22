package de.atruvia.consoleapp.demo;


import javax.inject.Named;

@Named
public class Demo {

    private String name = "Herbert";

    public void foo() {
        System.out.println(name);
    }
}
