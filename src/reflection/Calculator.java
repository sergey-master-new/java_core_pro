package reflection;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Calculator {

    void sum(int a, int b) {
        int result = a + b;
        System.out.println("Сумма а=" + a + " и b=" + b + " равна =" + result);
    }

    void substruction(int a, int b) {
        int result = a - b;
        System.out.println("Разница а=" + a + " и b=" + b + " равна =" + result);
    }

    void multiplication(int a, int b) {
        int result = a * b;
        System.out.println("Произведение а=" + a + " и b=" + b + " равна =" + result);
    }

    void devision(int a, int b) {
        double result = a / b;
        System.out.println("Произведение а=" + a + " и b=" + b + " равна =" + result);
    }
}

class TestCalculator {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new FileReader("test100.txt"))) {

            String methodName = reader.readLine();
            String firstArgument = reader.readLine();
            String secondArgument = reader.readLine();

            Calculator calculator = new Calculator();
            Class cl = calculator.getClass();
            Method method = null;

            Method[] methods = cl.getDeclaredMethods();
            for (Method myMethod: methods) {
                if (myMethod.getName().equals(methodName)){
                    method = myMethod;
                }
            }

            method.invoke(calculator, Integer.parseInt(firstArgument), Integer.parseInt(secondArgument));

        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
