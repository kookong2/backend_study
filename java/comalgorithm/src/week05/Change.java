package week05;

import java.util.Scanner;

public class Change {
	public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        System.out.println("거스름 돈을 입력해 주세요");
        int change = scanner.nextInt();

        int [] coins = {500, 100, 50, 10};
        int [] n = new int[coins.length];

        for (int i = 0; i < coins.length; i++){
        	while(change >= coins[i]) {
        		change -= coins[i];
        		n[i] ++;
        	}
        }
       
        int nCoin = 0;
        
        for(int i = 0; i < coins.length; i++) {
        	System.out.printf("%d : %d개 \n", coins[i],n[i]);
        	nCoin += n[i];
        }
        System.out.printf("동전 수는 %d 입니다 \n", nCoin);
    }
}
