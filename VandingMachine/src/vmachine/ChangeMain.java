package vmachine;

import java.io.PrintStream;
import java.util.Scanner;

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
		
		Scanner scanner = new Scanner(System.in);
		int money = 0;
		
		System.out.println("거스름돈 계산기");
		
		while ( true ) {
			System.out.println();
			System.out.print(">> 금액(끝내려면 Q입력): ");			
			try {
				money = scanner.nextInt();
			} catch (Exception e) {
				break;
			}
			
			if ( isInvalid(money) ) {
				System.out.println("1원 단위는 입력 불가 : " + money );
				continue;
			}
			
			Change change = new Change(money);
			printChange(System.out, change);
		}
		
		System.out.println("Good bye!");
	}
	
	/**
	 * 금액에 1원단위가 포함되었는지를 판단하는 메소드입니다.
	 * 349원처럼 10원 미만의 금액이 입력되면 true, 
	 * 1890 처럼 10원단위까지만 입력되면 false를 반환합니다.
	 * main 메소드에서 이 메소드를 호출해서 입력 금액을 검증하고 있습니다.
	 * 
	 * @param money
	 * @return
	 */
	private static boolean isInvalid(int money ) {
		return money % 10 != 0 ; 
	}
	
	static void printChange(PrintStream out, Change change){
		int numOfTotalCoin = change.getCoinCount();
		
		int numOf10 = change.getCoinCount(Change.C10);
		int numOf50 = change.getCoinCount(Change.C50);
		int numOf100 = change.getCoinCount(Change.C100);
		int numOf500 = change.getCoinCount(Change.C500);
		
		System.out.printf("거스름돈   %4d 원\n", change.getChangeAmount());
		System.out.printf("동전의개수 %4d 원\n", numOfTotalCoin);
		System.out.printf("1. 500원 : %3d개\n", numOf500);
		System.out.printf("2. 100원 : %3d개\n", numOf100);
		System.out.printf("3.  50원 : %3d개\n", numOf50);
		System.out.printf("4.  10원 : %3d개\n", numOf10);
		
	}

}
