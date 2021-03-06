package vmachine;

import java.util.ArrayList;

public class CoffeeMachine {

	private int currentMoney;
	
	private int change10 = 0;
	private int change50 = 0;
	private int change100 = 0;
	private int change500 = 0;
	
	private ArrayList<Coffee> coffees ;
	
	/**
	 * 손님이 넣은 금액을 보관하는 변수
	 * choose() 메소드를 호출해서 커피를 뽑을때마다 커피의 금액만큼을 차감해야 함.
	 * 
	 */
	private int inputMoney = 0;
	
	public CoffeeMachine() {
		currentMoney = 0;
		coffees = new ArrayList<Coffee>();
		initProduct();
		
		change10 = 20;
		change50 = 40;
		change100 = 40;
		
		change500 = 10;
	}
	
	private void initProduct() {
		coffees.add(new Coffee("C00", "밀크커피[일반]", 350));
		coffees.add(new Coffee("C01", "설탕커피[일반]", 350));
		coffees.add(new Coffee("C02", "프림커피[일반]", 300));
		coffees.add(new Coffee("C03", "블랙커피[일반]", 300));
		
		coffees.add(new Coffee("C04", "밀크커피[고급]", 800));
		coffees.add(new Coffee("C05", "설탕커피[고급]", 800));
		coffees.add(new Coffee("C06", "프림커피[고급]", 600));
		coffees.add(new Coffee("C07", "원두커피[고급]", 700));
	}
	
	/**
	 * 손님이 넣은 금액
	 * @param money
	 */
	public void input(int money ) {
		inputMoney +=  money ;
	}
	
	/**
	 * 손님이 특정 커피의 버튼을 눌렀을때를 시뮬레이션 하는 메소드.
	 * 
	 * 커피의 금액만큼 현재 입력된 금액에서 차감해야 합니다.
	 * 
	 * @param coffeeID 특정 커피를 나타내는 값.
	 * @return 선택된 커피의 instance를 반환.
	 * @throws MachineException 주어진 coffeeID 에 대응하는 커피가 없을 경우에 던져짐
	 */
	public Coffee choose(String coffeeID) throws MachineException {
		Coffee choosenCoffee = findCoffee(coffeeID);
		
		if ( choosenCoffee == null) {
			// 없는 커피
			throw new MachineException("커피를 찾을 수 없습니다. : " + coffeeID );
		}
		
		int price = choosenCoffee.getPrice();
		
		if ( inputMoney < price) {			
			throw new MachineException("잔액이 부족합니다. 현재 잔액 : " + inputMoney + " , 커피 가격 : " + price );
		}
		inputMoney -= price ;
		return choosenCoffee ;
	}
	
	/**
	 * 현재 남은 거스름돈을 반환해줌.
	 */
	public Change getChange() {
		
		Change change = new Change(this.inputMoney);
		return change;
	}
	
	private Coffee findCoffee ( String id) {
		
		for( int i = 0 ; i < coffees.size() ; i++ ) {
			if ( coffees.get(i).getID().equals(id)) {
				return coffees.get(i);
			}
		}
		
		return null;
	}

	/**
	 * 현재 자판기에 남아있는 금액을 출력
	 * @return
	 */
	public int getCurrentAmount() {
		return inputMoney ;
	}
	
}
