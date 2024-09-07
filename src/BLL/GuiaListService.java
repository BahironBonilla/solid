package BLL;

import DAL.IRepository;
import Entity.Guia;
import java.util.List;

public class GuiaListService {
    private final IRepository<Guia> guiaRepository;

    public GuiaListService(IRepository<Guia> guiaRepository) {
        this.guiaRepository = guiaRepository;
    }

    public List<Guia> obtenerGuias() {
        try {
            return guiaRepository.listar();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }
}
