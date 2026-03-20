public class SemaforoInteligente extends DispositivoIoT implements Mantenible, ControlableRemotamente {
    private String estadoActual;

    public SemaforoInteligente(String id, String ubicacion, String estadoActual) {
        super(id, ubicacion);
        this.estadoActual = estadoActual;
    }

    @Override
    public double calcularCosteMantenimiento() {
        return 150;
    }

    @Override
    public void realizarMantenimiento() {
        System.out.println("El mantenimiento del semaforo " + getId() + " se ha realizado correctamente.");
    }

    @Override
    public boolean conectarWifi() {
        return true;
    }

    @Override
    public void reiniciarDispositivo() {
        System.out.println("El semáforo " + getId() + " se a reiniciado correctamente.");
    }

    @Override
    public void procesarDatos() {
        System.out.println("El semáforo "+ getId()+ " en " + getUbicacion() + " está " + this.estadoActual + ".");
    }
}