import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        Tree bst = new Tree();

        int nums = in.nextInt();

        while(nums != 0){
            bst.inserir(in.nextInt());
            nums--;
        }
        
        bst.menorPorNivel();
    }
}
