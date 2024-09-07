package BLL;

import DAL.IRepository;
import Entity.Guia;

public class GuiaStateUpdateService {
    private final IRepository<Guia> guiaRepository;

    public GuiaStateUpdateService(IRepository<Guia> guiaRepository) {
        this.guiaRepository = guiaRepository;
    }

    public String actualizarEstadoGuia(int numEnvio) {
        try {
            Guia guia = guiaRepository.recuperar(numEnvio);
            if (guia != null) {
                guia.setEstadoEnvio("FINALIZADA");
                guiaRepository.guardar(guia);
                return "Estado actualizado correctamente";
            }
            return "Guía no encontrada";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
