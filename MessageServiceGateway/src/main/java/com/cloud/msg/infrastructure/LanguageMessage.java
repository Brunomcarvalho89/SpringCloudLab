package com.cloud.msg.infrastructure;

/**
 *
 * @author brunomcarvalho89@gmail.com
 */
public enum LanguageMessage {

    ENGLISH("en-us"), PORTUGUESE("pt-br");

    private String language;

    private LanguageMessage(String language) {
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }

}
