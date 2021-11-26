package app;

import static utils.ConnectionUtil.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class App {

	App() {};
	
	public void insertstocks(int no, int size) throws SQLException {
		String sql = "insert into tb_product_stocks "
				+ "(product_detail_no, product_no, product_size, product_stock ) "
				+ "values(PRODUCT_DETAIL_NO.nextval, ?, ?, 20) ";
		Connection connection = getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, no);
		pstmt.setInt(2, size);
		
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
	}
	
	
	public static void main(String[] args) throws SQLException {
	
		App app = new App();
		for (int i = 1; i <= 40; i++) {
			for (int j = 230; j <= 290; j+=10) {
				app.insertstocks(i, j);
			}
		}
	}
}

