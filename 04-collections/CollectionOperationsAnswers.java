import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class CollectionOperationsAnswers {
    
    public <T> Set<T> union(Collection<T> one, Collection<T> two) {
        Set<T> output = new HashSet<>(one);
        output.addAll(two);
        
        return output;
    }
    
    public <T> Set<T> intersection(Collection<T> one, Collection<T> two) {
        Set<T> output = new HashSet<>(one);
        output.retainAll(two);
        
        return output;
    }
    
    public <T> Set<T> difference(Collection<T> one, Collection<T> two) {
        Set<T> output = new HashSet<>(one);

        output.removeAll(two);

        return output;
    }
    
    public <T> Set<T> exclusiveOr(Collection<T> one, Collection<T> two) {
        Set<T> outputL = new HashSet<>(one);
        Set<T> outputR = new HashSet<>(two);
        
        outputL.removeAll(two);
        outputR.removeAll(one);
        
        outputL.addAll(outputR);
        
        return outputL;
    }
    
}
