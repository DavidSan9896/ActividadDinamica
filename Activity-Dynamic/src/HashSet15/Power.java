package HashSet15;


import java.util.*;

public class Power {
    public static Set<Set<Integer>> generatePowerSet(Set<Integer> inputSet) {
        Set<Set<Integer>> powerSet = new HashSet<>();
        List<Integer> elements = new ArrayList<>(inputSet);

        int n = elements.size();

        for (int i = 0; i < (1 << n); i++) {
            Set<Integer> subset = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    subset.add(elements.get(j));
                }
            }
            powerSet.add(subset);
        }

        return powerSet;
    }
}
