import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;


public class CurrencyConverter {

    public static void convert(String baseCurrency, String targetCurrency, Scanner input) {
        ExchangeRateClient client = new ExchangeRateClient();
        DecimalFormat df = new DecimalFormat("#,##0.00");

        System.out.print("Digite o valor a ser convertido: ");

        String text = input.next().trim().replace(",", ".");
        BigDecimal amount;

        try {
            amount = new BigDecimal(text);
            if (amount.compareTo(BigDecimal.ZERO) < 0) {
                System.out.println("O valor não pode ser negativo.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Valor inválido. Digite apenas números.");
            return;
        }

        BigDecimal rate = client.fetchRate(baseCurrency, targetCurrency);

        BigDecimal converted = amount.multiply(rate).setScale(2, RoundingMode.HALF_UP);

        System.out.printf("Taxa usada: 1 %s = %s %s%n",
                baseCurrency.toUpperCase(), rate.toPlainString(), targetCurrency.toUpperCase());

        System.out.printf("Valor %s [%s] equivale a %s [%s]%n",
                df.format(amount.setScale(2, RoundingMode.HALF_UP)),
                baseCurrency.toUpperCase(),
                df.format(converted),
                targetCurrency.toUpperCase()
        );
    }
}
