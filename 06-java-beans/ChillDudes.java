import java.util.List;
import java.util.Map;

public class ChillDudes {

    private static final ChillDudeFactory factory = new ChillDudeFactory();
    private static final ChillDudeFilter filter = new DefaultChillDudeFilter();
    private static final ChillDudeFormatter formatter = new ChillDudeFormatter();
    
    public static void main(String[] args) {
        final List<ChillDude> dudes = factory.makeCoolDudes();
       
        final String dude  = filter.oldestDude(dudes);
        final String formattedDudes = formatter.format(dudes);
        
        System.out.println(dude);
        System.out.println(formattedDudes);
    }
    
}
