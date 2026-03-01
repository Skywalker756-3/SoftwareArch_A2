package question1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ListBuilder builder = new ListBuilder();
        
        // The  default input string
        String input = "[1 [2 3] [4 5] [6 4]]";
        
        // Format the string so that it can ensure spaces around brackets for easy tokenization and readibility 
        input = input.replace("[", " [ ").replace("]", " ] ");
        
        // Read in input list and tokenize the list
        Scanner scanner = new Scanner(input);
        
        while (scanner.hasNext()) {
            String token = scanner.next();
            
            if (token.equals("[")) {
                builder.buildOpenBracket();
            } else if (token.equals("]")) {
                builder.buildCloseBracket();
            } else {
                try {
                    // Try to parse it as a number
                    int number = Integer.parseInt(token);
                    builder.buildElement(number);
                } catch (NumberFormatException e) {
                    // Ignore tokens that aren't brackets or numbers, they're not the part of it
                }
            }
        }
        scanner.close();
        
        // Get the final list and print it
        ListComponent list = builder.getList();
        if (list != null) {
            //uncomment the following line when taking a screenshot of the output
            System.out.println();
            list.printValue();
            System.out.println();
        }
    }
}