/**
 * Created by caroles on 04/04/2017.
 */
public class Jogo {



    public static void main () {
        int aposta;
        Jogador pessoa = new Jogador();
        Baralho baralho = new Baralho();
        do {
            System.out.println("Bem vindo ao Videopoker!");
            System.out.println("    Você tem " + pessoa.creditos + "créditos. O quanto você deseja apostar? " +
                    "   Digite um valor inválido de aposta (menor ou igual à zero) para sair.");
            aposta = EntradaTeclado.leInt();
            pessoa.apostados = aposta;
            pessoa.creditos -= aposta;
            Carta[] mao = baralho.tira_mao();
            System.out.println("    Sua mão é:");
            System.out.println("    Deseja ti");
        } while (aposta > 0);



    }
}
