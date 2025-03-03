public class Tree {
    Node raiz = null;

    public void inserir(Aluno aluno){
        inserir(raiz, aluno);
    }

    private void inserir (Node no, Aluno aluno){
        if(no != null){
            if(aluno.getMatricula() < no.elemento.getMatricula())
            {
                if (no.esquerda == null){
                    no.esquerda = new Node(aluno);
                }else{
                    inserir(no.esquerda, aluno);
                }
            }else{
                if(no.direita == null){
                    no.direita = new Node(aluno);
                }else{
                    inserir(no.direita, aluno);
                }
            }
        }else{
            raiz = new Node(aluno);
        }
    }

    public Aluno maiorAluno() throws Exception{
        if(raiz == null){
            throw new Exception("A arvore está vazia");
        }
        else{
            return maiorAluno(raiz);
        }
    }

    private Aluno maiorAluno(Node no){
        if(no.direita == null)
            return no.elemento;
        else
            return maiorAluno(no.direita);
    }

    public boolean buscarAluno(int matricula) throws Exception{
        if(raiz == null){
            throw new Exception("A arvore está vazia");
        }else{
            return buscarAluno(matricula, raiz);
        }
    }

    private boolean buscarAluno(int matricula, Node no) throws Exception{
        if(no != null){
            if(no.elemento.getMatricula() == matricula)
                return true;
            else
                return buscarAluno(matricula, no.direita) || buscarAluno(matricula, no.esquerda);
        }else{
            return false;
        }
    }

    public void preOrdem() throws Exception{
        if(raiz == null)
            throw new Exception("A arvore está vazia");
        else
            preOrdem(raiz);
    }

    private void preOrdem(Node no) {
        if(no != null){
            System.out.println("Nome: " + no.elemento.getNome());
            System.out.println("Matricula: " + no.elemento.getMatricula());
            System.out.println("Curso: " + no.elemento.getCurso());
            System.out.println("---------------------------------");
            preOrdem(no.esquerda);
            preOrdem(no.direita);
        }
    }

    public Node remover(int matricula) throws Exception{
        if(raiz == null)
            throw new Exception("A arvore está vazia");
        return remover(raiz, matricula);
    }

    private Node remover(Node no, int matricula) throws Exception{
        boolean ajuste = false;
        
        if(no == null){
            throw new Exception("Valor não encontrado");
        }else{
            if(matricula < no.elemento.getMatricula()){
                no.esquerda = remover(no.esquerda, matricula);
            }else{
                if (matricula > no.elemento.getMatricula()){
                    no.direita = remover(no.direita, matricula);
                }else{
                    if (no.direita != null && no.esquerda !=null){
                        no.elemento =  maiorAluno(no.esquerda);
                        no.esquerda = removeMaximo(no.esquerda);
                    }else{
                        if(no == raiz){
                            ajuste = true;
                        }
                        no = (no.esquerda !=null ? no.esquerda: no.direita);
                        if(ajuste) raiz = no;
                    }
                }
            }
            return no;
        }
    }

    private Node removeMaximo(Node no) throws Exception{
        if(no == null){
            throw new Exception("Raiz nula");
        }else{
            if (no.direita !=null){
                no.direita = removeMaximo(no.direita);
                return no;
            }else{
                return no.direita;
            }
        }
    }

    
}
