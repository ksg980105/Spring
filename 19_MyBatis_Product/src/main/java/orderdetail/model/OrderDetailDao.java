package orderdetail.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mall.cart.ShoppingInfo;

@Component("myOrderDetailDao")
public class OrderDetailDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	private String namespace = "orderdetail.OrderDetail";
	
	public void insertDetail(int oid, int pnum, Integer qty) {
		OrderDetailBean odb = new OrderDetailBean();
		odb.setOid(oid);
		odb.setPnum(pnum);
		odb.setQty(qty);
		sqlSessionTemplate.insert(namespace+".insertDetail", odb);
	}

	public List<ShoppingInfo> getMyOrderDetail(int oid) {
		return sqlSessionTemplate.selectList(namespace+".getMyOrderDetail", oid);
	}
	
	
}
