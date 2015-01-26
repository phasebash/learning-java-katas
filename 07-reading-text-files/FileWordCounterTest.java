import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.nio.file.NoSuchFileException;
import java.util.Map;

public class FileWordCounterTest {

    private FileWordCounter counter;

    @Before
    public void setUp() {
        counter = new FileWordCounter();        
    }
    
    @Test
    public void testHasTheRightNumberOfWords() throws Exception {
        Map<String, Long> words = readThatMug();
        
        Assert.assertEquals(17, words.entrySet().size());
    }
    
    @Test(expected = NoSuchFileException.class)
    public void testThrowsOnNonExistentFile() throws Exception {
        counter.countWords("coffeestain.txt");
    }
    
    @Test
    public void testHasExpectedOccurencesOfWordOne() throws Exception {
        long count = readThatMug().get("one");
        
        Assert.assertEquals(3, count);
    }
    
    @Test
    public void testDoesNotHaveSlashN() throws Exception {
        Assert.assertFalse(readThatMug().containsKey("\n"));
    }

    @Test
    public void testDoesNotHaveSpace() throws Exception {
        Assert.assertFalse(readThatMug().containsKey(" "));
    }
    
    private Map<String, Long> readThatMug() throws Exception {
        return counter.countWords("./input1.txt");
    }
}
