package Presentation;

import BLL.*;
import DAL.GuiaRepository;
import Entity.Guia;
import Entity.Paquete;
import Entity.Remitente;
import Entity.SudCaja;
import Entity.SudPaquete;
import Entity.SudSobre;
import Entity.Destinatario;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static GuiaCreationService guiaCreationService = new GuiaCreationService(new GuiaRepository());
    private static GuiaStateUpdateService guiaStateUpdateService = new GuiaStateUpdateService(new GuiaRepository());
    private static GuiaListService guiaListService = new GuiaListService(new GuiaRepository());
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int option;
        boolean exit = false;
        while (!exit) {
            menu();
            option = sc.nextInt();
            switch (option) {
                case 1 -> guardarGuia();
                case 2 -> registrarEntrega();
                case 3 -> consultarGuias();
                case 4 -> exit = true;
                default -> System.out.println("¡Opción inválida!");
            }
        }
    }

    public static void menu() {
        System.out.println("-------- Menú --------");
        System.out.println("|1. Guardar Guía     |");
        System.out.println("|2. Registrar Entrega|");
        System.out.println("|3. Consultar Guías  |");
        System.out.println("|4. Salir            |");
        System.out.println("----------------------");
    }

    public static void guardarGuia() {
        Remitente remitente = new Remitente();
        Destinatario destinatario = new Destinatario();
        Paquete paquete;
        Guia guia = new Guia();

        // Capturar los datos del remitente
        sc.nextLine(); // Limpiar el buffer del scanner
        System.out.println("-------- Datos del Remitente --------");
        System.out.print("Ingrese la identificación del remitente: ");
        remitente.setId(sc.nextLine());
        System.out.print("Ingrese el nombre del remitente: ");
        remitente.setNombre(sc.nextLine());
        System.out.print("Ingrese el departamento del remitente: ");
        remitente.setDepartamento(sc.nextLine());
        System.out.print("Ingrese el teléfono del remitente: ");
        remitente.setTelefono(sc.nextLine());

        // Capturar los datos del destinatario
        System.out.println("-------- Datos del Destinatario --------");
        System.out.print("Ingrese la identificación del destinatario: ");
        destinatario.setId(sc.nextLine());
        System.out.print("Ingrese la compañía del destinatario: ");
        destinatario.setCompania(sc.nextLine());
        System.out.print("Ingrese el contacto del destinatario: ");
        destinatario.setContacto(sc.nextLine());
        System.out.print("Ingrese la calle del destinatario: ");
        destinatario.setCalle(sc.nextLine());
        System.out.print("Ingrese la colonia del destinatario: ");
        destinatario.setCol(sc.nextLine());
        System.out.print("Ingrese la ciudad del destinatario: ");
        destinatario.setCiudad(sc.nextLine());
        System.out.print("Ingrese el estado del destinatario: ");
        destinatario.setEstado(sc.nextLine());
        System.out.print("Ingrese el país del destinatario: ");
        destinatario.setPais(sc.nextLine());
        System.out.print("Ingrese el código postal del destinatario: ");
        destinatario.setCodigoPostal(sc.nextLine());

        // Capturar los datos del paquete
        System.out.println("-------- Datos del Paquete --------");
        System.out.print("Ingrese el tipo de paquete (1 = Paquete, 2 = Caja, 3 = Sobre): ");
        int tipoPaquete = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer

        switch (tipoPaquete) {
            case 1:
                paquete = new SudPaquete();
                break;
            case 2:
                paquete = new SudCaja();
                break;
            case 3:
                paquete = new SudSobre();
                break;
            default:
                System.out.println("Opción inválida. Se asignará un paquete por defecto.");
                paquete = new SudPaquete();
                break;
        }

        System.out.print("Ingrese el ID del paquete: ");
        paquete.setIdPaquete(sc.nextLine());
        System.out.print("Ingrese la cantidad de paquetes: ");
        paquete.setCantidad(sc.nextInt());
        System.out.print("Ingrese el peso del paquete: ");
        paquete.setPeso(sc.nextDouble());
        System.out.print("¿El paquete es internacional? (true/false): ");
        paquete.setDhl(sc.nextBoolean());
        sc.nextLine(); // Limpiar el buffer

        // Capturar los datos de la guía
        System.out.println("-------- Datos de la Guía --------");
        System.out.print("Ingrese el número de envío: ");
        guia.setNumEnvio(sc.nextInt());
        sc.nextLine(); // Limpiar el buffer
        System.out.print("Ingrese la fecha de envío (dd/MM/yyyy): ");
        guia.setFecha(sc.nextLine());
        guia.setRemitente(remitente);
        guia.setDestinatario(destinatario);
        guia.setPaquete(paquete);

        // Calcular el valor del envío basado en el paquete
        guia.setValorEnvio(paquete.calcularValor());

        // Guardar la guía
        String response = guiaCreationService.guardarGuia(guia);
        System.out.println("Respuesta: " + response);
    }

    public static void registrarEntrega() {
        System.out.println("---------- Registrar Entrega ----------");
        System.out.println("Ingrese número de envío: ");
        int numEnvio = sc.nextInt();
        String response = guiaStateUpdateService.actualizarEstadoGuia(numEnvio);
        System.out.println("Respuesta: " + response);
    }

    public static void consultarGuias() {
        List<Guia> guias = guiaListService.obtenerGuias();
        if (guias != null) {
            guias.forEach(System.out::println);
        }
    }
}
