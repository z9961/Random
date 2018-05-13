/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 * @author ZDER
 */
//算式类
public class Expression {

    private String operator;
    private int inta;
    private int intb;
    private int value;
    private int result;
    private boolean istrue;

    public Expression(String operator, int inta, int intb, int value, int result, boolean istrue) {
        this.operator = operator;
        this.inta = inta;
        this.intb = intb;
        this.value = value;
        this.result = result;
        this.istrue = istrue;
    }

    public Expression(String operator, int inta, int intb, int value) {
        this.operator = operator;
        this.inta = inta;
        this.intb = intb;
        this.value = value;
    }

    public Expression(int inta, int intb, String operator) {
        this.operator = operator;
        this.inta = inta;
        this.intb = intb;
    }

    public Expression() {
    }

    public boolean isIstrue() {
        return istrue;
    }

    public void setIstrue(boolean istrue) {
        this.istrue = istrue;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Expression{" +
                "operator='" + operator + '\'' +
                ", inta=" + inta +
                ", intb=" + intb +
                ", value=" + value +
                ", result=" + result +
                ", istrue=" + istrue +
                '}';
    }

    public int getIntb() {
        return intb;
    }

    public void setIntb(int intb) {
        this.intb = intb;
    }

    public int getInta() {
        return inta;
    }

    public void setInta(int inta) {
        this.inta = inta;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
