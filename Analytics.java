import java.util.*;

public class Analytics {
    Map<String,Integer> pageViews=new HashMap<>();
    Map<String,Set<String>> visitors=new HashMap<>();
    Map<String,Integer> source=new HashMap<>();

    public void process(String url,String user,String src){
        pageViews.put(url,pageViews.getOrDefault(url,0)+1);
        visitors.computeIfAbsent(url,k->new HashSet<>()).add(user);
        source.put(src,source.getOrDefault(src,0)+1);
    }

    public List<String> topPages(){
        List<String> list=new ArrayList<>(pageViews.keySet());
        list.sort((a,b)->pageViews.get(b)-pageViews.get(a));
        return list.subList(0,Math.min(10,list.size()));
    }
}