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
		ArrayList<Coffee> coffees = new ArrayList<>(); // 선택한 커피들을 담기 위한 리스트
		
		System.out.println("커피 자판기 애플리케이션을 시작합니다.");

		printMenu(System.out, machine);
		while ( true ) {
			System.out.print("  >> 메뉴 번호 : ");
			int cmd = scanner.nextInt();
			
			if ( cmd == 9) { // 돈 입력
				processInputMoney(scanner, machine );
			}
			else if ( cmd == 10 ) {
				// 잔돈 반환
				processChange(machine);
				break; // 남은 돈을 반환했으므로 while 문을 종료
			} else {
				// 메뉴 선택 1 ~ 8
				/* 커피 ID 는 
				 * 밀크커피[일반] C00   밀크커피[고급] C04 
				 * 설탕커피[일반] C01   설탕커피[고급] C05
				 * 프림커피[일반] C02   프림커피[고급] C06 
				 * 블랙커피[일반] C03   원두커피[고급] C07
				 *  
				 */
				String coffeeID = "C0" + (cmd-1);
				try {
					Coffee coffee = machine.choose(coffeeID);
					coffees.add(coffee);
					System.out.println("  " + coffee.getName() + "이 나왔습니다.");
				} catch (MachineException e) {
					System.out.println(e.getMessage());
				}
			}
			
			printMenu(System.out, machine);
		}
		
		printSelectedCoffee(coffees);
		
		System.out.println("  애플리케이션을 종료합니다.");
	}
	
	/**
	 * 자판기에 돈을 넣는 메소드
	 * @param scanner
	 * @return
	 */
	private static int processInputMoney(Scanner scanner, CoffeeMachine machine) {
		System.out.print("  >> 넣을 금액(입력 후 엔터) : ");
		int money = scanner.nextInt();
		machine.input(money);
		System.out.println("  " + money + "원 넣었습니다.");
		return money ;
	}
	
	/**
	 * 거스름돈을 반환을 시뮬레이션한 메소드
	 * @param machine
	 */
	private static void processChange(CoffeeMachine machine) {
		Change change = machine.getChange();
		printChange(System.out, change) ;
	}
	
	/**
	 * 화면에 메뉴를 출력하는 메소드
	 * @param out
	 * @param machine
	 */
	private static void printMenu(PrintStream out, CoffeeMachine machine) {
		out.println();
		out.println("============================================= ");
		out.println("1. 밀크[일반] 350원    5. 밀크[고급] 800원") ;
		out.println("2. 설탕[일반] 350원    6. 설탕[고급] 800원") ;
		out.println("3. 프림[일반] 300원    7. 프림[고급] 600원") ;
		out.println("4. 블랙[일반] 300원    8. 원두[고급] 700원") ;
		out.println();
		out.println("9. 돈 입력           10. 반환");
		out.println("   현재 금액 : " +  machine.getCurrentAmount() );
		out.println("============================================= ");
	}
	
	private static void printSelectedCoffee(List<Coffee> coffees ) {
		
		System.out.println("  선택한 커피들");
		
		if ( coffees.size() == 0 ) {
			System.out.println("  선택한 커피가 없습니다.");
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
		
		System.out.printf("  거스름돈   %4d 원\n", change.getChangeAmount());
		System.out.printf("  동전의개수 %4d 개\n", numOfTotalCoin);
		System.out.printf("  1.  10원 : %3d개\n", numOf10);
		System.out.printf("  2.  50원 : %3d개\n", numOf50);
		System.out.printf("  3. 100원 : %3d개\n", numOf100);
		System.out.printf("  4. 500원 : %3d개\n", numOf500);
		
	}

}
