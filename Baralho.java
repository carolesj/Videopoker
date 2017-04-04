/**
 * Created by caroles on 04/04/2017.
 */

import java.util.Arrays;

public class Baralho {
    public Baralho () {
        int i, j;
        baralho = new Carta [52];
        //percorre o vetor, dividindo-o em 4 grupos (naipes) e colocando valores numéricos
        //que representam as cartas. 1 representa A, 11 representa J, 12 representa Q, 13
        //representa K
        for (i = 0; i < 5; i++) {
            for (j = 0; j < 13; j++) {
                baralho[i + j] = new Carta(j + 1, i + 1);
            }
        }
    }

    Carta baralho[];

    Random rand = new Random();

    public Carta tiraCarta () {
        int posicao;
        do {
            posicao = rand.getIntRand(51);
        } while (baralho[posicao].foi_tirada);
        baralho[posicao].foi_tirada = true;
        return baralho[posicao];
    }

    public Carta[] tiraMao () {
        Carta mao[];
        int posicao;
        mao = new Carta [5];
        for (int i = 0; i < 5; i++) {
            mao[i] = tiraCarta();
        }
        return mao;
    }

    public Carta[] tiraMao (Carta[] mao, String trocaMao) {
        String [] itens;
        itens = trocaMao.split(" ");
        for (int i = 0; i < itens.length; i++) {
            mao[Integer.parseInt(itens[i])] = tiraCarta();
        }
        return mao;
    }

    static public void printaMao (Carta[] mao) {
        for (int i = 0; i < 5; i++) {
            System.out.println("        "+ mao[i]);
        }
    }

    public int VerificaResultados (Carta[] mao) {
        int multiplicador, i;
        int [] quantidades;
        quantidades = new int[13];
        int pares, trinca;
        boolean quadra;
        for (i = 0; i < 5; i++) {
            quantidades[mao[i].numero]++;
        }
        for (i = 0; i < 13; i++) {
            if (quantidades[i] == 2) {
                pares++;
            }
            if (quantidades[i] == 3) {
                trinca++;
            }
            if (quantidades[i] == 4) {
                quadra = true;
            }
        }
        if (pares == 2) {
            multiplicador = 1;
        } else if (pares != 1 && trinca == 1) {
            multiplicador = 2;
        } else if (pares == 1 && trinca == 1) {
            multiplicador = 20;
        } else if (quadra) {
            multiplicador = 50;
        } else if () {

        }




        return multiplicador;
    }



}
