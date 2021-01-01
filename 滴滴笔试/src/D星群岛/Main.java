package D星群岛;

import java.util.Scanner;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/9/13 20:05
 */
public class Main {
    public static void build(){
        Scanner in=new Scanner(System.in);
        int T;
        int sum=0;
        int count=0;
        T=in.nextInt();
        String[] str=new String[T];
        for (int i = 0; i < T; i++) {
            int n;int m;int k;
            n=in.nextInt();
            m=in.nextInt();
            k=in.nextInt();
            if(n<=1){
                System.out.println("true");
            }
            int min=n-1;
            int max=(int)(0.5*n*n+0.5*n);
            if(n>100 || m>1000 || k>10000 || m<min || m>max){
                System.out.println("false");
            }
            for (int j = 0; j < m; j++) {
                int a=in.nextInt();
                int b=in.nextInt();
                int c=in.nextInt();
                sum+=c;
            }
            if(sum<=k*m){
                str[count++]="ture";
            }else{
                str[count++]="false";
            }
        }
        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]);
        }
    }
    public static void main(String[] args) {
        build();
    }
}
