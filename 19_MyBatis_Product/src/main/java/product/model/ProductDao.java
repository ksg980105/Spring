package product.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import utility.Paging;

@Component("myProductDao")
public class ProductDao {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	private String namespace = "product.ProductBean";
	
	public ProductDao() {
		
	}

	public List<ProductBean> getAllProduct(Map<String,String> map, Paging pageInfo) {
		
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(),pageInfo.getLimit());
		
		List<ProductBean> lists = new ArrayList<ProductBean>();
		lists = sqlSessionTemplate.selectList("product.ProductBean.getAllProduct", map, rowBounds);
		return lists;
	}

	public int getTotalCount(Map<String,String> map) {
		int cnt = sqlSessionTemplate.selectOne("product.ProductBean.getTotalCount",map);
		return cnt;
	}

	public void insertProduct(ProductBean productBean) {
		sqlSessionTemplate.insert("product.ProductBean.insertProduct",productBean);
	}

	public ProductBean getProductByNum(int num) {
		ProductBean productBean = sqlSessionTemplate.selectOne("product.ProductBean.getProductByNum",num);
		return productBean;
	}

	public void updateStock(int pnum, int pqty) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("pnum", pnum);
		map.put("pqty", pqty); 
		// ProductBean pb = new ProductBean();
		// pb.setNum(pnum);
		// pb.setStock(pqty); 넘어가서는 #{num}과 #{stock} 사용
		int cnt = sqlSessionTemplate.update(namespace+".updateStock", map); 
		System.out.println("updateStock cnt:"+cnt);
	}

	public void updateProduct(ProductBean pb) {
		int cnt = sqlSessionTemplate.update(namespace+".updateProduct", pb);
		System.out.println("updateProduct cnt:"+cnt);
	}

	public void deleteProduct(int num) {
		sqlSessionTemplate.delete(namespace+".deleteProduct", num);
	}
}
