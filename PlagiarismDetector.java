import java.util.*;

public class PlagiarismDetector {
    Map<String, Set<String>> map = new HashMap<>();

    public void addDocument(String id, String text) {
        String[] w = text.split(" ");
        for (int i = 0; i < w.length - 4; i++) {
            String g = String.join(" ", Arrays.copyOfRange(w, i, i + 5));
            map.computeIfAbsent(g, k -> new HashSet<>()).add(id);
        }
    }

    public int similarity(String text) {
        String[] w = text.split(" ");
        int match = 0;
        for (int i = 0; i < w.length - 4; i++) {
            String g = String.join(" ", Arrays.copyOfRange(w, i, i + 5));
            if (map.containsKey(g)) match++;
        }
        return match;
    }
}