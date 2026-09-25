class Solution {
    int parent[];
    public int[] findRedundantConnection(int[][] edges) {
        parent = new int[edges.length + 1];
        for(int i =1; i< edges.length; i++){
            parent[i] = i;
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            if(find(u)== find(v)){
                return edge;
            }
            union(u,v);
        }
        return new int[0];
    }
    public int find(int x){
        while(parent[x] != x){
            x = parent[x];
        }
        return x;
    }
    public void union(int i, int j){
        int iRoot = find(i);
        int jRoot = find(j);
        if(iRoot != jRoot){
            parent[jRoot] = iRoot;
        }
    }
}
