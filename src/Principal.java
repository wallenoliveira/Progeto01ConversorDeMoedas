import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException {

        int opcao = 0;
        double valorDigitado = 0.0;

        ConverteMoeda converteMoeda = new ConverteMoeda();
        GeradorDeArquivo gerador = new GeradorDeArquivo();

        String menu = """
                                     Seja bem vindo(a) ao nosso Conversor de moedas
                =====================================================================================
                1 - Dolar [USD] --> Real brasileiro [BRL]
                2 - Real brasileiro [BRL] --> Dolar [USD]
                3 - Bolívar venezuelano [VES] --> Real brasileiro [BRL]
                4 - Real brasileiro [BRL] --> Bolívar venezuelano [VES]
                5 - Shekel israelense [ILS] --> Real brasileiro [BRL]
                6 - Real brasileiro [BRL] --> Shekel israelense [ILS]
                7 - Sair
                =====================================================================================

                """;
        Scanner leitura = new Scanner(System.in);

        while (opcao != 7) {
            System.out.println(menu);
            System.out.print("Digite uma opção válida: "); // Changed println to print for better flow

            try {
                opcao = leitura.nextInt();

                if (opcao == 1) {
                    System.out.print("Digite o valor em Dólar (USD): ");
                    valorDigitado = leitura.nextDouble();
                    TaxaDeConversao novaTaxaDeConversao = converteMoeda.buscaMoeda("USD");
                    gerador.salvaJson(novaTaxaDeConversao);
                    Double taxa = novaTaxaDeConversao.conversion_rates().get("BRL");
                    if (taxa != null) {
                        double valorConvertido = valorDigitado * taxa;
                        System.out.println("O valor de " + valorDigitado + " USD convertido para Real brasileiro é: " + String.format("%.2f", valorConvertido) + " BRL");
                    } else {
                        System.out.println("Erro: Taxa de câmbio de USD para BRL não encontrada.");
                    }
                } else if (opcao == 2) {
                    System.out.print("Digite o valor em Real (BRL): ");
                    valorDigitado = leitura.nextDouble();
                    TaxaDeConversao novaTaxaDeConversao = converteMoeda.buscaMoeda("BRL"); // Base currency is BRL
                    gerador.salvaJson(novaTaxaDeConversao);
                    Double taxa = novaTaxaDeConversao.conversion_rates().get("USD"); // Get rate for USD
                    if (taxa != null) {
                        double valorConvertido = valorDigitado * taxa;
                        System.out.println("O valor de " + valorDigitado + " BRL convertido para Dólar (USD) é: " + String.format("%.2f", valorConvertido) + " USD");
                    } else {
                        System.out.println("Erro: Taxa de câmbio de BRL para USD não encontrada.");
                    }
                } else if (opcao == 3) {
                    System.out.print("Digite o valor em Bolívar venezuelano (VES): ");
                    valorDigitado = leitura.nextDouble();
                    TaxaDeConversao novaTaxaDeConversao = converteMoeda.buscaMoeda("VES");
                    gerador.salvaJson(novaTaxaDeConversao);
                    Double taxa = novaTaxaDeConversao.conversion_rates().get("BRL");
                    if (taxa != null) {
                        double valorConvertido = valorDigitado * taxa;
                        System.out.println("O valor de " + valorDigitado + " VES convertido para Real brasileiro é: " + String.format("%.2f", valorConvertido) + " BRL");
                    } else {
                        System.out.println("Erro: Taxa de câmbio de VES para BRL não encontrada.");
                    }
                } else if (opcao == 4) {
                    System.out.print("Digite o valor em Real (BRL): ");
                    valorDigitado = leitura.nextDouble();
                    TaxaDeConversao novaTaxaDeConversao = converteMoeda.buscaMoeda("BRL"); // Base currency is BRL
                    gerador.salvaJson(novaTaxaDeConversao);
                    Double taxa = novaTaxaDeConversao.conversion_rates().get("VES"); // Get rate for VES
                    if (taxa != null) {
                        double valorConvertido = valorDigitado * taxa;
                        System.out.println("O valor de " + valorDigitado + " BRL convertido para Bolívar venezuelano é: " + String.format("%.2f", valorConvertido) + " VES");
                    } else {
                        System.out.println("Erro: Taxa de câmbio de BRL para VES não encontrada.");
                    }
                } else if (opcao == 5) {
                    System.out.print("Digite o valor em Shekel israelense (ILS): ");
                    valorDigitado = leitura.nextDouble();
                    TaxaDeConversao novaTaxaDeConversao = converteMoeda.buscaMoeda("ILS");
                    gerador.salvaJson(novaTaxaDeConversao);
                    Double taxa = novaTaxaDeConversao.conversion_rates().get("BRL");
                    if (taxa != null) {
                        double valorConvertido = valorDigitado * taxa;
                        System.out.println("O valor de " + valorDigitado + " ILS convertido para Real brasileiro é: " + String.format("%.2f", valorConvertido) + " BRL");
                    } else {
                        System.out.println("Erro: Taxa de câmbio de ILS para BRL não encontrada.");
                    }
                } else if (opcao == 6) {
                    System.out.print("Digite o valor em Real (BRL): ");
                    valorDigitado = leitura.nextDouble();
                    TaxaDeConversao novaTaxaDeConversao = converteMoeda.buscaMoeda("BRL"); // Base currency is BRL
                    gerador.salvaJson(novaTaxaDeConversao);
                    Double taxa = novaTaxaDeConversao.conversion_rates().get("ILS"); // Get rate for ILS
                    if (taxa != null) {
                        double valorConvertido = valorDigitado * taxa;
                        System.out.println("O valor de " + valorDigitado + " BRL convertido para Shekel israelense é: " + String.format("%.2f", valorConvertido) + " ILS");
                    } else {
                        System.out.println("Erro: Taxa de câmbio de BRL para ILS não encontrada.");
                    }
                } else if (opcao != 7) { // Handles invalid options within the loop
                    System.out.println("Opção inválida. Digite um número de 1 a 7.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número inteiro para a opção e um número real para o valor.");
                leitura.next(); // Consume the invalid input
            } catch (IOException e) {
                System.out.println("Erro de conexão ou ao buscar dados da moeda. Verifique sua conexão com a internet ou a API.");
            } catch (NullPointerException e) {
                System.out.println("Erro: Não foi possível obter as taxas de câmbio. Verifique se o código da moeda está correto ou se a API está funcionando.");
            }
            System.out.println("\n"); // Adiciona uma linha branca para melhor readaptação entre interaçoes.
        }

        if (opcao == 7) {
            System.out.println("Obrigado por utilizar nosso conversor de moedas!");
            leitura.close();
        }
    }
}
