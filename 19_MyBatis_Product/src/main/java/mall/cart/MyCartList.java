package mall.cart;

import java.util.HashMap;
import java.util.Map;

public class MyCartList { // ��ٱ���(��ǰ��ȣ, �ֹ�����)
	private Map<Integer, Integer> orderlists = null;
	
	public MyCartList() {
		orderlists = new HashMap<Integer, Integer>();
	}
	
	public void addOrder(int pnum, int oqty) { // ��ǰ��ȣ, �ֹ�����
		if(!orderlists.containsKey(pnum)) { // ������ ������ ���� �ֱ�
			orderlists.put(pnum, oqty);
		} else { // ������ ������ �����ϱ�
			orderlists.put(pnum, orderlists.get(pnum)+oqty);
		}
		for ( int x : orderlists.keySet() ) {
		    System.out.println("pnum:"+x + "oqty:"+orderlists.get(x));
		}
	}
	
	public Map<Integer, Integer> getAllOrderList() {
		return orderlists;
	}
}

// 3���� �÷���: List, Set, Map => �߿��ϴ� �� �����صα�