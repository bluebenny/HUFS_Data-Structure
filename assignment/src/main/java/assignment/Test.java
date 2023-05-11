package assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class Test {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String str = r.readLine();
        Calculator calc = new Calculator();
        String exp = calc.postfix(str);
        System.out.println(exp);
        double result = calc.evalPostfix(exp);
        System.out.println(result);

    }
}

class Calculator {
    static final Map<String, Integer> PIS;
    static final Map<String, Integer> PIE;
    static {
        PIS = new HashMap<String, Integer>();
        PIS.put("^", 3);
        PIS.put("*", 2);
        PIS.put("/", 2);
        PIS.put("+", 1);
        PIS.put("-", 1);
        PIS.put("(", 0);
        PIE = new HashMap<String, Integer>();
        PIE.put("^", 3);
        PIE.put("*", 2);
        PIE.put("/", 2);
        PIE.put("+", 1);
        PIE.put("-", 1);
        PIE.put("(", 4);
    }

    public double evalPostfix(String exp) {
        StringTokenizer tokenizer = new StringTokenizer(exp, "[({})]+-*/ ", true);
        Stack<String> stack = new Stack<String>();
        while (tokenizer.hasMoreElements()) {
            String token = tokenizer.nextToken();
            switch (token) {
                case "+": {
                    double p2 = Double.parseDouble(stack.pop());
                    double p1 = Double.parseDouble(stack.pop());
                    stack.push(String.valueOf(p1 + p2));
                    break;
                }
                case "-": {
                    double p2 = Double.parseDouble(stack.pop());
                    double p1 = Double.parseDouble(stack.pop());
                    stack.push(String.valueOf(p1 - p2));
                    break;
                }
                case "*": {
                    double p2 = Double.parseDouble(stack.pop());
                    double p1 = Double.parseDouble(stack.pop());
                    stack.push(String.valueOf(p1 * p2));
                    break;
                }
                case "/": {
                    double p1 = Double.parseDouble(stack.pop());
                    double p2 = Double.parseDouble(stack.pop());
                    stack.push(String.valueOf(p1 / p2));
                    break;
                }
                case " ":
                    break;
                default:
                    stack.push(token);
                    break;
            }
        }
        return Double.parseDouble(stack.pop());
    }

    public String postfix(String exp) {
        StringTokenizer tokenizer = new StringTokenizer(exp, "[({})]+-*/ ", true);
        Stack<String> stack = new Stack<String>();
        StringBuffer str = new StringBuffer();
        while (tokenizer.hasMoreElements()) {
            String token = tokenizer.nextToken();
            switch (token) {
                case ")": {
                    while (!stack.empty() && !stack.peek().equals("("))
                        str.append(stack.pop()).append(" ");
                    stack.pop();
                    break;
                }
                case "(":
                case "+":
                case "-":
                case "*":
                case "/":
                case "^": {
                    while (!stack.empty() && PIS.get(stack.peek()) >= PIE.get(token))
                        str.append(stack.pop()).append(" ");
                    stack.push(token);
                    break;
                }
                case " ":
                    break;
                default:
                    str.append(token).append(" ");
                    break;
            }
        }
        while (!stack.empty())
            str.append(stack.pop()).append(" ");
        return str.toString();
    }

    
}
