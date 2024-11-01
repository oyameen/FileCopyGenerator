import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter the input text file path.");
        String inputFilePath = scanner.nextLine();
        System.out.println("Please, enter the output directory path.");
        String outputDirectory = scanner.nextLine();
        System.out.println("Please, enter number of the copies you prefer.");
        int numberOfCopy = scanner.nextInt();

        FileCopyGenerator.generateCopiesOfFile(inputFilePath, outputDirectory, numberOfCopy);

        System.out.println("Generating of copies done successfully.");
    }
}