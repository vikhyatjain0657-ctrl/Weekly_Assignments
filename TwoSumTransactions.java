import java.util.*;

class Transaction{
    int id;
    int amount;
    String merchant;
}

public class TwoSumTransactions {

    public List<int[]> twoSum(int[] arr,int target){
        Map<Integer,Integer> map=new HashMap<>();
        List<int[]> res=new ArrayList<>();

        for(int i=0;i<arr.length;i++){
            int comp=target-arr[i];
            if(map.containsKey(comp)){
                res.add(new int[]{map.get(comp),i});
            }
            map.put(arr[i],i);
        }
        return res;
    }
}