package 员工的重要性;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/8/4 23:22
 */

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
}

public class Solution {
    public int getImportance(List<Employee> employees, int id) {
        if (employees.size() == 0) return 0;
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e: employees) {
            map.put(e.id, e);
        }
        return dfs(map, id);
    }

    public static int dfs(Map<Integer, Employee> map, Integer id) {
        Employee curE = map.get(id);
        int curSum = curE.importance;
        for (Integer curId : curE.subordinates) {
            curSum += dfs(map, curId);
        }
        return curSum;
    }
}
