package dto;

import static utils.ConnectionUtil.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.OrderDao;
import vo.Member;
import vo.Order;
import vo.OrderItem;

public class OrderDetailDto {
	
	public OrderDetailDto() {}
	
	public List<OrderItem> selectAllOrderItemsByNo(int memberNo) {
		List<OrderItem> orderItems = new ArrayList<>();
		
		
		
		return orderItems;
	}
	
	/**
	 * 지정된 멤버번호로 주문상태에 따라 주문 개수를 반환한다.
	 * @param memberNo
	 * @return
	 * @throws SQLException
	 */
	/**
	    * 지정된 멤버번호로 주문상태에 따라 주문 개수를 반환한다.
	    * @param memberNo
	    * @return
	    * @throws SQLException
	    */
	   public int selectOrderCount(int memberNo, String orderStatus) throws SQLException {
	      int count = 0;
	      
	      String sql = "select count(*) cnt "
	               + "from tb_orders "
	               + "where order_status = ? "
	               + "and member_no = ? ";
	      
	      Connection connection = getConnection();
	      PreparedStatement pstmt = connection.prepareStatement(sql);
	      pstmt.setString(1, orderStatus);
	      pstmt.setInt(2, memberNo);
	      ResultSet rs = pstmt.executeQuery();
	      
	      rs.next();
	      count = rs.getInt("cnt");
	      
	      rs.close();
	      pstmt.close();
	      connection.close();
	      
	      return count;
	   }
	
	/**
	 * 주문번호로 지정한 주문상세정보를 반환한다.
	 * @param orderNo
	 * @return
	 * @throws SQLException 
	 */
	public Order selectOrderDetailByOrderNo(int orderNo) throws SQLException {
		
		String sql = "select o.order_no, o.order_status, "
				+ "o.order_date, o.order_total_price, o.cancel_reason, "
				+ "o.cancel_status, o.canceled_date, o.review_status, "
				+ "m.member_no, m.member_id, m.member_pwd, m.member_name, "
				+ "m.member_tel, m.member_email, "
				+ "m.member_address, m.member_pct, m.member_registered_date, "
				+ "m.member_deleted, m.member_deleted_date "
				   + "from tb_orders o, tb_members m "
				   + "where o.member_no = m.member_no "
				   + "and o.order_no = ? ";
		
		Order order = null;
		
		Connection connection = getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, orderNo);
		ResultSet rs = pstmt.executeQuery();
		
		if (rs.next()) {
			order = new Order();
			Member member = new Member();
			
			member.setNo(rs.getInt("member_no"));
			member.setId(rs.getString("member_id"));
			member.setPwd(rs.getString("member_pwd"));
			member.setName(rs.getString("member_name"));
			member.setTel(rs.getString("member_tel"));
			member.setEmail(rs.getString("member_email"));
			member.setAddress(rs.getString("member_address"));
			member.setPct(rs.getInt("member_pct"));
			member.setRegisteredDate(rs.getDate("member_registered_date"));
			member.setDeleted(rs.getString("member_deleted"));
			member.setDeletedDate(rs.getDate("member_deleted_date"));
			order.setMember(member);
			
			order.setNo(rs.getInt("order_no"));
			order.setStatus(rs.getString("order_status"));
			order.setOrderDate(rs.getDate("order_date"));
			order.setTotalPrice(rs.getInt("order_total_price"));
			order.setCancelReason(rs.getString("cancel_reason"));
			order.setCancelStatus(rs.getString("cancel_status"));
			order.setCanceledDate(rs.getDate("canceled_date"));
			order.setReviewStatus(rs.getString("review_status"));
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return order;
	}
	
	
	/**
	 * 멤버번호로 지정한 전체 주문내역을 반환한다.
	 * @param memberNo
	 * @return
	 * @throws SQLException
	 */
	public List<Order> selectAllOrdersByMemberNo(int memberNo) throws SQLException {
		String sql = "select o.order_no, o.order_status, "
				+ "o.order_date, o.order_total_price, o.cancel_reason,"
				+ "o.cancel_status, o.canceled_date, o.review_status, "
				+ "m.member_no, m.member_id, m.member_pwd, m.member_name, "
				+ "m.member_tel, m.member_email, "
				+ "m.member_address, m.member_pct, m.member_registered_date, "
				+ "m.member_deleted, m.member_deleted_date "
				+ "from tb_orders o, tb_members m "
				+ "where o.member_no = m.member_no "
				+ "and m.member_no = ? ";
		
		List<Order> orders = new ArrayList<>();
		
		Connection connection = getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, memberNo);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			Order order = new Order();
			Member member = new Member();
			
			member.setNo(rs.getInt("member_no"));
			member.setId(rs.getString("member_id"));
			member.setPwd(rs.getString("member_pwd"));
			member.setName(rs.getString("member_name"));
			member.setTel(rs.getString("member_tel"));
			member.setEmail(rs.getString("member_email"));
			member.setAddress(rs.getString("member_address"));
			member.setPct(rs.getInt("member_pct"));
			member.setRegisteredDate(rs.getDate("member_registered_date"));
			member.setDeleted(rs.getString("member_deleted"));
			member.setDeletedDate(rs.getDate("member_deleted_date"));
			
			order.setMember(member);
			order.setNo(rs.getInt("order_no"));
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
	
	
}
