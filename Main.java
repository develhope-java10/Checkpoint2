import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class Main {
    public static List<String> loadLines(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        List<String> lines = new ArrayList<>();

        /*
         * Fin quando il reader ha dati da inviarci, leggiamo una linea e la inseriamo nella lista
         */
        while(reader.ready())
            lines.add(reader.readLine());

        reader.close();

        return lines;
    }

    public static HashMap<String, Integer> processLines(List<String> lines) {
        HashMap<String, Integer> map = new HashMap<>();

        for(String line : lines) {
            if(line.isEmpty())
                continue;

            if(!line.contains("$")) {
                System.err.println("Errore: impossibile processare la linea '" + line + "'");
                continue;
            }

            /*
             * Dividiamo la linea in due in base alla posizione del carattere $
             * Dobbiamo utilizzare il doppio slash perchè è un carattere speciale nelle regex
             */
            String[] sections = line.split("\\$");

            /*
             * La chiave sarà il primo elemento dell'array, ovvero la parte prima dell'occorrenza di $
             * Usiamo trim() per rimuovere eventuali trailing spaces
             */
            String key = sections[0].trim();

            /*
             * Utilizziamo trim anche sul resto della stringa.
             * Per contare il numero di parole, facciamo uno split in base agli spazi
             * e contiamo gli elementi dell'array risultante. Esempio:
             * "Test my knowledge" con lo split risulta nell'array:
             * ["Test", "my", "knowledge"]
             * che ha dimensione 3
             */
            Integer value = sections[1].trim().split(" ").length;

            map.put(key, value);
        }

        return map;
    }

    public static void writeLines(String filePath, HashMap<String, Integer> map) throws IOException {
        /*
         * PrintWriter ha un'interfaccia simile a quella di System.out
         */
        PrintWriter writer = new PrintWriter(new FileWriter(filePath));
        for(Entry<String, Integer> entry : map.entrySet())  {
            writer.println(entry.getKey() + " - " + entry.getValue());
        }

        /*
         * Chiamiamo flush() per assicurarci che tutti i dati siano stati scritti su disco
         * e chiudiamo il flusso di dati
         */
        writer.flush();
        writer.close();
    }

    public static void main(String[] args) {
        try {
            List<String> fileLines = loadLines("input.txt");
            HashMap<String, Integer> processedMap = processLines(fileLines);
            writeLines("output.txt", processedMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}