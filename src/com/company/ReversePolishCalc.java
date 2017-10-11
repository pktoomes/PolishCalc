package com.company;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class ReversePolishCalc {

    Deque<String> stack = new ArrayDeque<>();
    Deque<String> tokens = new ArrayDeque<>();
    Deque<String> operators = new ArrayDeque<>();


    public double calculate(String input) {

        // 1. Use the String split method to split the string into tokens at the commas
        for (String character : input.split(",")) {
            tokens.add(character);
        }
        // 2. Allocate a stack as big as the number of tokens

        // 3. write the algorithm
        for (String token : tokens) {
            // calls to push() and pop() and do the math here
            if (isOperator(token)) {
                operators.push(tokens.pop());
                String newNum1 = stack.pop();
                String newNum2 = stack.pop();
                stack.push(token, newNum1, newNum2));
            } else {
                stack.push(tokens.pop());
            }
        }
    }



    public boolean isOperator(String input) {
        String[] operators = {"+", "-", "*", "/"};
        for (String operator : operators) {
            if (input.equals(operator)) {
                return true;
            }
        }
        return false;
        //equations
    }

    public Double addNum(String input1, String input2) {
        return Double.parseDouble(input1) + Double.parseDouble(input2);
    }
    public Double subNum(String input1, String input2) {
            return Double.parseDouble(input1) - Double.parseDouble(input2);
        }
    public Double multNum(String input1, String input2) {
        return Double.parseDouble(input1) * Double.parseDouble(input2);
    }

    }


