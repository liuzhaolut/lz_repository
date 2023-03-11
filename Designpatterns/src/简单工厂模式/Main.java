package 简单工厂模式;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        OperationFactory operationFactory=new OperationFactory();
        System.out.println("请输入数字A：");
        Scanner scanner=new Scanner(System.in);
        double number1=scanner.nextDouble();
        System.out.println("请输入数字B：");
        Scanner scanner2=new Scanner(System.in);
        double number2=scanner2.nextDouble();
        System.out.println("请输入运算符：");
        Scanner scanner3=new Scanner(System.in);
        String operators=scanner3.nextLine();
        Operation op=operationFactory.opertation(operators);
        op.setNumberA(number1);
        op.setNumberB(number2);
        double result = op.getResult();
        System.out.println(result);
    }
}
