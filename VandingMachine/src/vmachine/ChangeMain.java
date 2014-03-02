package vmachine;

import java.io.PrintStream;

public class ChangeMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Change change = new Change();
		
		// 10�� 1��, 50�� 1��, 100�� 3��
		// -> ��ü �Ž����� 360��
		// -> ������ ���� 5��
		change.setChange(Change.C10, 1);
		change.setChange(Change.C50, 1);
		change.setChange(Change.C100, 3);
		
		/* printChange() �޼ҵ�� �Ʒ��� ���� ��µǾ�� �մϴ�.
		 * 
		 *   �Ž�����    360 ��
		 *   �����ǰ���    5 ��
		 *   1.  10�� :   1��
		 *   2.  50�� :   1��
		 *   3. 100�� :   3��
		 *   4. 500�� :   0��
		 *   
		 */
		printChange(System.out, change );
		
		
		change = new Change();
		// 10�� 3��, 100�� 4��, 500�� 1��
		// -> ��ü �Ž����� 930��
		// -> ������ ���� 8��
		change.setChange(Change.C10, 3);
		change.setChange(Change.C100, 4);
		change.setChange(Change.C500, 1);
		
		/* printChange() �޼ҵ�� �Ʒ��� ���� ��µǾ�� �մϴ�.
		 * 
		 *   �Ž�����    930 ��
		 *   �����ǰ���    8 ��
		 *   1.  10�� :   3��
		 *   2.  50�� :   0��
		 *   3. 100�� :   4��
		 *   4. 500�� :   1��
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
		
		System.out.printf("�Ž�����   %4d ��\n", change.getChangeAmount());
		System.out.printf("�����ǰ��� %4d ��\n", numOfTotalCoin);
		System.out.printf("1.  10�� : %3d��\n", numOf10);
		System.out.printf("2.  50�� : %3d��\n", numOf50);
		System.out.printf("3. 100�� : %3d��\n", numOf100);
		System.out.printf("4. 500�� : %3d��\n", numOf500);
		
	}

}
