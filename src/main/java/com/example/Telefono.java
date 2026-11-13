package com.example;

// Subclase 1
public class Telefono extends Dispositivo {
    private int almacenamientoGB;
    private boolean tiene5G;

    public Telefono(String marca, String modelo, double precioBase, int anioLanzamiento, int almacenamientoGB, boolean tiene5G) {
        super(marca, modelo, precioBase, anioLanzamiento);
        if (almacenamientoGB <= 0) {
            throw new IllegalArgumentException("El almacenamiento debe ser mayor a cero.");
        }
        this.almacenamientoGB = almacenamientoGB;
        this.tiene5G = tiene5G;
    }

    /**
     * Lógica de negocio real: Los teléfonos con tecnología 5G tienen antenas y pantallas
     * más costosas de reparar, incrementando la póliza un 20%.
     */
    @Override
    public double calcularSeguroAnual(int anioActual) {
        double seguroBase = super.calcularSeguroAnual(anioActual);
        if (tiene5G) {
            return seguroBase * 1.20; // 20% más de costo en el seguro si es 5G
        }
        return seguroBase;
    }

    public int getAlmacenamientoGB() {
        return almacenamientoGB;
    }

    public void setAlmacenamientoGB(int almacenamientoGB) {
        if (almacenamientoGB <= 0) {
            throw new IllegalArgumentException("El almacenamiento debe ser mayor a cero.");
        }
        this.almacenamientoGB = almacenamientoGB;
    }

    public boolean isTiene5G() {
        return tiene5G;
    }

    public void setTiene5G(boolean tiene5G) {
        this.tiene5G = tiene5G;
    }

    @Override
    public String toString() {
        return super.toString() + ", Almacenamiento: " + almacenamientoGB + "GB, Red 5G: " + (tiene5G ? "Sí" : "No");
    }
}
