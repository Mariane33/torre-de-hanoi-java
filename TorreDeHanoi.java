import java.util.Stack;

class Pino {
    private Stack<Integer> discos;
    private String nome;

    public Pino(String nome) {
        this.nome = nome;
        discos = new Stack<>();
    }

    public void push(int disco) {
        discos.push(disco);
    }

    public int pop() {
        return discos.pop();
    }

    public int peek() {
        return discos.peek();
    }

    public boolean isEmpty() {
        return discos.isEmpty();
    }

    public String getNome() {
        return nome;
    }

    public void mostrar() {
        System.out.println("Pino" + nome + ": " + discos);
    }

    public class TorreDeHanoi {
    
        public static void moverDiscos(int n, Pino origem, Pino destino, Pino Auxiliar) {
            if (n == 1) {
                int disco = origem.pop();
                destino.push(disco);
                System.out.println("Movendo disco " + disco + " de " + origem.getNome() + " para " + destino.getNome());
            } else {
                moverDiscos(n - 1, origem, Auxiliar, destino);
                moverDiscos(1, origem, destino, Auxiliar);
                moverDiscos(n - 1, Auxiliar, destino, origem);
            }
        }

        public static void main(String[] args) {
            int numDiscos = 3;

            Pino origem = new Pino("Origem");
            Pino destino = new Pino("Destino");
            Pino Auxiliar = new Pino("Auxiliar");

            // Empilhando os discos na origem (do maior para o menor)
            for (int i = numDiscos; i >= 1; i--) {
                origem.push(i);
            }

            System.out.println("Estado Inicial");
            origem.mostrar();
            destino.mostrar();
            Auxiliar.mostrar();
            System.out.println();

            moverDiscos(numDiscos, origem, destino, Auxiliar);

            System.out.println("\nEstado final:");
            origem.mostrar();
            destino.mostrar();
            Auxiliar.mostrar();
        }
    }
}