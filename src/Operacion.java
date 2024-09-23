public class Operacion {
    // Método estático que realiza la suma de dos números.
    public static double suma(Numero a, Numero b) {
        // Retorna la suma de los valores de 'a' y 'b'.
        return a.getValor() + b.getValor();
    }

    // Método estático que realiza la resta de dos números.
    public static double resta(Numero a, Numero b) {
        // Retorna la resta del valor de 'b' al valor de 'a'.
        return a.getValor() - b.getValor();
    }

    // Método estático que realiza la multiplicación de dos números.
    public static double multiplicacion(Numero a, Numero b) {
        // Retorna el producto de los valores de 'a' y 'b'.
        return a.getValor() * b.getValor();
    }

    // Método estático que realiza la división de dos números.
    public static double division(Numero a, Numero b) {
        // Comprueba si el valor de 'b' es cero.
        if (b.getValor() == 0) {
            // Lanza una excepción si se intenta dividir por cero.
            throw new ArithmeticException("No se puede dividir por cero.");
        }
        // Retorna el cociente de 'a' dividido por 'b'.
        return a.getValor() / b.getValor();
    }

    // Método estático que calcula la potencia de 'a' elevado a 'b'.
    public static double potencia(Numero a, Numero b) {
        // Utiliza Math.pow para calcular 'a' elevado a 'b' y retorna el resultado.
        return Math.pow(a.getValor(), b.getValor());
    }

    // Método estático que calcula la raíz cuadrada de un número.
    public static double raizCuadrada(Numero a) {
        // Comprueba si el valor de 'a' es negativo.
        if (a.getValor() < 0) {
            // Lanza una excepción si se intenta calcular la raíz cuadrada de un número negativo.
            throw new ArithmeticException("No se puede calcular la raíz cuadrada de un número negativo.");
        }
        // Retorna la raíz cuadrada del valor de 'a'.
        return Math.sqrt(a.getValor());
    }
}
