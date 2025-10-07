import java.util.*;

public class LexicalAnalyzer {

    // --- Reserved keywords in Java ---
    private static final Set<String> KEYWORDS = new HashSet<>(Arrays.asList(
        "if","else","switch","case","default","for","while","do","break","continue","return",
        "int","double","float","char","boolean","long","short","byte","void",
        "public","private","protected","static","final","abstract",
        "class","interface","extends","implements","new","this","super",
        "import","package","try","catch","throw","throws","finally"
    ));

    /**
     * Analyze a single token (identifier, keyword, number, etc.)
     */
    public String analyzeToken(String token) {
        if (token.isEmpty()) return "[Error] Empty input is not valid.";

        // Check if it's a reserved keyword
        if (KEYWORDS.contains(token)) return "Token: " + token + " -> Keyword";

        // Integer literal (0 and positive numbers)
        if (token.matches("0|[1-9][0-9]*")) return "Token: " + token + " -> Integer Literal";

        // Decimal literal
        if (token.matches("[0-9]+\\.[0-9]+")) return "Token: " + token + " -> Decimal Literal";

        // Identifier (variable name)
        if (token.matches("[a-zA-Z_][a-zA-Z0-9_]*")) return "Token: " + token + " -> Identifier";

        // Operators and punctuation
        if (token.matches("[=+\\-*/;()]")) return "Token: " + token + " -> Operator/Punctuation";

        // Otherwise: invalid token
        return "[Error] \"" + token + "\" is not a valid token.";
    }

    /**
     * Splits code into separate statements using ';' as delimiter
     */
    private List<String> splitStatements(String code) {
        List<String> statements = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (char c : code.toCharArray()) {
            sb.append(c);
            if (c == ';') { // end of statement
                statements.add(sb.toString().trim());
                sb.setLength(0);
            }
        }
        if (sb.length() > 0) statements.add(sb.toString().trim());
        return statements;
    }

    /**
     * Analyzes a single declaration or assignment statement.
     * Grammar (simplified from Part B):
     * <stmt> ::= <type> <id> ; | <type> <id> = <number> ;
     */
    private void analyzeSingleStatement(String stmt) throws IllegalArgumentException {
        stmt = stmt.trim();
        if (stmt.isEmpty()) return;

        // Regex for declarations with optional initialization
        String pattern = "^(int|double|float|char|boolean|long|short|byte)\\s+([a-zA-Z_][a-zA-Z0-9_]*)\\s*(=\\s*([0-9]+|[0-9]+\\.[0-9]+))?;$";

        if (!stmt.matches(pattern)) {
            throw new IllegalArgumentException("Invalid statement: " + stmt);
        }

        // Parse structure
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

        // Print a simple parse tree
        System.out.println("---- Parse Tree ----");
        System.out.println("Statement");
        System.out.println(" ├── Type: " + type);
        System.out.println(" ├── Identifier: " + var);
        if (operator != null) {
            System.out.println(" ├── Operator: " + operator);
            System.out.println(" └── Value: " + value);
        }
        System.out.println(); // newline for readability
    }

    /**
     * Analyzes multiple statements separated by semicolons
     */
    public void analyzeMultipleStatements(String code) {
        List<String> statements = splitStatements(code);
        for (String stmt : statements) {
            if (stmt.isEmpty()) continue; // skip empty statements
            try {
                analyzeSingleStatement(stmt);
            } catch (IllegalArgumentException e) {
                System.out.println("[Error] " + e.getMessage());
            }
        }
    }

    /**
     * Main loop: accept user input until "exit"
     */
    public static void main(String[] args) {
        LexicalAnalyzer analyzer = new LexicalAnalyzer();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter tokens or statements (type 'exit' to quit):");

        while (true) {
            System.out.print("Input: ");
            String line = scanner.nextLine().trim();
            if (line.equalsIgnoreCase("exit")) break;

            try {
                if (!line.contains(" ") && !line.contains(";")) {
                    // Single token case
                    System.out.println(analyzer.analyzeToken(line));
                } else {
                    // Multiple statements or code
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
