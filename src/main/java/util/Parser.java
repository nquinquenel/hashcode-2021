package util;

import strategy.AbstractStrategy;

import java.io.*;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Parser {

    private final String inputName;

    public Parser(final String inputName) {
        this.inputName = inputName;
    }

    public Input parseInput() throws FileNotFoundException {
        final Scanner in = new Scanner(new File("src/main/resources/input/" + inputName));

        // TODO parsing input

        in.close();

        return new Input(inputName);
    }

    public void writeResult(final AbstractStrategy strategy) {
        //final List<LibraryOutput> result = strategy.getResult();
        final OffsetDateTime now = OffsetDateTime.now(ZoneId.systemDefault());
        final String nowString = now.format(DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss"));
        final String outputFileName = strategy.getName() + "_" + inputName + "_" + nowString + ".txt";
        try {
            final File file = new File("src/main/resources/output/" + outputFileName);
            file.createNewFile();
            final FileOutputStream fos = new FileOutputStream(file);
            final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

            // TODO writing output to file
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
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

}