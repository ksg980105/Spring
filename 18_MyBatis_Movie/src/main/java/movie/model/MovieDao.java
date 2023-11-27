package movie.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import utility.Paging;

@Component("myMovieDao")
public class MovieDao {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public MovieDao() {
		
	}
	
	public List<MovieBean> getAllMovie(Map<String,String> map, Paging pageInfo) {
		
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(),pageInfo.getLimit());
		
		List<MovieBean> lists = new ArrayList<MovieBean>();
		lists = sqlSessionTemplate.selectList("movie.MovieBean.getAllMovie", map, rowBounds);
		
		return lists;
	}
	
	public int getTotalCount(Map<String,String> map) {
		int cnt = sqlSessionTemplate.selectOne("movie.MovieBean.getTotalCount",map);
		
		return cnt;
	}
	
	public void insertMovie(MovieBean movieBean) {
		sqlSessionTemplate.insert("movie.MovieBean.insertMovie",movieBean);
	}

	public int findTitle(String inputtitle) {
		int cnt = sqlSessionTemplate.selectOne("movie.MovieBean.findTitle",inputtitle);
		
		return cnt;
	}
	
	public MovieBean getDetail(int num) {
		MovieBean movieBean = sqlSessionTemplate.selectOne("movie.MovieBean.getDetail",num);
		
		return movieBean;
	}
	
	public int updateMovie(MovieBean movieBean) {
		int cnt = sqlSessionTemplate.update("movie.MovieBean.updateMovie",movieBean);
		return cnt;
	}

	public void deleteMovie(int num) {
		sqlSessionTemplate.delete("movie.MovieBean.deleteMovie",num);
	}
}
