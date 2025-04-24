
package sql;


import java.sql.Connection;
import java.sql.SQLException;

public class TextConnection {
    public static void main(String[] args) throws SQLException {
        Connection conn = DatabaseQLKS.getConnection();
        if (conn != null) {
            try {
                System.out.println("Ket noi thanh cong den database: " + conn.getCatalog());
                conn.close(); // Đóng kết nối sau khi kiểm tra
            } catch (SQLException e) {
            }
        } else {
            System.out.println("Kết nối thất bại!");
        }
    }
}
