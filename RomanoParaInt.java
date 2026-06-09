import java.util.Scanner;

public class RomanoParaInt {


    // parte que vai verificar a letra no numero romano e retornar o valor que ela vale.
    public static int valor(char letra) {
        switch (letra) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        System.out.println("Digite o número romano:");
        //essa string vai ler e deixar tudo padronizado caso o usuario digite as letras em minusculo.
        String romano = ler.nextLine().toUpperCase();

        int resultado = 0;

        //esse for vai fazer a comparação do valor atual para verificar se não se trata de um caso de subtração como IV.
        for (int i = 0; i < romano.length() - 1; i++) {

            //definindo valor atual e o proximo valor para comparação usando o switch declarado lá no começo do codigo. 
            int valorAtual = valor(romano.charAt(i));
            int proximoValor = valor(romano.charAt(i + 1));

            //parte que verifica se é subtração ou não
            if (valorAtual < proximoValor) {
                resultado -= valorAtual;
            } else {
                resultado += valorAtual;
            }
        }

        // ultimo valor do romano.lenght pois o for não calcula ele.
        resultado += valor(romano.charAt(romano.length() - 1));

        System.out.println("Resultado: " + resultado);

        ler.close();
    }
}