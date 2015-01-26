import java.util.List;
import java.util.Map;

public class CoolDudes {

    private static final CoolDudeFactory factory = new CoolDudeFactory();
    private static final CoolDudeFilter oldschoolFilter = new OldSchoolCoolDudeFilter();
    private static final CoolDudeFilter newSchoolFilter = new NewSchoolCoolDudeFilter();
    private static final CoolDudeFormatter formatter = new CoolDudeFormatter();
    
    public static void main(String[] args) {
        final List<Map<String, Integer>> dudes = factory.makeCoolDudes();
       
        final String oldschoolDude  = oldschoolFilter.oldestDude(dudes);
        final String newSchoolDude  = newSchoolFilter.oldestDude(dudes);
        final String formattedDudes = formatter.format(dudes);
        
        System.out.println(oldschoolDude);
        System.out.println(newSchoolDude);
        System.out.println(formattedDudes);
    }
    
}
