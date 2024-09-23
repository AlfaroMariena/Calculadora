public class Calculadora {

    // Método que realiza operaciones aritméticas con dos números.
    public double realizarOperacion(String tipo, Numero a, Numero b) {
        // Se convierte el tipo de operación a minúsculas para evitar problemas de mayúsculas.
        switch (tipo.toLowerCase()) {
            case "suma": // Si la operación es suma
                return Operacion.suma(a, b); // Llama al método suma de la clase Operacion.
            case "resta": // Si la operación es resta
                return Operacion.resta(a, b); // Llama al método resta de la clase Operacion.
            case "multiplicacion": // Si la operación es multiplicación
                return Operacion.multiplicacion(a, b); // Llama al método multiplicación de la clase Operacion.
            case "division": // Si la operación es división
                return Operacion.division(a, b); // Llama al método división de la clase Operacion.
            case "potencia": // Si la operación es potencia
                return Operacion.potencia(a, b); // Llama al método potencia de la clase Operacion.
            default: // Si la operación no es válida
                throw new IllegalArgumentException("Operación no válida."); // Lanza una excepción indicando que la operación es inválida.
        }
    }

    // Método que realiza la operación raíz cuadrada con un solo número.
    public double realizarOperacion(String tipo, Numero a) {
        // Comprueba si el tipo de operación es "raiz", ignorando mayúsculas y minúsculas.
        if (tipo.equalsIgnoreCase("raiz")) {
            return Operacion.raizCuadrada(a); // Llama al método raíz cuadrada de la clase Operacion.
        } else {
            throw new IllegalArgumentException("Operación no válida para un solo número."); // Lanza una excepción si se intenta usar otro tipo de operación.
        }
    }
}
