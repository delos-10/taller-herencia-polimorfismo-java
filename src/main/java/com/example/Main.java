package com.example;

// Clase Principal de Prueba
public class Main {
    public static void main(String[] args) {
        int anioActual = 2026;

        Dispositivo[] inventario = {
            new Telefono("Samsung", "Galaxy S24", 1200, 2024, 256, true),
            new Portatil("ASUS", "ROG Strix", 1800, 2023, 32, true),
            new Consola("Sony", "PlayStation 5", 600, 2022, 1.0, 2)
        };

        for (Dispositivo d : inventario) {
            System.out.println(d.toString());
            System.out.println("Seguro anual calculado: $" + d.calcularSeguroAnual(anioActual));
            System.out.println("--------------------------------------------------");
        }
    }
}
