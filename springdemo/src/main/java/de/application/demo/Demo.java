package de.application.demo;


import de.application.translator.Translator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(BeanDefinition.SCOPE_SINGLETON)
@Lazy
public class Demo {



    private  final Translator translator;



    // @Autowired
    public Demo(@Qualifier("upper") Translator translator) { // 1.)
        this.translator = translator;
        System.out.println("Ctor Demo");


    }

    public void init() { // 3.
        System.out.println(translator.translate("Demo doSomething wurde gerufen"));

    }

    public void rip() {
        System.out.println("Demo wird zerstört");
    }
}
