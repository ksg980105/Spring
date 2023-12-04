package member.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.UncategorizedSQLException;
import org.springframework.stereotype.Component;

import utility.Paging;

@Component("myMemberDao")
public class MemberDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	private String namespace = "member.MemberBean";

	public int getTotalCount(Map<String, String> map) {
		int totalCount = sqlSessionTemplate.selectOne(namespace + ".getTotalCount", map);
		return totalCount;
	}

	public List<MemberBean> getAllMember(Map<String, String> map, Paging pageInfo) {
		RowBounds rBounds = new RowBounds(pageInfo.getOffset(), pageInfo.getLimit());
		List<MemberBean> memberLists = sqlSessionTemplate.selectList(namespace + ".getAllMember", map, rBounds);
		return memberLists;
	}

	public int insertMember(MemberBean memberBean) {
		int cnt = -1;
		try {
			cnt = sqlSessionTemplate.insert(namespace + ".insertMember", memberBean);
		} catch (DuplicateKeyException e) {
			e.printStackTrace();
			cnt = -1;
		} catch (UncategorizedSQLException e) {
			e.printStackTrace();
			cnt = -2;
		}
		System.out.println("insertMember cnt:" + cnt);
		return cnt;
	}

	public MemberBean getMemberById(String id) {
		return sqlSessionTemplate.selectOne(namespace + ".getMemberById", id);
	}

	public void deleteMember(String id) {
		sqlSessionTemplate.delete(namespace + ".deleteMember", id);
	}

	public int updateMember(MemberBean memberBean) {
		int cnt = -1;
		try {
			cnt = sqlSessionTemplate.update(namespace + ".updateMember", memberBean);
		} catch (UncategorizedSQLException e) {
			e.printStackTrace();
			cnt = -1;
		}
		return cnt;
	}

	public void updateMpoint(String id, int mpoint) {
		MemberBean mb = new MemberBean();
		mb.setId(id);
		mb.setMpoint(mpoint);
		sqlSessionTemplate.update(namespace+".updateMpoint", mb);
	}

}
