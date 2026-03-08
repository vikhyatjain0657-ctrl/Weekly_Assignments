import java.util.*;

class Spot{
    String plate;
    long time;
}

public class ParkingLot{
    Spot[] table=new Spot[500];

    int hash(String s){
        return Math.abs(s.hashCode())%table.length;
    }

    public int park(String plate){
        int i=hash(plate);
        int start=i;
        while(table[i]!=null){
            i=(i+1)%table.length;
            if(i==start) return -1;
        }
        table[i]=new Spot();
        table[i].plate=plate;
        table[i].time=System.currentTimeMillis();
        return i;
    }

    public void exit(String plate){
        for(int i=0;i<table.length;i++){
            if(table[i]!=null && table[i].plate.equals(plate)){
                table[i]=null;
                break;
            }
        }
    }
}