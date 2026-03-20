public class PanelInformativo extends DispositivoIoT implements ControlableRemotamente {
    private String textoMostrado;

    public PanelInformativo(String id, String ubicacion, String textoMostrado) {
        super(id, ubicacion);
        this.textoMostrado = textoMostrado;
    }

    @Override
    public boolean conectarWifi() {
        System.out.println("El panel " + getId() + " se a conectado al Wi-Fi correctamente.");
        return true;
    }

    @Override
    public void reiniciarDispositivo() {
        System.out.println("El panel " + getId() + " se a reiniciado correctamente.");
    }

    @Override
    public void procesarDatos() {
        System.out.println("El panel " + getId() + " en " + getUbicacion() + " muestra: " + this.textoMostrado + ".");
    }
}