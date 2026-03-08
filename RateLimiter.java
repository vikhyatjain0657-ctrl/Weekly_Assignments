import java.util.*;

class TokenBucket{
    int tokens;
    long last;
    int max;
    int rate;

    TokenBucket(int m,int r){
        max=m;
        rate=r;
        tokens=m;
        last=System.currentTimeMillis();
    }

    synchronized boolean allow(){
        long now=System.currentTimeMillis();
        int refill=(int)((now-last)/1000)*rate;
        tokens=Math.min(max,tokens+refill);
        last=now;
        if(tokens>0){
            tokens--;
            return true;
        }
        return false;
    }
}

public class RateLimiter{
    Map<String,TokenBucket> map=new HashMap<>();

    public boolean check(String client){
        map.putIfAbsent(client,new TokenBucket(1000,1));
        return map.get(client).allow();
    }
}