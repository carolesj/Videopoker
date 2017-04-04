/**
 * Created by caroles on 04/04/2017.
 */

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
    public Carta[] tira_mao () {
        Carta mao[];
        int posicao;
        mao = new Carta [5];
        for (int i = 0; i < 5; i++) {
            do {
                posicao = rand.getIntRand(51);
            } while (baralho[posicao].foi_tirada);
            mao[i] = baralho[posicao];
            baralho[posicao].foi_tirada = true;
        }
        return mao;
    }

    public void printa_mao (Carta[] mao) {
        for (int i = 0; i < 5; i++) {
            System.out.println("        "+ mao[i]);
        }
    }



}
