package common;

public class Relation {
    private int[][] graph;

    public Relation(int[][] graph) {
        this.graph = graph;
    }

    public boolean knows(int a, int b){
        return graph[a][b] == 1;
    };

}
