package BLL;

import Entity.*;
public class searchGuiaResponse {
    private Guia guia;
    private String message;

    public searchGuiaResponse() {
    }

    public Guia getGuia() {
        return guia;
    }

    public void setGuia(Guia guia) {
        this.guia = guia;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
