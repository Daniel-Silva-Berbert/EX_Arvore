import java.util.ArrayList;
import java.util.List;

public class Tree {
    Node raiz = null;

    public void inserir(int numero){
        inserir(raiz, numero);
    }

    private void inserir (Node no, int numero){
        if(no != null){
            if(numero < no.elemento)
            {
                if (no.esquerda == null){
                    no.esquerda = new Node(numero);
                }else{
                    inserir(no.esquerda, numero);
                }
            }else{
                if(no.direita == null){
                    no.direita = new Node(numero);
                }else{
                    inserir(no.direita, numero);
                }
            }
        }else{
            raiz = new Node(numero);
        }
    }

    public void menorPorNivel() throws Exception {
        if (raiz == null) {
            throw new Exception("A arvore está vazia");
        }

        List<Integer> menores = new ArrayList<>();
        menorPorNivel(raiz, 0, menores);

        for (int i = 0; i < menores.size(); ++i) {
            System.out.println(i + " " + menores.get(i));
        }
    }
    private void menorPorNivel(Node no, int nivel, List<Integer> menores) {
        if (no == null) {
            return;
        }

        if (nivel >= menores.size()) {
            menores.add(no.elemento);
        }

        menorPorNivel(no.esquerda, nivel + 1, menores);
        menorPorNivel(no.direita, nivel + 1, menores);
    }

    
}
