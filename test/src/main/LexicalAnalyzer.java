import java.util.*;

public class LexicalAnalyzer {

    private static final Set<String> KEYWORDS = new HashSet<>(Arrays.asList(
            "if","else","switch","case","default","for","while","do","break","continue","return",
            "int","double","float","char","boolean","long","short","byte","void",
            "public","private","protected","static","final","abstract",
            "class","interface","extends","implements","new","this","super",
            "import","package","try","catch","throw","throws","finally"
    ));

    // ---- single word ----
    public String analyzeToken(String token) {
        if (token.isEmpty()) return "[Error] Empty input is not valid.";
        if (KEYWORDS.contains(token)) return "Token: " + token + " -> Keyword";
        if (token.matches("[1-9][0-9]*")) return "Token: " + token + " -> Positive Integer";
        if (token.matches("[a-zA-Z_][a-zA-Z0-9_]*")) return "Token: " + token + " -> Identifier";
        return "[Error] \"" + token + "\" is not a valid token.";
    }

    // ---- split statements ----
    private List<String> splitStatements(String code) {
        List<String> statements = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (char c : code.toCharArray()) {
            sb.append(c);
            if (c == ';') {
                statements.add(sb.toString().trim());
                sb.setLength(0);
            }
        }
        if (sb.length() > 0) statements.add(sb.toString().trim());
        return statements;
    }

    // ---- single statements ----
    private void analyzeSingleStatement(String stmt) throws IllegalArgumentException {
        stmt = stmt.trim();
        if (stmt.isEmpty()) return;


        //statement structure
        String pattern = "^(int|double|float|char|boolean|long|short|byte)\\s+([a-zA-Z_][a-zA-Z0-9_]*)\\s*(=\\s*([0-9]+))?;$";

        if (!stmt.matches(pattern)) {
            throw new IllegalArgumentException("Invalid statement: " + stmt);
        }


        String type, var, operator = null, value = null;


        String clean = stmt.substring(0, stmt.length() - 1).trim();

        if (clean.contains("=")) {
            String[] parts = clean.split("=", 2);
            String left = parts[0].trim();
            value = parts[1].trim();
            operator = "=";
            String[] leftParts = left.split("\\s+");
            type = leftParts[0];
            var = leftParts[1];
        } else {
            String[] parts = clean.split("\\s+");
            type = parts[0];
            var = parts[1];
        }

        System.out.println("---- Syntax Tree ----");
        System.out.println("type: " + type);
        System.out.println("var: " + var);
        System.out.println("operator: " + operator);
        System.out.println("value: " + value);
    }

    // ---- multiple statements ----
    public void analyzeMultipleStatements(String code) {
        List<String> statements = splitStatements(code);
        for (String stmt : statements) {
            try {
                analyzeSingleStatement(stmt);
            } catch (IllegalArgumentException e) {
                System.out.println("[Input Error] " + e.getMessage());
            }
        }
    }

    // ---- Main ----
    public static void main(String[] args) {
        LexicalAnalyzer analyzer = new LexicalAnalyzer();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter tokens or multiple statements (type 'exit' to quit):");

        while (true) {
            System.out.print("Input: ");
            String line = scanner.nextLine().trim();
            if (line.equalsIgnoreCase("exit")) break;

            try {
                if (!line.contains(" ")) {
                    System.out.println(analyzer.analyzeToken(line));
                } else {
                    analyzer.analyzeMultipleStatements(line);
                }
            } catch (Exception e) {
                System.out.println("[Error] " + e.getMessage());
            }
        }

        scanner.close();
        System.out.println("Lexical analysis finished.");
    }
}
