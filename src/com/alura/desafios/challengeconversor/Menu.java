package com.alura.desafios.challengeconversor;

import java.util.Scanner;

public class Menu {
    private Scanner sc = new Scanner(System.in);

    public int mostrarYSeleccionarOpcion() {
        while (true) {
            System.out.println("*****************************************************************");
            System.out.println("**        Sea Bienvenido(a) al Conversor de Moneda =]          **");
            System.out.println("**                                                             **");
            System.out.println("**                 1) Dólar =>> Peso Argentino                 **");
            System.out.println("**                 2) Peso Argentino =>> Dólar                 **");
            System.out.println("**                 3) Dólar =>> Real Brasileño                 **");
            System.out.println("**                 4) Real Brasileño =>> Dólar                 **");
            System.out.println("**                 5) Dólar =>> Peso Colombiano                **");
            System.out.println("**                 6) Peso Colombiano =>> Dólar                **");
            System.out.println("**                 7) Salir                                    **");
            System.out.println("**                 Elija una opción válida:                    **");
            System.out.println("*****************************************************************");

            String opStr = sc.nextLine().trim();
            if (Validador.esOpcionValida(opStr)) {
                return Integer.parseInt(opStr);
            }
            System.out.println("Opción inválida");
        }
    }

    public double pedirMonto() {
        while (true) {
            System.out.println("Ingrese el valor que deseas convertir");
            String amtStr = sc.nextLine().trim();
            if (Validador.esMontoValido(amtStr)) {
                return Double.parseDouble(amtStr);
            }
            System.out.println("Valor inválido");
        }
    }
}
