public class PalindromeCheckerAnswer {
    
    public boolean isPalindrome(final String input) {
        if (input == null) {
            return false;
        }
        
        final String[] parts = input.split("");
        final int length = parts.length;
        
        for (int i = 0; i < Math.round(input.length() / 2); i++) {
            if (!parts[i].equals(parts[length - 1 -i])) {
               return false;
            }
        }
        
        return true;
    }
    
}