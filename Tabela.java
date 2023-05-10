import java.util.Random;

//O(n)

public class Tabela{

    private static String[] letras = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W",  "X", "Y", "Z"};
    public static int cont = 0;

    public static void main(String args[]){

        Tupla[][] tabela = new Tupla[3][7]; 

        tabela[1][0] =  new Tupla("Nosso algoritmo", "");
        tabela[2][0] =  new Tupla("Rabin-Karp algoritmo", "");
        Random gerador = new Random();
        int aleatorio = 0;

        String s1  = "";
        String s2 = "";
        int tamString = 10;

        for(int j = 1; j<7; j++){
            s1  = "";
            s2 = "";
            for(int i = 0; i<tamString; i++){
                aleatorio = gerador.nextInt(26);
                s1 = s1+letras[aleatorio];
            }
            for(int i = 0; i<3; i++){
                aleatorio = gerador.nextInt(26);
                s2 = s2+letras[aleatorio];
            }
            tabela[0][j] =  new Tupla(s1,s2);
            tamString *= 10;

            long start = System.currentTimeMillis();
            int matchNosso = matchLettersNosso(s1, s2);
            long elapsed = System.currentTimeMillis() - start;
            tabela[1][j] =  new Tupla("Num de interações é "+ cont,elapsed+" ms");

            long startH = System.currentTimeMillis();
            int matchHash = matchLettersHash(s1, s2);
            long elapsedH = System.currentTimeMillis() - startH;
            tabela[2][j] =  new Tupla("Num de interações é "+ cont,elapsed+" ms");
        }

        for(Tupla[] linha : tabela){
            for(Tupla b: linha){
                System.out.print(b.num1+"-"b.num2+" | ");
            }
            System.out.println();
        }
    }

    private static long hash(String s, int M) {
        long h = 0;
        for (int j = 0; j < M; j++){
            cont++;
            h = (h * letras.length + s.charAt(j)) % Integer.MAX_VALUE;
        }
        return h;
     }

    public static int matchLettersHash(String s1, String s2){
        cont = 0;
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

    public static int matchLettersNosso(String s1, String s2){
        cont = 0;
        for(int i = 0; i <= s1.length(); i++){
            cont++;
            if(i+s2.length()<=s1.length()){
                if(s1.substring(i,i+s2.length()).equals(s2)){
                    return i;
                }
            }
            else{
                return -1;
            }
        }
        return -1;
    }
}