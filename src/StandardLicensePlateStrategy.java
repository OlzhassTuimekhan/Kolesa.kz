import java.util.Random;
import java.util.stream.Collectors;

public class StandardLicensePlateStrategy implements LicensePlateStrategy {
    @Override
    public String generateLicensePlate() {
        String letters = generateRandomLetters(3);
        String numbers = String.format("%03d", new Random().nextInt(1000));
        String region = "17";
        return letters + numbers + region;
    }

    private String generateRandomLetters(int count) {
        Random random = new Random();
        return random.ints('A', 'Z' + 1)
                .limit(count)
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
    }
}



