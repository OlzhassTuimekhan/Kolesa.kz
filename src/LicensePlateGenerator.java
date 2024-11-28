import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class LicensePlateGenerator {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final Set<String> generatedPlates = new HashSet<>();
    private static final Random random = new Random();

    public static String generateLicensePlate() {
        String plate;
        do {
            StringBuilder plateBuilder = new StringBuilder();
            for (int i = 0; i < 3; i++) {
                plateBuilder.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
            }
            for (int i = 0; i < 3; i++) {
                plateBuilder.append(DIGITS.charAt(random.nextInt(DIGITS.length())));
            }
            plate = plateBuilder.toString();
        } while (!generatedPlates.add(plate));
        return plate;
    }
}