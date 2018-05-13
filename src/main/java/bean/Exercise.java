/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author ZDER
 */
//习题类
public class Exercise {

    //两数之和的上限
    int sum = 100;
    //习题数量
    int num = 50;
    //运算符类型
    int operatorType = 4;
    //运算符
    String operator;
    //单个习题对象
    Expression temp = new Expression();
    //判断习题是否符合
    Boolean flag = true;
    //随机数
    Random rand = new Random();
    //存放习题
    private List<Expression> list = new ArrayList<>();

    public List<Expression> getList() {

        //根据习题数量生成
        while (list.size() < num) {
            makeExpression();
        }
        return list;
    }

    public void setList(List<Expression> list) {
        this.list = list;
    }

    public List<Expression> getList(int t, int n) {

        num = n;
        operatorType = t;
        //根据习题数量生成
        while (list.size() < num) {
            makeExpression();
        }
        return list;
    }

    public void makeExpression() {
        //存放两个数,运算符和结果
        int a, b, c = 0;
        a = rand.nextInt(100);
        b = rand.nextInt(100);
        //根据运算符类型生成运算符
        switch (operatorType) {
            case 1:
                c = 0;
                break;
            case 2:
                c = 1;
                break;
            case 3:
                c = rand.nextInt(2);
                break;
            case 4:
                c = rand.nextInt(4);
                break;

        }

        //检查表达式
        checkExpression(a, b, c);
    }

    public boolean checkExpression(int a, int b, int c) {
        //存放结果
        int value = 0;
        //判断是否符合条件
        if ((a + b) < sum & a != 0 & b != 0) {
            //生成运算符
            switch (c) {
                case 0:
                    operator = "+";
                    value = a + b;
                    break;
                case 1:
                    operator = "-";
                    if (a - b < 0) {
                        //不符合条件则重新生成
                        makeExpression();
                        return false;
                    } else {
                        value = a - b;
                    }
                    break;
                case 2:
                    operator = "*";
                    value = a * b;
                    break;
                case 3:
                    operator = "/";
                    value = a / b;
                    break;
            }
            //生成单个习题
            temp = new Expression(operator, a, b, value);
            //尝试添加到List
            addToList(temp);
        } else {
            //不符合条件则重新生成
            makeExpression();
            return false;
        }
        return false;
    }

    //将表达式添加进list
    public boolean addToList(Expression temp) {
        //检查List是否已满
        if (list.size() < num) {
            //检查是否与已有算式重复
            for (int j = 0; j < list.size(); j++) {
                Expression get = list.get(j);
                //判断是否重复
                if (get.getInta() == temp.getInta() && get.getIntb() == temp.getIntb() && get.getOperator().endsWith(temp.getOperator())) {
                    makeExpression();
                    return false;
                }
            }
            //符合条件,添加到list
            list.add(temp);
            return true;
        }
        return false;
    }

}
