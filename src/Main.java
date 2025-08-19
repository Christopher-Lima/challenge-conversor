import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            MenuOptions.show();
            String optionText = input.next().trim();
            int option;

            try {
                option = Integer.parseInt(optionText);
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida. Digite um número de 1 a 7.\n");
                continue;
            }

            switch (option) {
                case 1 -> CurrencyConverter.convert("USD", "BRL", input);
                case 2 -> CurrencyConverter.convert("BRL", "USD", input);
                case 3 -> CurrencyConverter.convert("EUR", "BRL", input);
                case 4 -> CurrencyConverter.convert("BRL", "EUR", input);
                case 5 -> CurrencyConverter.convert("ARS", "BRL", input);
                case 6 -> CurrencyConverter.convert("BRL", "ARS", input);
                case 7 -> {
                    System.out.println("Fechando programa. Até logo!");
                    return;
                }
                default -> System.out.println("Opção inválida. Digite um número de 1 a 7.");
            }

            System.out.println();
        }
    }
}
