package grafo;

public class Grafo {
    private int numeroVertices;
    private int[][] matrizAdjacencia;

    public Grafo(int numeroVertices) {
        this.numeroVertices = numeroVertices;
        this.matrizAdjacencia = new int[numeroVertices][numeroVertices];
    }

    public void adicionarAresta(int origem, int destino) {
        matrizAdjacencia[origem][destino] = 1;
        matrizAdjacencia[destino][origem] = 1;
    }

    public boolean existeAresta(int origem, int destino) {
        return matrizAdjacencia[origem][destino] == 1;
    }

    public int[] obterArestas(int vertice) {
        int contador = 0;
        for (int i = 0; i < numeroVertices; i++) {
            if (matrizAdjacencia[vertice][i] == 1) {
                contador++;
            }
        }

        int[] adjacentes = new int[contador];
        contador = 0;

        for (int i = 0; i < numeroVertices; i++) {
            if (matrizAdjacencia[vertice][i] == 1) {
                adjacentes[contador++] = i;
            }
        }

        return adjacentes;
    }

    public void removerAresta(int origem, int destino) {
        matrizAdjacencia[origem][destino] = 0;
        matrizAdjacencia[destino][origem] = 0;
    }

    public void imprimirGrafo() {
        for (int i = 0; i < numeroVertices; i++) {
            System.out.print(i + " -> ");
            for (int j = 0; j < numeroVertices; j++) {
                if (matrizAdjacencia[i][j] == 1) {
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }
    }

    public int numeroVertices() {
        return numeroVertices;
    }

    public static void main(String[] args) {
        Grafo grafo = new Grafo(4);

        grafo.adicionarAresta(0, 1);
        grafo.adicionarAresta(1, 2);
        grafo.adicionarAresta(2, 0);
        grafo.adicionarAresta(3, 0);
        

        System.out.println("Matriz de Adjacencia:");
        grafo.imprimirGrafo();

        System.out.println("Numero de Vertices: " + grafo.numeroVertices());

        int[] vizinhos = grafo.obterArestas(1);
        System.out.print("Vizinhos do vertice 1: ");
        for (int vizinho : vizinhos) {
            System.out.print(vizinho + " ");
        }
        System.out.println();

        System.out.println("Existe aresta entre 1 e 2? " + grafo.existeAresta(1, 2));

        grafo.removerAresta(1, 2);

        System.out.println("\nDepois de remover a aresta (1, 2):");
        grafo.imprimirGrafo();
    }
}