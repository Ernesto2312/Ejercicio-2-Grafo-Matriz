package com.ejericio2;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
 
public class GrafoMatriz {
 
    private int[][] matriz;
    private String[] vertices;
    private int n;
 
    public GrafoMatriz(String[] vertices) {
        this.vertices = vertices;
        this.n = vertices.length;
        this.matriz = new int[n][n];
    }
 
    // Agregar arista NO dirigida
    public void agregarArista(int i, int j) {
        matriz[i][j] = 1;
        matriz[j][i] = 1; // simétrico
    }
 
    // Mostrar matriz de adyacencia
    public void mostrar() {
        System.out.println("=== Matriz de adyacencia ===");
        System.out.print("   ");
        for (String v : vertices) System.out.printf("%4s", v);
        System.out.println();
 
        for (int i = 0; i < n; i++) {
            System.out.printf("%3s", vertices[i]);
            for (int j = 0; j < n; j++) {
                System.out.printf("%4d", matriz[i][j]);
            }
            System.out.println();
        }
    }
 
    // BFS usando Queue — marca al encolar
    public void bfs(int inicio) {
        boolean[] visitado = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
 
        visitado[inicio] = true;
        queue.offer(inicio);
 
        System.out.print("BFS desde " + vertices[inicio] + ": ");
 
        while (!queue.isEmpty()) {
            int actual = queue.poll();
            System.out.print(vertices[actual] + " ");
 
            for (int j = 0; j < n; j++) {
                if (matriz[actual][j] == 1 && !visitado[j]) {
                    visitado[j] = true;   // marca al encolar
                    queue.offer(j);
                }
            }
        }
        System.out.println();
    }
 
    // DFS usando Stack — marca al apilar
    public void dfs(int inicio) {
        boolean[] visitado = new boolean[n];
        Stack<Integer> stack = new Stack<>();
 
        visitado[inicio] = true;
        stack.push(inicio);
 
        System.out.print("DFS desde " + vertices[inicio] + ": ");
 
        while (!stack.isEmpty()) {
            int actual = stack.pop();
            System.out.print(vertices[actual] + " ");
 
            for (int j = 0; j < n; j++) {
                if (matriz[actual][j] == 1 && !visitado[j]) {
                    visitado[j] = true;   // marca al apilar
                    stack.push(j);
                }
            }
        }
        System.out.println();
    }
}