package order.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("myOrderDao")
public class OrderDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	private String namespace = "order.Order";
	

	public void insertOrder(String id) {
		int cnt = sqlSessionTemplate.insert(namespace+".insertOrder", id);
	}

	public int getMax() {
		int oid = sqlSessionTemplate.selectOne(namespace+".getMax");
		return oid;
	}

	public List<OrderBean> getMyOrder(String id) {
		return sqlSessionTemplate.selectList(namespace+".getMyOrder", id);
	}
}
