import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.Map;

public class FileWordCounterTest {

    private FileWordCounter counter;

    @Before
    public void setUp() {
        counter = new FileWordCounter();        
    }
    
    @Test
    public void testHasTheRightNumberOfWords() {
        Map<String, Integer> words = readThatMug();
        
        Assert.assertEquals(17, words.entrySet().size());
    }
    
    @Test(expected = FileNotFoundException.class)
    public void testThrowsOnNonExistentFile() {
        counter.countWords("coffeestain.txt");
    }
    
    @Test
    public void testHasExpectedOccurencesOfWordOne() {
        int count = readThatMug().get("one");        
        
        Assert.assertEquals(3, count);
    }
    
    @Test
    public void testDoesNotHaveSlashN() {
        Assert.assertFalse(readThatMug().containsKey("\n"));
    }

    @Test
    public void testDoesNotHaveSpace() {
        Assert.assertFalse(readThatMug().containsKey(" "));
    }
    
    private Map<String, Integer> readThatMug() {
        return counter.countWords("input.txt");
    }
}
