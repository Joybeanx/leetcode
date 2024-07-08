package com.joybean.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/evaluate-division/">Evaluate Division</a>
 *
 * @author Joybean
 */
public class EvaluateDivision {
    /**
     * DFS
     *
     * @param equations
     * @param values
     * @param queries
     * @return
     */
    public static double[] calcEquation1(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<List<Object>>> equationMap = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            equationMap.putIfAbsent(equation.get(0), new ArrayList<>());
            equationMap.get(equation.get(0)).add(Arrays.asList(equation.get(1), values[i]));
            equationMap.putIfAbsent(equation.get(1), new ArrayList<>());
            equationMap.get(equation.get(1)).add(Arrays.asList(equation.get(0), 1 / values[i]));
        }

        double[] ans = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            ans[i] = calc(query.get(0), query.get(1), new HashSet<>(), equationMap);
        }
        return ans;
    }

    private double calc(String from, String to, Set<String> visited, Map<String, List<List<Object>>> equationMap) {
        if (visited.contains(from)) {
            return -1;
        }
        if (!equationMap.containsKey(from)) {
            return -1;
        }
        if (from.equals(to)) {
            return 1;
        }
        visited.add(from);
        for (List<Object> list : equationMap.get(from)) {
            double r = calc((String)list.get(0), to, visited, equationMap);
            if (r > 0) {
                return r * (Double)list.get(1);
            }
        }
        visited.remove(from);
        return -1;
    }

    /**
     *
     * <a href="https://leetcode.com/problems/evaluate-division/solutions/88169/java-ac-solution-using-graph/">DFS(by climberig)</a>
     * TODO s
     * @param equations
     * @param values
     * @param queries
     * @return
     */
    public static double[] calcEquation2(List<List<String>> equations, double[] values, List<List<String>> queries) {
        return null;
    }
}
