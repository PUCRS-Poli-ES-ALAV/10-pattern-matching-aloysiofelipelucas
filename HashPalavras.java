import java.util.Scanner;
import java.util.Random;

//O(n)

public class HashPalavras{

    private static String[] letras = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W",  "X", "Y", "Z"};
    public static int cont = 0;

    public static void main(String args[]){
        
        Scanner in = new Scanner(System.in);
        int tamString = in.nextInt();
        int tamSubstring = in.nextInt();

        Random gerador = new Random();
        int aleatorio = 0;

        String s1  = "";
        String s2 = "";

        for(int i = 0; i<tamString; i++){
            aleatorio = gerador.nextInt(26);
            s1 = s1+letras[aleatorio];
        }
        for(int i = 0; i<tamSubstring; i++){
            aleatorio = gerador.nextInt(26);
            s2 = s2+letras[aleatorio];
        }

        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);
        long start = System.currentTimeMillis();
        int match = matchLetters(s1, s2);
        long elapsed = System.currentTimeMillis() - start;
        if(match>=0){
            System.out.println("A ocorrencia ocorre no indice: "+ match);
        }
        else{
            System.out.println("Não tem ocorrencias da s2 em s1");
        }
        System.out.println("Num de interações é "+ cont);
        System.out.println(elapsed+" ms");
        in.close();
    }

    private static long hash(String s, int M) {
        long h = 0;
        for (int j = 0; j < M; j++){
            cont++;
            h = (h * letras.length + s.charAt(j)) % Integer.MAX_VALUE;
        }
        return h;
     }

    public static int matchLetters(String s1, String s2){
        int M = s2.length();
        int N = s1.length();
        long patHash = hash(s2, M);
        for (int i = 0; i <= N - M; i++) {
            long txtHash = hash(s1.substring(i, i+M), M);
            if (patHash == txtHash)
                return (i+1); 
        }
        return -1;
    }
}
