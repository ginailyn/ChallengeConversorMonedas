package com.alura.desafios.challengeconversor;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        ConversorAPI conversor = new ConversorAPI();

        while (true) {
            int opcion = menu.mostrarYSeleccionarOpcion();
            if (opcion == 7) {
                System.out.println("Gracias por usar el conversor. ¡Adiós!");
                break;
            }

            double amount = menu.pedirMonto();

            String moneda1 = "", moneda2 = "";
            switch (opcion) {
                case 1 -> { moneda1 = "USD"; moneda2 = "ARS"; }
                case 2 -> { moneda1 = "ARS"; moneda2 = "USD"; }
                case 3 -> { moneda1 = "USD"; moneda2 = "BRL"; }
                case 4 -> { moneda1 = "BRL"; moneda2 = "USD"; }
                case 5 -> { moneda1 = "USD"; moneda2 = "COP"; }
                case 6 -> { moneda1 = "COP"; moneda2 = "USD"; }
            }

            try {
                double resultado = conversor.convertir(moneda1, moneda2, amount);
                System.out.printf(
                        "El valor %.2f [%s] corresponde al valor final de =>> %.2f [%s]%n",
                        amount, moneda1, resultado, moneda2
                );
            } catch (RuntimeException e) {
                System.out.println("Error en la conversión: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());
            }
        }
    }
}