package junitpaquete;
public class Cal {
    public Cal() {
    }
    public int add(int a,int b) {
        return(a + b);
    }
    public int substract(int a,int b) {
        return(a - b);
    }
    public int multiplicar(int a, int b) {
        return a * b;
    }
    public int dividir(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("No se puede dividir por cero");
        }
        return a / b;
    }

    public int modulo(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("No se puede calcular el módulo por cero");
        }
        return a % b;
    }
}
