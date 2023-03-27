import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Stack;

public class HtmlAnalyzer {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java HtmlAnalyzer <url>");
            return;
        }

        String urlStr = args[0];
        String html = getHtmlFromUrl(urlStr);

        if (html == null) {
            System.out.println("URL connection error");
            return;
        }

        int maxDepth = 0;
        String maxDepthText = null;

        // Cria uma pilha para manter o rastreamento das tags abertas
        Stack<String> openTags = new Stack<String>();

        String[] lines = html.split("\\r?\\n"); // Divide o HTML em linhas

        for (String line : lines) {
            String trimmedLine = line.trim();

            // Ignora linhas em branco
            if (trimmedLine.isEmpty()) {
                continue;
            }

            // Remove qualquer identação da linha
            String unindentedLine = trimmedLine.replaceAll("^\\s+", "");

            // Verifica se a linha é uma tag de abertura
            if (unindentedLine.startsWith("<") && !unindentedLine.startsWith("</")) {
                String tag = unindentedLine.substring(1, unindentedLine.indexOf(">"));
                openTags.push(tag);
            }

            // Verifica se a linha é uma tag de fechamento
            if (unindentedLine.startsWith("</")) {
                openTags.pop();
            }

            // Verifica se a linha é um trecho de texto no nível máximo de profundidade
            if (openTags.isEmpty()) {
                int depth = getDepth(line);
                if (depth > maxDepth) {
                    maxDepth = depth;
                    maxDepthText = trimmedLine;
                }
            }
        }

        if (maxDepthText != null) {
            System.out.println(maxDepthText);
        } else {
            System.out.println("malformed HTML");
        }
    }

    private static String getHtmlFromUrl(String urlStr) {
        try {
            URL url = new URL(urlStr);
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
            }
            in.close();

            return sb.toString();
        } catch (Exception e) {
            return null;
        }
    }

    private static int getDepth(String line) {
        int depth = 0;
        while (line.startsWith(" ")) {
            depth++;
            line = line.substring(1);
        }
        return depth;
    }

}
