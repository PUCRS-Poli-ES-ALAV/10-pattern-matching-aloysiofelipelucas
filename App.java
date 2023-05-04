import java.util.Scanner;

//O(n)

public class App{
    public static int cont = 0;
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        String s1  = in.nextLine();
        String s2 = in.nextLine();

        int match = matchLetters(s1, s2);
        if(match>0){
            System.out.println("A ocorrencia ocorre no indice: "+ match);
        }
        else{
            System.out.println("Não tem ocorrencias da s2 em s1");
        }
        System.out.println("Num de interações é "+ cont);
        in.close();
    }

    public static int matchLetters(String s1, String s2){
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