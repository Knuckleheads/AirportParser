import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Parser{
    private final int defaultColumn = 2;
    BufferedReader br;

    public ArrayList<String> parseCsv(String csvPath, String needValue,int needColumn) throws IOException {
        return getStrings(csvPath, needValue, needColumn);
    }
    public ArrayList<String> parseCsv(String csvPath, String needValue) throws IOException {
        return getStrings(csvPath, needValue, defaultColumn);
    }

    private ArrayList<String> getStrings(String csvPath, String needValue, int defaultColumn) throws IOException {
        br = new BufferedReader(new FileReader(csvPath));
        ArrayList<String> str = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            String[] cols = line.split(",");
            while (defaultColumn > cols.length || defaultColumn < 0) {
                    System.out.println("Incorrect value. Enter from 0 to 13\n");
            }
            cols[defaultColumn] = cols[defaultColumn].replace("\"", "");
            if (defaultColumn < cols.length && isFoundValue(cols[defaultColumn], needValue)) {
                str.add(line);
            }
        }
        br.close();
        return str;
    }

    public boolean isFoundValue(String cols, String needValue) {
            return cols.startsWith(needValue);
        }


}
