import java.util.*;

public class Autocomplete {
    Map<String,Integer> freq=new HashMap<>();

    public void add(String q){
        freq.put(q,freq.getOrDefault(q,0)+1);
    }

    public List<String> search(String prefix){
        PriorityQueue<String> pq=new PriorityQueue<>(
                (a,b)->freq.get(a)-freq.get(b)
        );
        for(String q:freq.keySet()){
            if(q.startsWith(prefix)){
                pq.add(q);
                if(pq.size()>10) pq.poll();
            }
        }
        List<String> res=new ArrayList<>();
        while(!pq.isEmpty()) res.add(pq.poll());
        Collections.reverse(res);
        return res;
    }
}