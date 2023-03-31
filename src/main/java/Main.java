import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // https://openholidaysapi.org/PublicHolidays?countryIsoCode=DE&languageIsoCode=EN&validFrom=2023-01-01&validTo=2023-01-01&subdivisionCode=DE-BE

        String validFrom;
        String validTo;
        String countryIsoCode;
        String responseLanguage = "languageIsoCode=EN";
        String url = "https://openholidaysapi.org/PublicHolidays?";


        Scanner scanner = new Scanner(System.in);
        // For API logic
        ApiUrl apiUrl = new ApiUrl();

        System.out.println("Choose either LT for Lithuania or LV for Latvia");
        countryIsoCode = scanner.next();

        System.out.println("Enter starting DATE (yyyy-mm-dd)");
        validFrom = scanner.next();

        System.out.println("Enter ending DATE (yyyy-mm-dd)");
        validTo = scanner.next();

        String correctUrlToGetResponseFrom = url + "countryIsoCode=" + countryIsoCode + "&" + responseLanguage + "&validFrom=" + validFrom + "&validTo=" + validTo;

        System.out.println();
        System.out.println("Holidays between " + validFrom + " and " + validTo);
        apiUrl.UrlReader(correctUrlToGetResponseFrom);

    }
}
