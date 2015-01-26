import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class CoolDudeFormatter {
    
    public String format(List<Map<String, Integer>> dudes) {
        return "";
    }
    
    private static class CoolDudeMapComparator implements Comparator<Map<String, Integer>> {
        @Override
        public int compare(Map<String, Integer> o1, Map<String, Integer> o2) {
            return Integer.compare(o1.get("age"), o2.get("age"));
        }
    }
    
}
