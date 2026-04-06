import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String[] members = new String[101];
        Scanner sc = new Scanner(System.in);
        int n;
        do{
            System.out.println("아기사자 수를 입력하시오 : ");
            n = sc.nextInt();
            if(n < 5) System.out.println("5명 이상 입력해주세요");
        }while(n<5);

        sc.nextLine();

        System.out.println("아기사자 이름을 입력해주세요");
        for(int i=0; i<n; i++){
            members[i] = sc.nextLine();
        }
        System.out.println("명단 출력");
        for(int i=0; i<n; i++){
            System.out.println((i+1)+". "+members[i]);
        }
    }
}