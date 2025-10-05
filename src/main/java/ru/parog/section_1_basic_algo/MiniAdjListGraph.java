package ru.parog.section_1_basic_algo;

import java.util.ArrayList;
import java.util.List;

public class MiniAdjListGraph {
    // Константы для узлов
    static final int A = 0, B = 1, C = 2, D = 3;
    static final char[] name = {'A', 'B', 'C', 'D'};

    // Класс для ребра
    static class Edge {
        final int to;           // Куда ведёт ребро
        final double cap, loss; // Параметры ребра

        Edge(int t, double c, double l) {
            to = t;
            cap = c;
            loss = l;
        }
    }

    // Массив списков рёбер для каждого узла
    static final List<Edge>[] g = new ArrayList[4];

    // Добавить ребро между узлами u и v
    static void add(int u, int v, double c, double l) {
        g[u].add(new Edge(v, c, l));  // Добавляем в список u
        g[v].add(new Edge(u, c, l));  // Добавляем в список v
    }

    public static void main(String[] args) {
        // Инициализация: создаём пустые списки
        for (int i = 0; i < 4; i++) {
            g[i] = new ArrayList<>();
        }

        // Добавляем рёбра
        add(A, B, 800, 15);   // A-B: 800 Mbps, 15% потерь
        add(A, C, 1200, 5);   // A-C: 1200 Mbps, 5% потерь
        add(A, D, 1000, 20);  // новая связь A-D: 1000 Mbps, 20% потерь
        add(B, D, 600, 25);   // B-D: 600 Mbps, 25% потерь
        add(C, D, 400, 10);   // C-D: 400 Mbps, 10% потерь
        add(B, C, 300, 40);   // B-C: 300 Mbps, 40% потерь

        // Выводим все рёбра (каждое только один раз)
        for (int u = 0; u < 4; u++) {
            for (Edge e : g[u]) {
                if (u < e.to) {  // Чтобы не дублировать рёбра
                    System.out.printf("%c-%c cap=%.0f loss=%.0f%%%n",
                            name[u], name[e.to], e.cap, e.loss);
                }
            }
        }
    }

}
