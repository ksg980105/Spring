package com.spring.ex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.spring.ex.dto.FDto;

public class FDao {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String dbid="sqlid";
	String dbpw="sqlpw";
	
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	private FDao () {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,dbid,dbpw);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static FDao instance = new FDao ();
	
	public static FDao getInstance() {
		return instance;
	}
	
	public int write(FDto fdto) {
		int cnt = -1;
		String sql = "insert into football values(fb_seq.nextval,?,?,?,?)";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, fdto.getId());
			ps.setString(2, fdto.getPw());
			ps.setString(3, fdto.getWin());
			ps.setString(4, fdto.getRound16());
			
			cnt = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null) {
					ps.close();
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return cnt;
	}
	
	public ArrayList<FDto> list() {
		ArrayList<FDto> lists = new ArrayList<FDto>();
		String sql = "select * from football order by num asc";
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				FDto dto = new FDto();
				dto.setNum(rs.getInt("num"));
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setWin(rs.getString("win"));
				dto.setRound16(rs.getString("round16"));
				
				lists.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null) {
					ps.close();
				}
				if(rs != null) {
					rs.close();
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lists;
	}
	
	public int delete(int num) {
		int cnt = -1;
		String sql = "delete from football where num=?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
			
			cnt = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null) {
					ps.close();
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cnt;
	}
	
	public FDto selectNum(FDto fdto) {
		FDto dto = null;
		String sql = "select * from football where num = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, fdto.getNum());
			rs = ps.executeQuery();
			if(rs.next()) {
				dto = new FDto();
				dto.setNum(fdto.getNum());
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setWin(rs.getString("win"));
				dto.setRound16(rs.getString("round16"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null) {
					ps.close();
				}
				if(rs != null) {
					rs.close();
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dto;
	}
	
	public int update(FDto fdto) {
		int cnt = -1;
		String sql = "update football set id=?, pw=?, win=?, round16=? where num=?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, fdto.getId());
			ps.setString(2, fdto.getPw());
			ps.setString(3, fdto.getWin());
			ps.setString(4, fdto.getRound16());
			ps.setInt(5, fdto.getNum());
			
			cnt = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null) {
					ps.close();
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cnt;
	}
}

























