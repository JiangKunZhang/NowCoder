import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class q_30 {
    //返回工单信息或者生产事件信息或者空
    public static Object query(int id) throws SQLException {
        //查询sql
        String sql = "select order.info, product.info from order, product where order.id=? and product.id=?";

        try (Connection c = DBUtil.getConnection()) {
            try (PreparedStatement s = c.prepareStatement(sql)) {
                s.setInt(1, id);
                s.setInt(2, id);

                try (ResultSet r = s.executeQuery()) {
                    if (r.getString("order.info") != null) {
                        //工单信息不为空
                        return new Order(r.getString("order.info"));
                    } else if (r.getString("product.info") != null) {
                        //生产事件信息不为空
                        return new Order(r.getString("product.info"));
                    } else {
                        //都为空
                        return null;
                    }
                }
            }
        }
    }
}
