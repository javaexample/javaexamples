package vmachine;
/**
 * �̹����� �Ž����� �ν��Ͻ��� �ʱ�ȭ�ϴ� �޼ҵ带 �ϼ��մϴ�.
 * 
 * initChange(int money) �޼ҵ带 ȣ���ϸ� changes �迭�� �ݾ׿� �°� �����Ǿ�� �մϴ�.
 * 
 * money �� 980�̸�
 * 
 * 500�� 1��, 100�� 4��, 50�� 1�� 10�� 4��
 * 
 * �� changes �迭�� �ʱ�ȭ�Ǿ�� �մϴ�.
 * 
 * 
 * 
 * 
 * 
 *
 */
public class Change {
	final public static int C10  = 0;
	final public static int C50  = 1;
	final public static int C100 = 2;
	final public static int C500 = 3;
	
	private int [] changes = new int [4];
	
	public Change(int money) {
		initChange( money ) ;
	}
	
	/**
	 * �־��� �Ž������� �����ϴ� ������ ������ changes �迭�� �ݿ��ϴ� �ڵ��Դϴ�.
	 * 
	 * @param money
	 */
	private void initChange(int money ) {
		// �Ʒ��� �۾��� �ϵ��� �� �޼ҵ带 �ϼ��ؾ� �մϴ�.
		// 500��¥�� ���� ����
		// 100��¥�� ���� ����
		//  50��¥�� ���� ����
		//  10��¥�� ���� ����
	}
	
	public void setChange(int coinType , int counter) {
		changes[coinType] = counter ;
	}
	
	/**
	 * ���� �Ž������� �����ϴ� �������� ��ü �ݾ��� ����ؼ� ��ȯ���ݴϴ�.
	 * @return ��ü �Ž����� �ݾ�
	 */
	public int getChangeAmount() {
		int totalAmount = 0; // ��ü �Ž������� �����ϴ� ����
		
		totalAmount += changes[C10]*10;
		totalAmount += changes[C50]*50;
		totalAmount += changes[C100]*100;
		totalAmount += changes[C500]*500;
		
		return totalAmount ;
	}
	
	/**
	 * �Ž������� �����ϴ� ������ ��ü ������ ��ȯ�մϴ�.
	 * 
	 * @return
	 */
	public int getCoinCount() {
		int coinCount = 0;
		
		for (int i = 0; i < changes.length; i++) {
			coinCount += changes[i];
		}
		
		return coinCount;
	}

	/**
	 * �־��� Ÿ���� ���� ������ ��ȯ�մϴ�.
	 * coinType�� �Ʒ��� 4���� �� �� �ϳ����� �մϴ�.
	 * 
	 *    Change.C10 - 10��¥���� �ǹ�
	 *    Change.C50 - 50��¥���� �ǹ�
	 *    Change.C100 - 100��¥���� �ǹ�
	 *    Change.C500 - 500��¥���� �ǹ�
	 *    
	 * @param coinType
	 * @return �־��� Ÿ���� ���� ����
	 */
	public int getCoinCount(int coinType) {
		return changes[coinType];
	}
	
	
}
