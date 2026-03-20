public abstract class DispositivoIoT {
    private String id;
    private String ubicacion;
    private boolean encendido;

    public DispositivoIoT(String id, String ubicacion) {
        this.id = id;
        this.ubicacion = ubicacion;
        this.encendido = false;
    }

    public String getId() {
        return id;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public boolean isEncendido() {
        return encendido;
    }

    public void setEncendido(boolean encendido) {
        this.encendido = encendido;
    }

    public void setId(String id) {
        this.id = id;
    }
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void encender() {
        encendido = true;
        System.out.println(this.id + " se a encendido correctamente.");
    }

    public void apagar() {
        encendido = false;
        System.out.println(this.id + " apagado correctamente.");
    }

    public abstract void procesarDatos();
}