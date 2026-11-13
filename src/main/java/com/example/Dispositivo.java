package com.example;

// Clase Padre
public class Dispositivo {
    protected String marca;
    protected String modelo;
    protected double precioBase;
    protected int anioLanzamiento;

    public Dispositivo(String marca, String modelo, double precioBase, int anioLanzamiento) {
        this.marca = marca;
        this.modelo = modelo;
        setPrecioBase(precioBase);
        setAnioLanzamiento(anioLanzamiento);
    }

    /**
     * Lógica de negocio real: Calcula el costo del seguro y garantía anual del dispositivo
     * basándose en sus años en el mercado y su precio base.
     */
    public double calcularSeguroAnual(int anioActual) {
        int antiguedad = anioActual - this.anioLanzamiento;
        if (antiguedad < 0) {
            throw new IllegalArgumentException("El año de lanzamiento no puede ser mayor al año actual.");
        }
        // Costo estándar del seguro: 6% del precio base más 1% por cada año de antigüedad
        return this.precioBase * (0.06 + (0.01 * antiguedad));
    }

    public void setPrecioBase(double precioBase) {
        if (precioBase <= 0) {
            throw new IllegalArgumentException("El precio base debe ser mayor a cero.");
        }
        this.precioBase = precioBase;
    }

    public void setAnioLanzamiento(int anioLanzamiento) {
        if (anioLanzamiento < 2000) { // Año mínimo de referencia para dispositivos modernos
            throw new IllegalArgumentException("Año de lanzamiento inválido.");
        }
        this.anioLanzamiento = anioLanzamiento;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public int getAnioLanzamiento() {
        return anioLanzamiento;
    }

    @Override
    public String toString() {
        return "Marca: " + marca + ", Modelo: " + modelo + ", Año: " + anioLanzamiento + ", Precio Base: $" + precioBase;
    }
}
