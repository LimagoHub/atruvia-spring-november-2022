package de.application.translator;

public class ToUpperTranslator implements Translator{
    @Override
    public String translate(String message) {
        return message.toUpperCase();
    }
}
