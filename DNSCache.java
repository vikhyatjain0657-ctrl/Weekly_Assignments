import java.util.*;

class DNSEntry {
    String ip;
    long expiry;
    DNSEntry(String ip,long ttl){
        this.ip=ip;
        this.expiry=System.currentTimeMillis()+ttl*1000;
    }
}

public class DNSCache {
    private Map<String,DNSEntry> cache=new HashMap<>();
    private int hits=0,miss=0;

    public String resolve(String domain){
        DNSEntry e=cache.get(domain);
        if(e!=null && e.expiry>System.currentTimeMillis()){
            hits++;
            return e.ip;
        }
        miss++;
        String ip="192.168."+new Random().nextInt(255)+"."+new Random().nextInt(255);
        cache.put(domain,new DNSEntry(ip,300));
        return ip;
    }

    public void stats(){
        int total=hits+miss;
        System.out.println("Hit Rate:"+(hits*100.0/total));
    }
}