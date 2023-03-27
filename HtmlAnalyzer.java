import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.EmptyStackException;
import java.util.Stack;

public class HtmlAnalyzer {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Por favor, insira uma URL válida!");
            return;
        }

        String urlStr = args[0];
        try {
            URL url = new URL(urlStr);
            URLConnection connection = url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            Stack<String> tagStack = new Stack<>();
            int deepestLevel = -1;
            String deepestText = "";

            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();

                if (line.isEmpty()) {
                    continue;
                }

                if (line.startsWith("</")) {
                    try {
                        tagStack.pop();
                    } catch (EmptyStackException e) {
                        System.err.println("malformed HTML");
                        return;
                    }
                } else if (line.startsWith("<")) {
                    tagStack.push(line);
                } else {
                    int currentLevel = tagStack.size();
                    if (currentLevel > deepestLevel) {
                        deepestLevel = currentLevel;
                        deepestText = line;
                    }
                }
            }

            if (tagStack.empty()) {
                System.out.println(deepestText);
            } else {
                System.err.println("malformed HTML");
            }
        } catch (IOException e) {
            System.err.println("URL connection error");
            return;
        }
    }
}
