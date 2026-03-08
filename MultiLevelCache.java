import java.util.*;

public class MultiLevelCache {

    LinkedHashMap<String,String> L1=new LinkedHashMap<>(10000,0.75f,true){
        protected boolean removeEldestEntry(Map.Entry e){return size()>10000;}
    };

    Map<String,String> L2=new HashMap<>();
    Map<String,String> L3=new HashMap<>();

    public String getVideo(String id){
        if(L1.containsKey(id)) return L1.get(id);
        if(L2.containsKey(id)){
            String v=L2.get(id);
            L1.put(id,v);
            return v;
        }
        String v=L3.getOrDefault(id,"DB_VIDEO");
        L2.put(id,v);
        return v;
    }
}
