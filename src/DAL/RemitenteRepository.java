package DAL;

import Entity.Remitente;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RemitenteRepository implements IRepository<Remitente> {
    private final String fileName = "data/remitentes.txt";

    @Override
    public void guardar(Remitente remitente) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true));
        bw.write(remitente.toString());
        bw.newLine();
        bw.close();
    }

    @Override
    public Remitente recuperar(int id) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        Remitente remitente = new Remitente();
        while ((line = br.readLine()) != null) {
            String[] datos = line.split(",");
            if (datos[0].equals(String.valueOf(id))) {
                remitente.setId(datos[0]);
                remitente.setNombre(datos[1]);
                remitente.setDepartamento(datos[2]);
                remitente.setTelefono(datos[3]);
            }
        }
        br.close();
        return remitente;
    }

    @Override
    public List<Remitente> listar() throws IOException {
        List<Remitente> remitentes = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = br.readLine()) != null) {
            String[] datos = line.split(",");
            Remitente remitente = new Remitente();
            remitente.setId(datos[0]);
            remitente.setNombre(datos[1]);
            remitente.setDepartamento(datos[2]);
            remitente.setTelefono(datos[3]);
            remitentes.add(remitente);
        }
        br.close();
        return remitentes;
    }
}
