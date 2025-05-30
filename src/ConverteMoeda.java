import java.util.Scanner;

public class Conversor {
    public static void main(String[] args) {
       double valor = 0;
       String moeda;
       int opcao = 0;

       String menu = """
               ==================================================================================================================
                       Escolha uma das opções abaixo para efetivar a conversão:
                       1 - Dolar [USD] --> Real brasileiro [BRL]
                       2 - Real brasileiro [BRL] --> Dolar [USD]
                       3 - Yuan chinesa [CNY] --> Real brasileiro [BRL]
                       4 - Real brasileiro [BRL] --> Yuan chinesa [CNY]
                       5 - Shekel israelense [ILS] --> Real brasileiro [BRL]
                       6 - Real brasileiro [BRL] --> Shekel israelense [ILS] 
                       7 - Sair
               ==================================================================================================================
             \n """;

        Scanner leitura = new Scanner(System.in);
        System.out.println("Seja bem vindo(a) ao nosso conversor de moedas:\n ");


        int sair = 7;
        while (opcao !=7) {
            System.out.println(menu);
            opcao = leitura.nextInt();

            if (opcao == 1) {
                System.out.println("O valor" + " " + valor + "convertido é: " +" valor convertido" + " " );
            }

        }




    }
}
