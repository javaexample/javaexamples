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
	 * �մ��� ���� �ݾ��� �����ϴ� ����
	 * choose() �޼ҵ带 ȣ���ؼ� Ŀ�Ǹ� ���������� Ŀ���� �ݾ׸�ŭ�� �����ؾ� ��.
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
		coffees.add(new Coffee("C00", "��ũĿ��[�Ϲ�]", 350));
		coffees.add(new Coffee("C01", "����Ŀ��[�Ϲ�]", 350));
		coffees.add(new Coffee("C02", "����Ŀ��[�Ϲ�]", 300));
		coffees.add(new Coffee("C03", "��Ŀ��[�Ϲ�]", 300));
		
		coffees.add(new Coffee("C04", "��ũĿ��[���]", 800));
		coffees.add(new Coffee("C05", "����Ŀ��[���]", 800));
		coffees.add(new Coffee("C06", "����Ŀ��[���]", 600));
		coffees.add(new Coffee("C07", "����Ŀ��[���]", 700));
	}
	
	/**
	 * �մ��� ���� �ݾ�
	 * @param money
	 */
	public void input(int money ) {
		inputMoney +=  money ;
	}
	
	/**
	 * �մ��� Ư�� Ŀ���� ��ư�� ���������� �ùķ��̼� �ϴ� �޼ҵ�.
	 * 
	 * Ŀ���� �ݾ׸�ŭ ���� �Էµ� �ݾ׿��� �����ؾ� �մϴ�.
	 * 
	 * @param coffeeID Ư�� Ŀ�Ǹ� ��Ÿ���� ��.
	 * @return ���õ� Ŀ���� instance�� ��ȯ.
	 * @throws MachineException �־��� coffeeID �� �����ϴ� Ŀ�ǰ� ���� ��쿡 ������
	 */
	public Coffee choose(String coffeeID) throws MachineException {
		Coffee choosenCoffee = findCoffee(coffeeID);
		
		if ( choosenCoffee == null) {
			// ���� Ŀ��
			throw new MachineException("Ŀ�Ǹ� ã�� �� �����ϴ�. : " + coffeeID );
		}
		
		int price = choosenCoffee.getPrice();
		
		if ( inputMoney < price) {			
			throw new MachineException("�ܾ��� �����մϴ�. ���� �ܾ� : " + inputMoney + " , Ŀ�� ���� : " + price );
		}
		inputMoney -= price ;
		return choosenCoffee ;
	}
	
	/**
	 * ���� ���� �Ž������� ��ȯ����.
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
	 * ���� ���Ǳ⿡ �����ִ� �ݾ��� ���
	 * @return
	 */
	public int getCurrentAmount() {
		return inputMoney ;
	}
	
}
