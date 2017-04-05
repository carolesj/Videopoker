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
        int i;
        int [] quantidades;
        quantidades = new int[13];
        int pares = 0, trinca = 0, n_uns = 0, primeiro_um = 0;
        boolean quadra = false, eh_flush, eh_straight = false;
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
        for (i = 0; i < 13; i++) {
            if (quantidades[i] == 1) {
                n_uns++;
            }
        }
        for (i = 1; i < 13; i++) {
            if (quantidades[i] == 1) {
                primeiro_um = i;
                break;
            }
        }


        /*o código daqui pra baixo verifica as possibilidades de ganhar e retorna o multiplicador da aposta*/
        //verifica a existência de dois pares
        if (pares == 2) {
            return 1;
        //verifica a existência de uma trinca
        } else if (pares != 1 && trinca == 1) {
            return 2;
        //verifica a existência de um full hand
        } else if (pares == 1 && trinca == 1) {
            return 20;
        //verifica a existência de uma quadra
        } else if (quadra) {
            return 50;
        }
        eh_flush = (mao[0].naipe == mao[1].naipe && mao[1].naipe == mao[2].naipe && mao[1].naipe == mao[3].naipe &&
                mao[1].naipe == mao[4].naipe);
        if (n_uns == 5 && primeiro_um == 10) {
            //verifica a existência de um straight flush
            if (eh_flush) {
                return 200;
            } else {
                return 5;
            }
        //verifica se existem 5 cartas com valores diferentes e a primeira é menor que 9
        } else if (n_uns == 5 && primeiro_um <= 9) {
            //verifica a existência de um straight
            eh_straight = (quantidades[primeiro_um + 1] + quantidades[primeiro_um + 2] +
                    quantidades[primeiro_um + 3] + quantidades[primeiro_um + 4] == 4);
        }
        //verifica a existência de um straight flush
        if (eh_straight && eh_flush) {
            return 100;
        //verifica a existência de um straight
        } else if (eh_straight) {
            return 5;
        //verifica a existência de um flush
        } else if (eh_flush) {
            return 10;
        //verifica a existência de um nada
        } else {
            return 0;
        }



    }



}
