package vmachine;

import java.io.PrintStream;

/**
 * 거스름 돈을 나타내는 Change 클래스 구현을 완성해봅니다.
 * 
 * 이 구현을 완성하고나서 커피 자판기 예제를 풀게 됩니다.
 *
 */
public class ChangeMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Change change = new Change();
		
		// 10원 1개, 50원 1개, 100원 3개
		// -> 전체 거스름돈 360원
		// -> 동전의 개수 5개
		change.setChange(Change.C10, 1);
		change.setChange(Change.C50, 1);
		change.setChange(Change.C100, 3);
		
		/* printChange() 메소드는 아래와 같이 출력되어야 합니다.
		 * 
		 *   거스름돈    360 원
		 *   동전의개수    5 원
		 *   1.  10원 :   1개
		 *   2.  50원 :   1개
		 *   3. 100원 :   3개
		 *   4. 500원 :   0개
		 *   
		 */
		printChange(System.out, change );
		
		
		// 10원 3개, 100원 4개, 500원 1개
		// -> 전체 거스름돈 930원
		// -> 동전의 개수 8개
		change = new Change();
		change.setChange(Change.C10, 3);
		change.setChange(Change.C100, 4);
		change.setChange(Change.C500, 1);
		
		/* printChange() 메소드는 아래와 같이 출력되어야 합니다.
		 * 
		 *   거스름돈    930 원
		 *   동전의개수    8 원
		 *   1.  10원 :   3개
		 *   2.  50원 :   0개
		 *   3. 100원 :   4개
		 *   4. 500원 :   1개
		 *  
		 */
		printChange(System.out, change);
		
	}
	
	static void printChange(PrintStream out, Change change){
		int numOfTotalCoin = change.getCoinCount();
		
		int numOf10 = change.getCoinCount(Change.C10);
		int numOf50 = change.getCoinCount(Change.C50);
		int numOf100 = change.getCoinCount(Change.C100);
		int numOf500 = change.getCoinCount(Change.C500);
		
		System.out.printf("거스름돈   %4d 원\n", change.getChangeAmount());
		System.out.printf("동전의개수 %4d 원\n", numOfTotalCoin);
		System.out.printf("1.  10원 : %3d개\n", numOf10);
		System.out.printf("2.  50원 : %3d개\n", numOf50);
		System.out.printf("3. 100원 : %3d개\n", numOf100);
		System.out.printf("4. 500원 : %3d개\n", numOf500);
		
	}

}
