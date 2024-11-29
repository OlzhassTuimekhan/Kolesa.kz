import java.util.Random;
import java.util.stream.Collectors;

public class RegionalLicensePlateStrategy implements LicensePlateStrategy {
    private final String region;

    public RegionalLicensePlateStrategy(String region) {
        this.region = region;
    }

    @Override
    public String generateLicensePlate() {
        String letters = generateRandomLetters(3); // 3 случайных буквы
        String numbers = String.format("%03d", new Random().nextInt(1000)); // 3 случайных цифры
        return letters + numbers + region; // Регион указывается при создании стратегии
    }

    private String generateRandomLetters(int count) {
        Random random = new Random();
        return random.ints('A', 'Z' + 1)
                .limit(count)
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
    }
}