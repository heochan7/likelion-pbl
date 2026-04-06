import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String[] members = new String[101];
        Scanner sc = new Scanner(System.in);
        int n;
        do{
            System.out.print("아기사자 수를 입력하시오 : ");
            n = sc.nextInt();
        }while(n < 5);
        sc.nextLine();

        for(int i=0; i<n; i++){
            members[i] = sc.nextLine();
        }

        for(int i=0; i<n; i++){
            System.out.println(members[i]);
        }
    }
}