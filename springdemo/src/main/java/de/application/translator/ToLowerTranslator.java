package de.application.translator;

public class ToLowerTranslator implements Translator{
    @Override
    public String translate(String message) {
        return message.toLowerCase();
    }
}
