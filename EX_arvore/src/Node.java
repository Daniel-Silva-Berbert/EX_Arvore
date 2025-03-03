public class Node {
    Aluno elemento;
    Node esquerda;
    Node direita;

    public Node(Aluno aluno){
        this.elemento = aluno;
        this.esquerda = null;
        this.direita = null;
    }
}
