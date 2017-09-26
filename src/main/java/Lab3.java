import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
/**
 * lab3.
 * @author rishav
 *
 */
public class Lab3 {
    /**
     * main method.
     * @param args var
     */
    public static void main(final String[] args) {
        Scanner kb = new Scanner(System.in);
        String url = urlToString("http://erdani.com/tdpl/hamlet.txt");
        String[] splitted = url.split("[ ,.!?;()-]");
        System.out.println(splitted.length);
        System.out.println("What would you like to be counted?");
        String findMe = kb.nextLine();
        System.out.println("This word occurs " + countWord(findMe, splitted) + " times.");
        kb.close();


    }


    /**
     * some.
     * @param url need to be converted
     * @return ural as a string
     */
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

    /**
     * counts number of words.
     * @param word to be counted
     * @param list whole page
     * @return num of instances
     */
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


