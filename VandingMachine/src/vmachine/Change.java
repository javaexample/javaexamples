package vmachine;
/**
 * �Ž�����(����)�� ��Ÿ���� Ŭ�����Դϴ�.
 * 
 * changes[0] ��  10 ��¥���� ����
 * changes[1] ��  50 ��¥���� ����
 * changes[2] �� 100 ��¥���� ����
 * changes[3] �� 500 ��¥���� ����
 * 
 * 0, 1, 2, 3, �� ���� ���ڸ� C10, C50, C100, C500 ���� �����ϱ� ���ؼ�
 * ����� ��������ϴ�.
 * 
 * �Ž������� setChange(int, int); �޼ҵ�� �����մϴ�.
 * 
 * ���� �� �Ž������� ������ ���� �����ȴٸ�
 *  
 *   10��¥�� 4��
 *   50��¥�� 1��
 *   500��¥�� 1��
 *   
 * �Ʒ��� ���� ȣ���� ���ݴϴ�.
 * 
 * change.setChange(Change.C10, 4); // 10��¥�� 4��
 * change.setChange(Change.C50, 1); // 50��¥�� 1��
 * change.setChange(Change.C500, 1);// 500��¥�� 1��
 * 
 * 1. getChangeAmount()
 * 
 * �׸��� getChangeAmount() �� ȣ���ϸ� �Ž������� ��ü �ݾ��� ��ȯ�մϴ�.
 * ��ó�� 3���� �޼ҵ带 ȣ�������� ��ü �Ž����� �ݾ��� 590���� ���;��մϴ�.
 * 
 * 2. getCoinCount()
 * 
 * getCointCount() �޼ҵ�� �Ž������� �����ϴ� ������ ������ ��ȯ�մϴ�.
 * ���� ���������� 10��¥�� 4��, 50��¥�� 1�� 500��¥�� 1���� �Ž���������
 * �����߱� ������ getCoinCount() �޼ҵ�� 6�� ��ȯ�ؾ� �մϴ�.
 * 
 * 3. getCointCount(int)
 * 
 * �� �޼ҵ�� getCoinCount �޼ҵ�� �̸��� ������ �Ķ���ͷ� int Ÿ���� ����
 * �ϳ� �޽��ϴ�. �־��� int ���� ������ 4���� �� �� �ϳ����� �մϴ�.
 * 
 *     Change.C10
 *     Change.C50
 *     Change.C100
 *     Change.C500
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
	
	public void setChange(int coinType , int counter) {
		changes[coinType] = counter ;
	}
	
	/**
	 * ���� �Ž������� �����ϴ� �������� ��ü �ݾ��� ����ؼ� ��ȯ���ݴϴ�.
	 * @return ��ü �Ž����� �ݾ�
	 */
	public int getChangeAmount() {
		int totalAmount = 0; // ��ü �Ž������� �����ϴ� ����
		
		/*
		 * Quiz-1 ��ü �Ž������� ��ȯ�ϴ� �ڵ带 �ϼ��ؾ���. 
		 */
		return totalAmount ;
	}
	
	/**
	 * �Ž������� �����ϴ� ������ ��ü ������ ��ȯ�մϴ�.
	 * 
	 * @return
	 */
	public int getCoinCount() {
		int coinCount = 0;
		
		/*
		 * Quiz-2 ��ü ������ ������ ��ȯ�ϴ� �޼ҵ� �ϼ��ؾ���.
		 */
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
