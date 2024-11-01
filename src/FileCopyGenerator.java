import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileCopyGenerator {

    public static void generateCopiesOfFile(String inputFilePath, String outputDirectory, int numberOfCopy) throws IOException {

        File inputFile = new File(inputFilePath);

        if (!(inputFile.exists() && inputFile.isFile() && inputFile.canRead() && inputFile.getName().endsWith(".txt"))) {
            System.out.println("Invalid inputFilePath");
            throw new IllegalArgumentException("Invalid inputFile provided.");
        }

        File outputDir = new File(outputDirectory);
        if (!(outputDir.exists() && outputDir.isDirectory() && outputDir.canWrite())) {
            System.out.println("Invalid outputDirectory");
            throw new IllegalArgumentException("Invalid output Directory provided.");
        }

        if (numberOfCopy <= 0) {
            System.out.println("Invalid NumberOfCopy");
            throw new IllegalArgumentException("Invalid NumberOfCopy provided.");
        }

        int roll = 1;
        String fileName = inputFile.getName();
        String rollNum = null;
        String outputFileName = null;

        FileReader fr = null;
        BufferedReader br = null;

        try {
            fr = new FileReader(inputFile);
            br = new BufferedReader(fr);
            List<String> content = new ArrayList<>();
            br.lines().forEach(content::add);

            for (int i = 1; i <= numberOfCopy; i++) {

                rollNum = fileName + "-11" + roll;
                outputFileName = outputDir.getAbsolutePath() + File.separator + rollNum + ".txt";
                fillFile(outputFileName, content);
                roll++;
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            if (fr != null)
                fr.close();
            if (br != null)
                br.close();
        }

    }

    private static void fillFile(String outputFilName, List<String> content) throws IOException {

        PrintWriter bw = null;
        FileWriter fw = null;
        try {
            fw = new FileWriter(outputFilName);
            bw = new PrintWriter(fw);
            for (String s : content) {
                bw.println(s);
            }
        } finally {
            if (bw != null) {
                bw.close();
            }
            if (fw != null)
                fw.close();
        }
    }
}
