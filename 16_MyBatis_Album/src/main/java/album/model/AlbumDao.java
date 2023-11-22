package album.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import utility.Paging;

@Component("myAlbumDao")
public class AlbumDao {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public AlbumDao() {

	}
	public List<AlbumBean> getAlbumList(Paging pageInfo,Map<String,String> map) {
		System.out.println("getAlbumList");
		
		System.out.println("pageInfo.getOffset():"+pageInfo.getOffset()); //몇개를 건너뛸지
		System.out.println("pageInfo.getLimit():"+pageInfo.getLimit()); //몇개 가져올지
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(),pageInfo.getLimit());
		
		List<AlbumBean> lists = new ArrayList<AlbumBean>();
		lists = sqlSessionTemplate.selectList("album.AlbumBean.getAlbumList", map,rowBounds);
		System.out.println("lists.size():" + lists.size());
		return lists;
	}
	
	public int insertAlbum(AlbumBean album) {
		System.out.println("insertAlbum");
		int cnt = sqlSessionTemplate.insert("album.AlbumBean.insertAlbum",album);
		System.out.println("Dao insertAlbum cnt:" + cnt);
		
		return cnt;
	}
	
	public AlbumBean getAlbum(int num) {
		AlbumBean album = sqlSessionTemplate.selectOne("album.AlbumBean.getAlbum",num);
		return album;
	}
	
	public int deleteAlbum(int num) {
		int cnt = sqlSessionTemplate.delete("album.AlbumBean.deleteAlbum",num);
		
		return cnt;
	}
	
	public int updateAlbum(AlbumBean album) {
		int cnt = sqlSessionTemplate.update("album.AlbumBean.updateAlbum", album);
		
		return cnt;
	}
	public int getTotalCount(Map<String, String> map) {
		int cnt = sqlSessionTemplate.selectOne("album.AlbumBean.getTotalCount", map);
		return cnt;
	}
}
