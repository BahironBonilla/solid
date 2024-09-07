package DAL;

import Entity.Guia;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GuiaRepository implements IRepository<Guia> {
    private final String fileName = "data/GUIAS.txt";
    private final DestinatarioRepository destinatarioRepository;
    private final RemitenteRepository remitenteRepository;
    private final PaqueteRepository paqueteRepository;

    public GuiaRepository() {
        destinatarioRepository = new DestinatarioRepository();
        remitenteRepository = new RemitenteRepository();
        paqueteRepository = new PaqueteRepository();
    }

    @Override
    public void guardar(Guia guia) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true));
        bw.write(guia.toString());
        bw.newLine();
        bw.close();
        destinatarioRepository.guardar(guia.getDestinatario()); // Usamos el método guardar
        remitenteRepository.guardar(guia.getRemitente());
        paqueteRepository.guardar(guia.getPaquete());
    }

    @Override
    public Guia recuperar(int numEnvio) throws IOException {
        return listar().stream().filter(guia -> guia.getNumEnvio() == numEnvio).findFirst().orElse(null);
    }

    @Override
    public List<Guia> listar() throws IOException {
        List<Guia> guias = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = br.readLine()) != null) {
            String[] datos = line.split(",");
            Guia guia = new Guia();
            if (datos.length > 0) {
                guia.setNumEnvio(Integer.parseInt(datos[0]));
                guia.setFecha(datos[1]);
                guia.setValorEnvio(Double.parseDouble(datos[2]));
                guia.setEstadoEnvio(datos[3]);
                guia.setDestinatario(destinatarioRepository.recuperarDestinatario(Integer.parseInt(datos[0])));
                guia.setRemitente(remitenteRepository.recuperar(Integer.parseInt(datos[0])));
                guia.setPaquete(paqueteRepository.recuperarPaquete(Integer.parseInt(datos[0])));
            }
            guias.add(guia);
        }
        br.close();
        return guias;
    }
}
