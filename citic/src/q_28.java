import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class q_28 {
    //按照funid查找相应的案例名称
    public static List<Event> query(int funid) throws SQLException {
        //查询sql
        String sql = "select event from tb_events where funid=?";
        List<Event> res = new ArrayList<>();

        try (Connection c = DBUtil.getConnection()) {
            try (PreparedStatement s = c.prepareStatement(sql)) {
                s.setInt(1, funid);

                try (ResultSet r = s.executeQuery()) {
                    while (r.next()) {
                        Event e = new Event(r.getString("event"));
                        res.add(e);
                    }
                }
            }
        }
        return res;
    }
}
