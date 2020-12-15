import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class q_29 {
    //返回系统名称和业务工单信息
    public static List<TypeAndSystem> query() throws SQLException {
        //查询sql
        String sql = "select DISTINCT type, system from order";
        List<TypeAndSystem> res = new ArrayList<>();

        try (Connection c = DBUtil.getConnection()) {
            try (PreparedStatement s = c.prepareStatement(sql)) {
                try (ResultSet r = s.executeQuery()) {
                    while (r.next()) {
                        TypeAndSystem typeAndSystem = new TypeAndSystem(r.getString("type"),
                                                                        r.getString("system"));
                        res.add(typeAndSystem);
                    }
                }
            }
        }
        return res;
    }
}
