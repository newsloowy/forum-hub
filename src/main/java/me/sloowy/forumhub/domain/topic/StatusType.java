package me.sloowy.forumhub.domain.topic;

public enum StatusType {
    NOT_ANSWERED("Tópico aguardando resposta..."),
    ANSWERED("Tópico respondido, possibilidade de haver soluções disponíveis."),
    SOLVED("Há soluções definitivas para esse tópico.");

    private String description;

    StatusType(String description) {
        this.description = description;
    }
}
