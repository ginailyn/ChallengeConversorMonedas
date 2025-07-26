package com.alura.desafios.challengeconversor;

public class Validador {
    public static boolean esOpcionValida(String opStr) {
        return opStr != null && opStr.matches("[1-7]");
    }

    public static boolean esMontoValido(String amtStr) {
        return amtStr != null && amtStr.matches("\\d+(\\.\\d+)?");
    }
}