package com.example;

// Subclase 3
public class Consola extends Dispositivo {
    private double almacenamientoTB;
    private int numeroControles;

    public Consola(String marca, String modelo, double precioBase, int anioLanzamiento, double almacenamientoTB, int numeroControles) {
        super(marca, modelo, precioBase, anioLanzamiento);
        if (almacenamientoTB <= 0 || numeroControles < 1) {
            throw new IllegalArgumentException("El almacenamiento debe ser positivo y debe incluir al menos 1 control.");
        }
        this.almacenamientoTB = almacenamientoTB;
        this.numeroControles = numeroControles;
    }

    /**
     * Lógica de negocio real: Las consolas de videojuegos añaden un cargo fijo al seguro
     * por cada control incluido en el paquete ($15 por control).
     */
    @Override
    public double calcularSeguroAnual(int anioActual) {
        double seguroBase = super.calcularSeguroAnual(anioActual);
        // Se añade cobertura por cada control incluido
        return seguroBase + (this.numeroControles * 15.0);
    }

    public double getAlmacenamientoTB() {
        return almacenamientoTB;
    }

    public void setAlmacenamientoTB(double almacenamientoTB) {
        if (almacenamientoTB <= 0) {
            throw new IllegalArgumentException("El almacenamiento debe ser mayor a cero.");
        }
        this.almacenamientoTB = almacenamientoTB;
    }

    public int getNumeroControles() {
        return numeroControles;
    }

    public void setNumeroControles(int numeroControles) {
        if (numeroControles < 1) {
            throw new IllegalArgumentException("Debe incluir al menos 1 control.");
        }
        this.numeroControles = numeroControles;
    }

    @Override
    public String toString() {
        return super.toString() + ", Capacidad: " + almacenamientoTB + "TB, Controles: " + numeroControles;
    }
}
