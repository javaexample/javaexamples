package vmachine;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * �Ž��� ���� ��Ÿ���� Change Ŭ���� ������ �ϼ��غ��ϴ�.
 * 
 * �� ������ �ϼ��ϰ��� Ŀ�� ���Ǳ� ������ Ǯ�� �˴ϴ�.
 *
 */
public class ChangeMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int money = 0;
		
		System.out.println("�Ž����� ����");
		
		while ( true ) {
			System.out.println();
			System.out.print(">> �ݾ�(�������� Q�Է�): ");			
			try {
				money = scanner.nextInt();
			} catch (Exception e) {
				break;
			}
			
			if ( isInvalid(money) ) {
				System.out.println("1�� ������ �Է� �Ұ� : " + money );
				continue;
			}
			
			Change change = new Change(money);
			printChange(System.out, change);
		}
		
		System.out.println("Good bye!");
	}
	
	/**
	 * �ݾ׿� 1�������� ���ԵǾ������� �Ǵ��ϴ� �޼ҵ��Դϴ�.
	 * 349��ó�� 10�� �̸��� �ݾ��� �ԷµǸ� true, 
	 * 1890 ó�� 10������������ �ԷµǸ� false�� ��ȯ�մϴ�.
	 * main �޼ҵ忡�� �� �޼ҵ带 ȣ���ؼ� �Է� �ݾ��� �����ϰ� �ֽ��ϴ�.
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
		
		System.out.printf("�Ž�����   %4d ��\n", change.getChangeAmount());
		System.out.printf("�����ǰ��� %4d ��\n", numOfTotalCoin);
		System.out.printf("1. 500�� : %3d��\n", numOf500);
		System.out.printf("2. 100�� : %3d��\n", numOf100);
		System.out.printf("3.  50�� : %3d��\n", numOf50);
		System.out.printf("4.  10�� : %3d��\n", numOf10);
		
	}

}
