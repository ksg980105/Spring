package travel.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import utility.Paging;

@Component("myTravelDao")
public class TravelDao {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public TravelDao() {
		
	}
	
	private String namespace = "travel.TravelBean";
	
	public List<TravelBean> getAllTravel(Map<String,String> map, Paging pageInfo) {
		
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(),pageInfo.getLimit());
		
		List<TravelBean> lists = new ArrayList<TravelBean>();
		lists = sqlSessionTemplate.selectList(namespace+".getAllTravel",map,rowBounds);
		
		return lists;
	}
	
	public void insertTravel(TravelBean travelBean) {
		sqlSessionTemplate.insert(namespace+".insertTravel",travelBean);
	}
	
	public int getTotalCount(Map<String,String> map) {
		int count = sqlSessionTemplate.selectOne(namespace+".getTotalCount",map);
		return count;
	}
	
	public TravelBean getTravel(int num) {
		TravelBean travelBean = sqlSessionTemplate.selectOne(namespace+".getTravel",num);
		return travelBean;
	}
	
	public void deleteTravel(int num) {
		sqlSessionTemplate.delete(namespace+".deleteTravel",num);
	}
	
	public void updateTravel(TravelBean travelBean) {
		sqlSessionTemplate.update(namespace+".updateTravel", travelBean);
	}
}
