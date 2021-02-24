import java.io.*;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Parser {

    private final String OUTPUT_DIRECTORY = "src/main/resources/output/";

    public Parser(String fileName) {
        final Scanner in;

        try {
            in = new Scanner(new File("src/main/resources/" + fileName));

            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void writeResult(final String inputChosen,
                             final Strategy strategy) {
        //final List<LibraryOutput> result = strategy.getResult();
        final OffsetDateTime now = OffsetDateTime.now(ZoneId.systemDefault());
        final String nowString = now.format(DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss"));
        final String outputFileName = strategy.getName() + "_" + inputChosen + "_" + nowString + ".txt";
        try {
            final File file = new File(OUTPUT_DIRECTORY + outputFileName);
            file.createNewFile();
            final FileOutputStream fos = new FileOutputStream(file);
            final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
//            bw.write(Integer.toString(result.size()));
//            bw.newLine();
//            for (int i = 0; i < result.size(); i++) {
//                final LibraryOutput libraryOutput = result.get(i);
//                bw.write(libraryOutput.getId() + " " + booksOutput.size());
//                bw.newLine();
//                String lineBook = booksOutput.get(0).toString();
//                bw.write(lineBook);
//                bw.newLine();
//            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}