import java.util.ArrayList;
import java.util.Scanner;

public class GestorSmartCity {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<DispositivoIoT> redDispositivos = new ArrayList<>();

        int opcion;

        do {
            System.out.println("\n1. Añadir un nuevo dispositivo." +
                    "\n2. Mostrar estado de la red." +
                    "\n3. Lanzar mantenimiento global." +
                    "\n4. Reinicio remoto de emergencia." +
                    "\n5. Salir." +
                    "\nInserte una opcion:");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("\n1. Semaforo." +
                            "\n2. Sensor." +
                            "\n3. Panel." +
                            "\nInserte una opcion:");
                    int tipo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("ID: ");
                    String id = sc.nextLine();
                    System.out.print("Ubicacion: ");
                    String ubicacion = sc.nextLine();

                    switch (tipo) {
                        case 1:
                            System.out.println("\n1. Verde." +
                                    "\n2. Ambar." +
                                    "\n3. Rojo." +
                                    "\nInserte una opcion:");
                            int color = sc.nextInt();
                            sc.nextLine();

                            switch (color) {
                                case 1:
                                    redDispositivos.add(new SemaforoInteligente(id, ubicacion, "verde"));
                                    break;
                                case 2:
                                    redDispositivos.add(new SemaforoInteligente(id, ubicacion, "ambar"));
                                    break;
                                case 3:
                                    redDispositivos.add(new SemaforoInteligente(id, ubicacion, "rojo"));
                                    break;
                                default:
                                    System.out.println("Opcion no valida.");
                            }
                            break;

                        case 2:
                            System.out.println("\nInserta el nivel de CO2: ");
                            double nivel = sc.nextDouble();
                            sc.nextLine();

                            redDispositivos.add(new SensorContaminacion(id, ubicacion, nivel));
                            break;

                        case 3:
                            System.out.println("\nInserta un mensaje: ");
                            String mensaje = sc.nextLine();

                            redDispositivos.add(new PanelInformativo(id, ubicacion, mensaje));
                            break;

                        default:
                            System.out.println("Opción no valida.");
                    }
                    break;

                case 2:
                    for (DispositivoIoT cada_dispositivo : redDispositivos) {
                        cada_dispositivo.procesarDatos();
                    }
                    break;

                case 3:
                    double total = 0;
                    for (DispositivoIoT cada_dispositivo : redDispositivos) {
                        if (cada_dispositivo instanceof Mantenible) {
                            Mantenible mantenible1 = (Mantenible) cada_dispositivo;
                            mantenible1.realizarMantenimiento();
                            total += mantenible1.calcularCosteMantenimiento();
                        }
                    }
                    System.out.println("Coste total: " + total);
                    break;

                case 4:
                    for (DispositivoIoT cada_dispositivo : redDispositivos) {
                        if (cada_dispositivo instanceof ControlableRemotamente) {
                            ControlableRemotamente dRemoto = (ControlableRemotamente) cada_dispositivo;
                            if (1==1) {
                                dRemoto.reiniciarDispositivo();
                            }
                        }
                    }
                    break;

                case 5:
                    System.out.println("Cerrando.");
                    break;

                default:
                    System.out.println("Opcion no valida.");
            }
        } while (opcion != 5);

        sc.close();
    }
}