package dao;

import static utils.ConnectionUtil.getConnection;

import java.util.*;
import java.sql.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.Member;
import vo.Order;

public class OrderDao {
	
	private static OrderDao self = new OrderDao();
	private OrderDao() {}
	public static OrderDao getInstance() {
		return self;
	}

	/**
	 * 전체 주문내역을 반환한다. (관리자용)
	 * @return
	 * @throws SQLException
	 */
	public List<Order> selectAllOrders() throws SQLException {
		String sql = "select o.order_no, o.order_status, "
				+ "o.order_date, o.order_total_price, o.cancel_reason, "
				+ "o.cancel_status, o.canceled_date, o.review_status, "
				+ "m.member_no, m.member_id, m.member_pwd, m.member_name, "
				+ "m.member_tel, m.member_email, "
				+ "m.member_address, m.member_pct, m.member_registered_date, "
				+ "m.member_deleted, m.member_deleted_date "
				   + "from tb_orders o, tb_members m "
				   + "where o.member_no = m.member_no ";
		
		List<Order> orders = new ArrayList<>();
		
		Connection connection = getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			Order order = new Order();
			Member member = new Member();
			
			order.setNo(rs.getInt("order_no"));
			member.setNo(rs.getInt("member_no"));
			order.setMember(member);
			order.setStatus(rs.getString("order_status"));
			order.setOrderDate(rs.getDate("order_date"));
			order.setTotalPrice(rs.getInt("order_total_price"));
			order.setCancelReason(rs.getString("cancel_reason"));
			order.setCancelStatus(rs.getString("cancel_status"));
			order.setCanceledDate(rs.getDate("canceled_date"));
			order.setReviewStatus(rs.getString("review_status"));
			
			orders.add(order);
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		return orders;
	}
	
	/**
	 * 수정된 정보가 포함된 주문 정보를 테이블에 반영한다.
	 * @param order
	 * @throws SQLException
	 */
	public void updateOrder(Order order) throws SQLException {
		String sql = "update tb_orders "
				   + "set "
				   + "	order_status = ?, "
				   + "	order_total_price = ?,"
				   + "	cancel_reason = ?, "
				   + "	cancel_status = ?, "
				   + "	review_status = ?, "
				   + "	canceled_date = ? "
				   + "where order_no = ? ";
		
		Connection connection = getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, order.getStatus());
		pstmt.setInt(2, order.getTotalPrice());
		pstmt.setString(3, order.getCancelReason());
		pstmt.setString(4, order.getCancelStatus());
		pstmt.setString(5, order.getReviewStatus());
		pstmt.setDate(6, new java.sql.Date(order.getCanceledDate().getTime()));
		pstmt.setInt(7, order.getNo());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
	}
	
	/**
	 * 새 주문번호를 반환한다.
	 * @return
	 * @throws SQLException
	 */
	public int getOrderNo() throws SQLException {
		String sql = "select order_no_seq.nextval seq from dual";
		
		int orderNo = 0;
		Connection connection = getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		rs.next();
		
		orderNo = rs.getInt("seq");
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return orderNo;
	}
	
	/**
	 * 신규 주문 정보를 저장한다.
	 * @param order
	 * @throws SQLException
	 */
	public void insertOrder(Order order) throws SQLException {
		
		String sql = "insert into tb_orders "
				   + "(order_no, member_no, order_total_price) "
				   + "values (?, ?, ?) ";
		
		Connection connection = getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		
		pstmt.setInt(1, order.getNo());
		pstmt.setInt(2, order.getMember().getNo());
		pstmt.setInt(3, order.getTotalPrice());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
	}
}
