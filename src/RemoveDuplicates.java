import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите набор чисел через запятую: ");
        String input = scanner.nextLine();

        String[] numbers = input.split(",\\s*");
        Set<String> uniqueNumbers = new HashSet<>(Arrays.asList(numbers));

        System.out.println("Результат: " + String.join(", ", uniqueNumbers));

        scanner.close();
    }
}