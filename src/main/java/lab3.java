import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class lab3 {

    public static void main(final String[] args) {
        String url = urlToString("http://erdani.com/tdpl/hamlet.txt");
        String[] splitted = url.split("\\s+");
        System.out.println(splitted.length);
        System.out.println(countWord("prince", splitted));


    }
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }
    public static int countWord(final String word, final String[] list) {
        int ct = 0;
        for (String s : list) {
            if (s.equalsIgnoreCase(word)) {
                ct++;
            }
        }
        return ct;
    }


}


