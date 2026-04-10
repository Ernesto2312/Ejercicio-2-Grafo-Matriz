package com.ejericio2;

public class Main {
    public static void main(String[] args) {
        // Índices: A=0, B=1, C=2, D=3, E=4, F=5, G=6
        String[] vertices = {"A", "B", "C", "D", "E", "F", "G"};
        GrafoMatriz g = new GrafoMatriz(vertices);
 
        g.agregarArista(0, 1); // A - B
        g.agregarArista(0, 2); // A - C
        g.agregarArista(0, 3); // A - D
        g.agregarArista(1, 2); // B - C
        g.agregarArista(1, 4); // B - E
        g.agregarArista(2, 5); // C - F
        g.agregarArista(3, 6); // D - G
        g.agregarArista(4, 5); // E - F
        g.agregarArista(4, 6); // E - G
        g.agregarArista(5, 6); // F - G
 
        g.mostrar();
 
        System.out.println();
        g.bfs(0); // Desde A
        g.dfs(0); // Desde A
    }
}