package com.example;

// Subclase 2
public class Portatil extends Dispositivo {
    private int memoriaRamGB;
    private boolean tieneGraficaDedicada;

    public Portatil(String marca, String modelo, double precioBase, int anioLanzamiento, int memoriaRamGB, boolean tieneGraficaDedicada) {
        super(marca, modelo, precioBase, anioLanzamiento);
        if (memoriaRamGB <= 0) {
            throw new IllegalArgumentException("La memoria RAM debe ser mayor a cero.");
        }
        this.memoriaRamGB = memoriaRamGB;
        this.tieneGraficaDedicada = tieneGraficaDedicada;
    }

    /**
     * Lógica de negocio real: Los portátiles de alto rendimiento (>16GB RAM) sufren mayor
     * desgaste térmico, por lo que su seguro aumenta un 25%.
     */
    @Override
    public double calcularSeguroAnual(int anioActual) {
        double seguroBase = super.calcularSeguroAnual(anioActual);
        if (this.memoriaRamGB > 16) {
            return seguroBase * 1.25; // 25% más por equipo de alto rendimiento
        }
        return seguroBase;
    }

    public int getMemoriaRamGB() {
        return memoriaRamGB;
    }

    public void setMemoriaRamGB(int memoriaRamGB) {
        if (memoriaRamGB <= 0) {
            throw new IllegalArgumentException("La memoria RAM debe ser mayor a cero.");
        }
        this.memoriaRamGB = memoriaRamGB;
    }

    public boolean isTieneGraficaDedicada() {
        return tieneGraficaDedicada;
    }

    public void setTieneGraficaDedicada(boolean tieneGraficaDedicada) {
        this.tieneGraficaDedicada = tieneGraficaDedicada;
    }

    @Override
    public String toString() {
        return super.toString() + ", RAM: " + memoriaRamGB + "GB, Gráfica Dedicada: " + (tieneGraficaDedicada ? "Sí" : "No");
    }
}
