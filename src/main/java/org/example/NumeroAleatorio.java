package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class NumeroAleatorio {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random sort = new Random();

        List<Integer> acertos = new ArrayList<>();
        List<Integer> erros = new ArrayList<>();
        List<Integer> numerosProximos = new ArrayList<>();

        int totalPontos = 0;

        System.out.println("Vamos começar o Jogo?");
        System.out.println("Escolha o nivel que deseja jogar.");
        System.out.println("1 - Facil\n2 - Medio\n3 - Dificil");
        int nivel = sc.nextInt();
        int maximoNumeros = 0;

        switch (nivel) {
            case 1:
                maximoNumeros = 10;
                break;
            case 2:
                maximoNumeros = 50;
                break;
            case 3:
                maximoNumeros = 100;
                break;
            default:
                System.out.println("Nivel invalido. Vai entrar no nivel facil por padrão.");
                maximoNumeros = 10;
                break;

        }
        int jogadas = 0;

        while (true) {
            int sorteioNumeros = sort.nextInt(maximoNumeros) + 1;
            System.out.println("Digite um numero entre 1 e " + maximoNumeros + ":");
            int numeroUsuario;
            while (true) {
                numeroUsuario = sc.nextInt();
                if (numeroUsuario >= 1 && numeroUsuario <= maximoNumeros) {
                    break;
                } else {
                    System.out.println("Número inválido. Digite um número entre 1 e " + maximoNumeros + ":");
                }
            }

            if (numeroUsuario == sorteioNumeros) {
                System.out.println("Parabéns! Você acertou e ganhou 10 pontos!");
                acertos.add(sorteioNumeros);
                totalPontos += 10;
            } else if (Math.abs(numeroUsuario - sorteioNumeros) == 1) {
                System.out.println("Você está a apenas um número de distância. Ganhou 5 pontos.");
                acertos.add(sorteioNumeros);
                numerosProximos.add(numeroUsuario);
                totalPontos += 5;
            } else {
                System.out.println("Que pena você errou. Não ganhou pontos.");
                erros.add(sorteioNumeros);
            }

            jogadas++;
            System.out.println("Numero sorteado: " + sorteioNumeros);
            System.out.println("Pontuação total: " + totalPontos);
            System.out.println("Numeros que você acertou: " + acertos);
            System.out.println("Numeros que você errou: " + erros);

            System.out.println("Quer jogar de novo ? (S/N):");
            String resp;
            while (true) {
                resp = sc.next();
                if (resp.equalsIgnoreCase("s") || resp.equalsIgnoreCase("n")) {
                    break;
                } else {
                    System.out.println("Valor inválido. Digite 's' para sim ou 'n' para não.");
                }
            }

            if (resp.equalsIgnoreCase("n")) {
                break;
            }
        }

        System.out.println("Fim do Jogo!");
        System.out.println("Total de Jogadas: " + jogadas);
        System.out.println("Pontuação Final: " + totalPontos);
        sc.close();
    }
}
