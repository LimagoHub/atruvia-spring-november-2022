package de.application.demo;


import de.application.translator.Translator;

public class Demo {

    private  Translator translator;

    public Translator getTranslator() {
        return translator;
    }

    public void setTranslator(Translator translator) {
        this.translator = translator;
    }

    public Demo() { // 1.)

        System.out.println("Ctor Demo");


    }

    public void init() { // 3.
        System.out.println(translator.translate("Demo doSomething wurde gerufen"));

    }

    public void rip() {
        System.out.println("Demo wird zerstört");
    }
}
