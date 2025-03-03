public class App {
    public static void main(String[] args) throws Exception {
        Tree bst = new Tree();
        bst.inserir(new Aluno(50, "Aluno 0", "ESTI"));
        bst.inserir(new Aluno(100, "Aluno 1", "ESTI"));
        bst.inserir(new Aluno(56, "Aluno 2", "ESTI"));
        bst.inserir(new Aluno(2, "Aluno 3", "ESTI"));
        bst.inserir(new Aluno(4, "Aluno 4", "ESTI"));
        bst.inserir(new Aluno(30, "Aluno 5", "ESTI"));
        bst.inserir(new Aluno(51, "Aluno 6", "ESTI"));
        bst.inserir(new Aluno(58, "Aluno 7", "ESTI"));
        bst.inserir(new Aluno(9, "Aluno 8", "ESTI"));
        bst.inserir(new Aluno(57, "Aluno 9", "ESTI"));

        System.out.println(bst.maiorAluno().getNome());
        System.out.println(bst.buscarAluno(10)? "O aluno existe": "O aluno não existe");
        bst.preOrdem();
        bst.remover(56);
        bst.preOrdem();
    }
}
