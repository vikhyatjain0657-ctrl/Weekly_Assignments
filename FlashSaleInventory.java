import java.util.*;

public class FlashSaleInventory {
    private Map<String, Integer> stock = new HashMap<>();
    private Map<String, Queue<Integer>> waiting = new HashMap<>();

    public void addProduct(String id, int qty) {
        stock.put(id, qty);
        waiting.put(id, new LinkedList<>());
    }

    public synchronized String purchase(String id, int user) {
        int s = stock.getOrDefault(id, 0);
        if (s > 0) {
            stock.put(id, s - 1);
            return "Success " + (s - 1);
        }
        waiting.get(id).add(user);
        return "Waiting #" + waiting.get(id).size();
    }

    public int checkStock(String id) {
        return stock.getOrDefault(id, 0);
    }
}