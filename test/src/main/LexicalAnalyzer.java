import java.util.Scanner;

public class LexicalAnalyzer {

    public LexicalAnalyzer() {
    }

    // Method: Analyze a single input token and classify it
    public String analyzeToken(String token) {
        // Keywords list
        String[] keywords = {
                "if", "else", "switch", "case", "default", "for", "while", "do", "break", "continue", "return",
                "int", "double", "float", "char", "boolean", "long", "short", "byte", "void",
                "public", "private", "protected", "static", "final", "abstract",
                "class", "interface", "extends", "implements", "new", "this", "super",
                "import", "package", "try", "catch", "throw", "throws", "finally"
        };


        // Check if empty
        if (token.isEmpty()) {
            return "[Error] Empty input is not valid.";
        }

        // Check if keyword
        for (String kw : keywords) {
            if (token.equals(kw)) {
                return "Token: " + token + " -> Keyword";
            }
        }

        // Check if positive integer
        if (token.matches("[1-9][0-9]*")) {
            return "Token: " + token + " -> Positive Integer";
        }

        // Check if identifier (e.g., variable name)
        if (token.matches("[a-zA-Z_][a-zA-Z0-9_]*")) {
            return "Token: " + token + " -> Identifier";
        }

        // If none of the above, invalid
        return "[Error] \"" + token + "\" is not a valid token.";
    }

    public static void main(String[] args) {

        LexicalAnalyzer lexicalAnalyzer = new LexicalAnalyzer();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter tokens to analyze (type 'exit' to quit):");

        while (true) {
            System.out.print("Input: ");
            String userInput = input.nextLine().trim();

            // Exit condition
            if (userInput.equalsIgnoreCase("exit")) {
                break;
            }

            // Analyze the input
            String output = lexicalAnalyzer.analyzeToken(userInput);
            System.out.println(output);
        }

        input.close();
        System.out.println("Lexical analysis finished.");
    }
}
