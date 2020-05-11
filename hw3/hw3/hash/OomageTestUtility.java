package hw3.hash;

import java.util.List;
import java.util.HashMap;

public class OomageTestUtility {
    public static boolean haveNiceHashCodeSpread(List<Oomage> oomages, int M) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int N = oomages.size();
        for (int i = 0; i < M; i++) {
            map.put(i, 0);
        }
        for (Oomage o : oomages) {
            int bucket = (o.hashCode() & 0x7FFFFFFF) % M;
            map.put(bucket, map.get(bucket) + 1);
        }
        for (int bucket : map.keySet()) {
            int inBucket = map.get(bucket);
            if (inBucket < N / 50 || inBucket > N / 2.5) {
                return false;
            }
        }
        return true;
    }
}
