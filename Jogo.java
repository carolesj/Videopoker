/**
 * Created by caroles on 04/04/2017.
 */
public class Jogo {



    public static void main () {
        int aposta;
        Jogador pessoa = new Jogador();
        Baralho baralho = new Baralho();
        String trocaMao;
        do {
            System.out.println("Bem vindo ao Videopoker!");
            System.out.println("    Você tem " + pessoa.creditos + "créditos. O quanto você deseja apostar? " +
                    "   Digite um valor inválido de aposta (menor ou igual à zero) para sair.");
            aposta = EntradaTeclado.leInt();
            pessoa.apostados = aposta;
            pessoa.creditos -= aposta;
            Carta[] mao = baralho.tiraMao();
            System.out.println("    Sua mão é:");
            Baralho.printaMao(mao);
            System.out.println("    Deseja trocar alguma de suas cartas? Digite seus índices separados por espaços" +
                    " se sim e 'N' se não.");
            trocaMao = EntradaTeclado.leString();
            if (trocaMao != "N") {
                baralho.tiraMao(mao, trocaMao);
                Baralho.printaMao(mao);
                System.out.println("    Deseja trocar alguma de suas cartas? Digite seus índices separados por espaços" +
                        " se sim e 'N' se não.");
                if (trocaMao != "N") {
                    baralho.tiraMao(mao, trocaMao);
                    Baralho.printaMao(mao);
                }
            }


        } while (aposta > 0);



    }
}
