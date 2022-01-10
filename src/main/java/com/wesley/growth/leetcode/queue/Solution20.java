package com.wesley.growth.leetcode.queue;


import java.util.*;

/**
 * Solution20
 *
 * @author WangPanYong
 * @since 2021/12/09 13:59
 */
public class Solution20 {

    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     */
    public boolean isValid(String s) {
        Deque<Character> stack =  new LinkedList<>();
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch  = s.charAt(i);

            // 碰到左括号，就把相应的右括号入栈
            if (ch == '(') {
                stack.push(')');
            }
            else if (ch == '{') {
                stack.push('}');
            }
            else if (ch == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.peek() != ch) {
                return false;
            } else {
                stack.pop();
            }
        }

        // 栈是空则全部匹配
        return stack.isEmpty();
    }

    static class CalItem {
        Integer val;
        Integer operator;

        public CalItem(Integer val, Integer operator) {
            this.val = val;
            this.operator = operator;
        }
    }

    public static void main(String[] args) {
//        boolean res = new Solution20().isValid("]");
        List<Object> items = new ArrayList<>();
        items.add("5");
        items.add(1);
        items.add("5");
//        items.add(1);
//        items.add("10");
//        items.add(2);
//        items.add("2");
        Integer res = new Solution20().calculate(items);
        System.out.println(res);
    }

    /**
     *
     */
    public Integer calculate(List<Object> items) {
        // 数值
        Deque<Integer> valuesDeque = new LinkedList<>();
        // 运算符 1:加法 2:乘法
        Deque<Integer> operatorDeque = new LinkedList<>();

        for (Object item : items) {
            if (item instanceof String) {
                valuesDeque.push(Integer.parseInt((String)item));
            }
            else if(item instanceof Integer){
                Integer pop = operatorDeque.peek();
                if (Objects.isNull(pop)) {
                    operatorDeque.push((Integer)item);
                    continue;
                }

                Integer op = (Integer) item;
                if (op <= pop) {
                    Integer oper = operatorDeque.pop();
                    Integer value1 = valuesDeque.pop();
                    Integer value2 = valuesDeque.pop();
                    if (oper.equals(1)) {
                        valuesDeque.push(value1+value2);
                    } else if(oper.equals(2)){
                        valuesDeque.push(value1*value2);
                    }
                    else {
                        throw new UnsupportedOperationException();
                    }

                }
                operatorDeque.push(op);
            }
        }

        int size = operatorDeque.size();
        while (size > 0) {
            if (Objects.isNull(operatorDeque.peek())) {
                break;
            }

            Integer pop = operatorDeque.pop();
            Integer value1 = valuesDeque.pop();
            Integer value2 = valuesDeque.pop();
            if (pop.equals(1)) {
                valuesDeque.push(value1+value2);
            } else if(pop.equals(2)){
                valuesDeque.push(value1*value2);
            }
            else {
                throw new UnsupportedOperationException();
            }
            size -- ;
        }
        return valuesDeque.pop();
    }
}
