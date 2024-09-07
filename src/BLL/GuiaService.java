package BLL;

import DAL.GuiaRepository;
import Entity.Guia;
import java.util.List;

public class GuiaService {
    private GuiaRepository repo;

    public GuiaService() {
        repo = new GuiaRepository();
    }

    public String addGuia(Guia guia) {
        try {
            repo.guardar(guia); // Renombrado de guardarGuia a guardar
            return "Se guardaron los datos de la guía satisfactoriamente";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String updateStateGuia(int numEnvio) {
        try {
            Guia guia = repo.recuperar(numEnvio); // Renombrado de searchGuia a recuperar
            if (guia != null) {
                guia.setEstadoEnvio("FINALIZADA");
                repo.guardar(guia); // Renombrado de updateGuia a guardar
                return "Se actualizó con éxito el estado de la entrega";
            }
            return "No se encontró la guía";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public GuiaListResponse getListGuia() {
        GuiaListResponse response = new GuiaListResponse();
        try {
            response.setGuias(repo.listar()); // Renombrado de getGuias a listar
            response.setMessage("");
        } catch (Exception e) {
            response.setMessage(e.getMessage());
        }
        return response;
    }
}
