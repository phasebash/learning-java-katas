import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class StringReversalAnswer {
    
    public static void main(String[] args) {
        final String input = "how to reverse a string";
        
        System.out.println(reverse(input));
        System.out.println(reverse2(input));
    }
    
    private static String reverse(final String input) {
        return reverse(new LinkedList<String>(Arrays.asList(input.split(""))));
    }
    
    private static String reverse(final List<String> input) {
        String output = "";
        
        if (!input.isEmpty()) {
            output = input.remove(0);
            return reverse(input) + output;
        } else {
           return "";
        }
    }
    
    private static String reverse2(final String input) {
        String output = "";
        
        if (input.length() > 0) {
            final String[] parts = input.split("");
            for (int i = parts.length - 1; i >= 0; i--) {
                output += parts[i];
            }
            
            return output;
        }
        
        return "";
    }
    
}