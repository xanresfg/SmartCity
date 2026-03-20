public class SensorContaminacion extends DispositivoIoT implements Mantenible {
    private double nivelCO2;

    public SensorContaminacion(String id, String ubicacion, double nivelCO2) {
        super(id, ubicacion);
        this.nivelCO2 = nivelCO2;
    }

    @Override
    public double calcularCosteMantenimiento() {
        return 50;
    }

    @Override
    public void realizarMantenimiento() {
        System.out.println("El mantenimiento del sensor " + getId() + " se ha realizado correctamente.");
    }

    @Override
    public void procesarDatos() {
        System.out.println("El sensor " + getId() + " tiene un nivel de CO2 de " + this.nivelCO2 + ".");
    }
}