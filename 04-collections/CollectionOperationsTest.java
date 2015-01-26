import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class CollectionOperationsTest {

    private static final Collection<Integer> ONE = Arrays.asList(1, 2, 3, 4);
    
    private static final Collection<Integer> TWO = new HashSet<>(Arrays.asList(3, 4, 5, 6));

    private static final Collection<Integer> THREE = new LinkedList<>(Arrays.asList(6, 7, 8));
    
    private static final Collection<Integer> FOUR = Arrays.asList();
    
    private CollectionOperations operations;

    @Before
    public void setUp() {
        operations = new CollectionOperations();
    }
    
    @Test
    public void testUnion() {
        Collection<Integer> actual   = operations.union(ONE, TWO);
        Set<Integer> expected = asSet(1, 2, 3, 4, 5, 6);
        
        Assert.assertTrue(expected.equals(actual));
    }
    
    @Test
    public void testUnionWithEmpty() {
        Collection<Integer> actual   = operations.union(ONE, FOUR);
        Set<Integer> expected = asSet(1, 2, 3, 4);

        Assert.assertTrue(expected.equals(actual));
    }
    
    @Test
    public void testIntersection() {
        Collection<Integer> actual = operations.intersection(TWO, THREE);
        Set<Integer> expected = asSet(6);

        Assert.assertTrue(expected.equals(actual));
    }
    
    @Test
    public void testIntersectionWithEmpty() {
        Collection<Integer> actual = operations.intersection(TWO, FOUR);
        Set<Integer> expected = asSet();

        Assert.assertTrue(expected.equals(actual));
    }
    
    @Test
    public void testDifference() {
        Collection<Integer> actual = operations.difference(ONE, TWO);
        Set<Integer> expected = asSet(1, 2);

        Assert.assertTrue(expected.equals(actual));
    }

    @Test
    public void testDifferenceWithEmpty() {
        Collection<Integer> actual = operations.difference(TWO, FOUR);
        Set<Integer> expected = asSet(3, 4, 5, 6);

        Assert.assertTrue(expected.equals(actual));
    }

    private Set<Integer> asSet(Integer... value) {
        return new HashSet<>(Arrays.asList(value));
    }

    private <T> boolean areEqual(Collection<T> one, Collection<T> two) {
        return one.containsAll(two) && two.containsAll(one);
    }
}
