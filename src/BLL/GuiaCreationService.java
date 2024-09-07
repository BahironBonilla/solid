package BLL;

import DAL.IRepository;
import Entity.Guia;

public class GuiaCreationService {
    private final IRepository<Guia> guiaRepository;

    public GuiaCreationService(IRepository<Guia> guiaRepository) {
        this.guiaRepository = guiaRepository;
    }

    public String guardarGuia(Guia guia) {
        try {
            guiaRepository.guardar(guia);
            return "Guía guardada con éxito";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
