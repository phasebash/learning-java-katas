public class Palindrome {
   
    private static final PalindromeCheckerAnswer PALINDROME_CHECKER = new PalindromeCheckerAnswer();
    
    public static void main(String[] args) {
        final String joined = String.join(" ", args);
        
        System.out.println("is " + joined + " a palindrome?");
        
        System.out.println(PALINDROME_CHECKER.isPalindrome(joined));
    }
}
