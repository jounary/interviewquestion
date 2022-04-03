package solution;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    private static  Solution instance = new Solution();
    private Solution(){}
    private int i = 0;
    public static Solution getInstance(){
        return instance;
    }
    public int findLUSlength(String a, String b) {
        /*if(a.contains(b) || b.contains(a)){
            return -1;
        }
        return 0;*/
        return ++i;
    }

    public static void main(String[] args) {
        Solution solution =Solution.getInstance();
/*        System.out.println(solution.findLUSlength("aabbb","aabb"));
        System.out.println(solution.findLUSlength("aabbb","aabb"));*/

        //leetCode 2100
        /*int[] security = new int[]{5,3,3,3,5,6,2};
        System.out.println(solution.goodDaysToRobBank(security,2));*/

        //leetCode 504
        //System.out.println(solution.convertToBase7(-898));

        //leetCode 20
        //System.out.println(solution.isVaild("([)]"));

        //leetCode 70
        System.out.println(solution.climbStairs(10));
    }

    //leetCode 2100
    public List<Integer> goodDaysToRobBank(int[] security, int time){
        List<Integer> ansList = new ArrayList<>();
        if(security.length <= 2*time){
            return ansList;
        }

        for(int i = time; i<security.length - time-1; i++){
            if(!isVaild(security,time,i)) ansList.add(i);
        }
        return ansList;
    }
    public boolean isVaild(int[] security, int time, int i){
        for(int j = i; j > i-time; j--){
            int n = j-1;
            if(security[j] <= security[n]){
                return false;
            }
        }
        for(int j = i; j < i+time; j++){
            int n = j+1;
            if(security[j] <= security[n]){
                return false;
            }
        }
        return true;
    }

    //leetCode 504
    public String convertToBase7(int num){
        StringBuffer ans = new StringBuffer();
        if(num == 0){
            return "0";
        }
        boolean negative = num < 0;
        num = Math.abs(num);
        while(num > 0){
            ans.append(num % 7);
            num /= 7;
        }
        if(negative){
            ans.append("-");
        }
        return ans.reverse().toString();
    }

    //leetCode 20
    public boolean isVaild(String s){
        Deque<Character> dq = new LinkedList<>();
        if(s.length() == 0){
            return true;
        }

        dq.add(s.charAt(0));
        for(int i = 1; i < s.length(); i++){
            if(dq.size() > 0 && ((dq.peekLast() == '(' && s.charAt(i) == ')') || (dq.peekLast() == '{' && s.charAt(i) == '}') ||(dq.peekLast() == '[' && s.charAt(i) == ']'))){
                dq.removeLast();
            } else
                dq.add(s.charAt(i));
        }
        if(dq.size() > 0){
            return false;
        }
        return true;
    }

    //leetCode 70
    public int climbStairs(int n){
        int[] dp = new int[n+1];
        dp[0] = 0;dp[1] = 1;dp[2] = 2;
        for(int i = 3; i <= n; i++){
            dp[i] = dp[i-2] + dp[i-1];
        }
        return dp[n];
    }
}