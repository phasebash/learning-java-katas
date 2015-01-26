import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PalindromeCheckerTest {

    private PalindromeChecker checker;

    @Before
    public void setUp() {
        checker = new PalindromeChecker();        
    }
    
    @Test
    public void testDoesNotCrapOnNull() {
        checker.isPalindrome(null);
    }
    
    @Test
    public void testIsPoopAPalindrome() {
        Assert.assertTrue(checker.isPalindrome("poop"));
    }
    
    @Test
    public void testIsHammerHandsAPalindrome() {
        Assert.assertFalse(checker.isPalindrome("hammer hands"));
    }
    
    @Test
    public void testEmptyStringIsPalindrome() {
        Assert.assertTrue(checker.isPalindrome(""));
    }
}
