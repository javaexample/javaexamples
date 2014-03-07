package vmachine;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class AppMain {

	public static void main(String[] args) {
		CoffeeMachine machine = new CoffeeMachine();
		
		Scanner scanner = new Scanner(System.in);
		ArrayList<Coffee> coffees = new ArrayList<>(); // ������ Ŀ�ǵ��� ��� ���� ����Ʈ
		
		System.out.println("Ŀ�� ���Ǳ� ���ø����̼��� �����մϴ�.");

		printMenu(System.out, machine);
		while ( true ) {
			System.out.print("  >> �޴� ��ȣ : ");
			int cmd = scanner.nextInt();
			
			if ( cmd == 9) { // �� �Է�
				processInputMoney(scanner, machine );
			}
			else if ( cmd == 10 ) {
				// �ܵ� ��ȯ
				processChange(machine);
				break; // ���� ���� ��ȯ�����Ƿ� while ���� ����
			} else {
				// �޴� ���� 1 ~ 8
				/* Ŀ�� ID �� 
				 * ��ũĿ��[�Ϲ�] C00   ��ũĿ��[���] C04 
				 * ����Ŀ��[�Ϲ�] C01   ����Ŀ��[���] C05
				 * ����Ŀ��[�Ϲ�] C02   ����Ŀ��[���] C06 
				 * ��Ŀ��[�Ϲ�] C03   ����Ŀ��[���] C07
				 *  
				 */
				String coffeeID = "C0" + (cmd-1);
				try {
					Coffee coffee = machine.choose(coffeeID);
					coffees.add(coffee);
					System.out.println("  " + coffee.getName() + "�� ���Խ��ϴ�.");
				} catch (MachineException e) {
					System.out.println(e.getMessage());
				}
			}
			
			printMenu(System.out, machine);
		}
		
		printSelectedCoffee(coffees);
		
		System.out.println("  ���ø����̼��� �����մϴ�.");
	}
	
	/**
	 * ���Ǳ⿡ ���� �ִ� �޼ҵ�
	 * @param scanner
	 * @return
	 */
	private static int processInputMoney(Scanner scanner, CoffeeMachine machine) {
		System.out.print("  >> ���� �ݾ�(�Է� �� ����) : ");
		int money = scanner.nextInt();
		machine.input(money);
		System.out.println("  " + money + "�� �־����ϴ�.");
		return money ;
	}
	
	/**
	 * �Ž������� ��ȯ�� �ùķ��̼��� �޼ҵ�
	 * @param machine
	 */
	private static void processChange(CoffeeMachine machine) {
		Change change = machine.getChange();
		printChange(System.out, change) ;
	}
	
	/**
	 * ȭ�鿡 �޴��� ����ϴ� �޼ҵ�
	 * @param out
	 * @param machine
	 */
	private static void printMenu(PrintStream out, CoffeeMachine machine) {
		out.println();
		out.println("============================================= ");
		out.println("1. ��ũ[�Ϲ�] 350��    5. ��ũ[���] 800��") ;
		out.println("2. ����[�Ϲ�] 350��    6. ����[���] 800��") ;
		out.println("3. ����[�Ϲ�] 300��    7. ����[���] 600��") ;
		out.println("4. ��[�Ϲ�] 300��    8. ����[���] 700��") ;
		out.println();
		out.println("9. �� �Է�           10. ��ȯ");
		out.println("   ���� �ݾ� : " +  machine.getCurrentAmount() );
		out.println("============================================= ");
	}
	
	private static void printSelectedCoffee(List<Coffee> coffees ) {
		
		System.out.println("  ������ Ŀ�ǵ�");
		
		if ( coffees.size() == 0 ) {
			System.out.println("  ������ Ŀ�ǰ� �����ϴ�.");
		} else {			
			Iterator<Coffee> it = coffees.iterator();
			while ( it.hasNext() ) {
				System.out.println("    " + it.next().getName());
			}
		}
	}
	private static void printChange(PrintStream out, Change change){
		int numOfTotalCoin = change.getCoinCount();
		
		int numOf10 = change.getCoinCount(Change.C10);
		int numOf50 = change.getCoinCount(Change.C50);
		int numOf100 = change.getCoinCount(Change.C100);
		int numOf500 = change.getCoinCount(Change.C500);
		
		System.out.printf("  �Ž�����   %4d ��\n", change.getChangeAmount());
		System.out.printf("  �����ǰ��� %4d ��\n", numOfTotalCoin);
		System.out.printf("  1.  10�� : %3d��\n", numOf10);
		System.out.printf("  2.  50�� : %3d��\n", numOf50);
		System.out.printf("  3. 100�� : %3d��\n", numOf100);
		System.out.printf("  4. 500�� : %3d��\n", numOf500);
		
	}

}
