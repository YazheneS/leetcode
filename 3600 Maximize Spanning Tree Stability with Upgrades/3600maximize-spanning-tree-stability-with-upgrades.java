import java.util.*;

class Solution {

    class DSU {
        int[] parent;

        DSU(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++)
                parent[i] = i;
        }

        int find(int x) {
            if (parent[x] == x) return x;
            return parent[x] = find(parent[x]);
        }

        boolean union(int a, int b) {
            int pa = find(a);
            int pb = find(b);
            if (pa == pb) return false;
            parent[pa] = pb;
            return true;
        }
    }

public int maxStability(int n, int[][] edges, int k) {

    List<int[]> must = new ArrayList<>();
    List<int[]> opt = new ArrayList<>();

    int high = 0;

    for (int[] e : edges) {
        if (e[3] == 1) must.add(e);
        else opt.add(e);

        high = Math.max(high, e[2]);
    }

    high *= 2;   // IMPORTANT FIX

    opt.sort((a, b) -> b[2] - a[2]);

    int low = 0;
    int ans = -1;

    while (low <= high) {

        int mid = (low + high) / 2;

        if (canBuild(n, must, opt, k, mid)) {
            ans = mid;
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }

    return ans;
}

    boolean canBuild(int n, List<int[]> must,
                     List<int[]> opt,
                     int k, int need) {

        DSU dsu = new DSU(n);

        int edgesUsed = 0;
        int upgrades = 0;

        // add must edges
        for (int[] e : must) {

            if (e[2] < need) return false;

            if (!dsu.union(e[0], e[1]))
                return false;

            edgesUsed++;
        }

        // try optional edges
        for (int[] e : opt) {

            if (edgesUsed == n - 1) break;

            if (dsu.find(e[0]) == dsu.find(e[1]))
                continue;

            int s = e[2];

            if (s >= need) {
                dsu.union(e[0], e[1]);
                edgesUsed++;
            }
            else if (upgrades < k && s * 2 >= need) {
                upgrades++;
                dsu.union(e[0], e[1]);
                edgesUsed++;
            }
        }

        return edgesUsed == n - 1;
    }
}