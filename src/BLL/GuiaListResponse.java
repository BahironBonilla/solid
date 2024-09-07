package BLL;

import Entity.Guia;

import java.util.List;

public  class GuiaListResponse{
    private List<Guia> guias;
    private String message;

    public GuiaListResponse() {
    }

    public GuiaListResponse(List<Guia> guias, String message) {
        this.guias = guias;
        this.message = message;
    }

    public List<Guia> getGuias() {
        return guias;
    }

    public void setGuias(List<Guia> guias) {
        this.guias = guias;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
