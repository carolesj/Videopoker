
public class Carta extends java.lang.Object{

    public Carta(int numero, int naipe) {
        this.numero = numero;
        this.naipe = naipe;
    }

    int numero;
    int naipe;
    boolean foi_tirada = false;

    @Override
    public String toString () {
        String retorno;
        if (numero == 1) {
            retorno = ".A de ";
        } else if (numero == 11) {
            retorno = ".J de ";
        } else if (numero == 12) {
            retorno = ".Q de ";
        } else if (numero == 13) {
            retorno = ".K de ";
        } else {
            retorno = ".%d de ";
        }
        if (naipe == 1) {
            retorno += "Paus";
        } else if (naipe == 2) {
            retorno += "Ouros";
        } else if (naipe == 3) {
            retorno += "Espadas";
        } else {
            retorno += "Copas";
        }
    }

}
