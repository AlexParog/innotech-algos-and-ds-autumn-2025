package ru.parog.section_1_basic_algo;

public class MiniMatrixGraph {
    // Константы для узлов
    static final int A = 0, B = 1, C = 2, D = 3;
    static final char[] name = {'A', 'B', 'C', 'D'};
    static final double NO = -1; // Нет связи

    // Матрицы для хранения capacity и loss
    static final double[][] cap = new double[4][4];
    static final double[][] loss = new double[4][4];

    // Добавить ребро между узлами u и v
    static void add(int u, int v, double c, double l) {
        cap[u][v] = cap[v][u] = c;    // Симметрично для capacity
        loss[u][v] = loss[v][u] = l;  // Симметрично для loss
    }

    public static void main(String[] args) {
        // Инициализация: все связи = NO
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                cap[i][j] = NO;
                loss[i][j] = NO;
            }
        }

        // Добавляем рёбра
        add(A, B, 800, 15);   // A-B: 800 Mbps, 15% потерь
        add(A, C, 1200, 5);   // A-C: 1200 Mbps, 5% потерь
        add(A, D, 1000, 20);  // новая связь A-D: 1000 Mbps, 20% потерь
        add(B, D, 600, 25);   // B-D: 600 Mbps, 25% потерь
        add(C, D, 400, 10);   // C-D: 400 Mbps, 10% потерь
        add(B, C, 300, 40);   // B-C: 300 Mbps, 40% потерь

        // Выводим все рёбра (каждое только один раз)
        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 4; j++) {
                if (cap[i][j] != NO) {
                    System.out.printf("%c-%c cap=%.0f loss=%.0f%%%n",
                            name[i], name[j], cap[i][j], loss[i][j]);
                }
            }
        }
    }

}
