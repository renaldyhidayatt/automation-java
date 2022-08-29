import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindAllPatterns {
    public static void main(String[] args) throws IOException{
        BufferedReader is = new BufferedReader(new FileReader("InputFile1.txt"));
        Pattern patt = Pattern.compile("[A-Za-z][a-z]+");
        Matcher matcher = patt.matcher("");
        String line = null;

        while((line = is.readLine()) != null){
            matcher.reset(line);
            if (matcher.find()) {
                System.out.println("MATCH: " + line);
            }
        }
        is.close();
    }
}
