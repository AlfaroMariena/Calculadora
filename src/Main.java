import java.util.Scanner; // Importa la clase Scanner para manejar la entrada del usuario.

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Crea un objeto Scanner para leer entradas del usuario.
        Calculadora calculadora = new Calculadora(); // Crea una instancia de la clase Calculadora.

        // Se define el menú de operaciones disponible.
        String menu = """
                ================================ 
                          CALCULADORA 
                ================================ 
                Seleccione una operación: 
                1. Suma 
                2. Resta 
                3. Multiplicación 
                4. División 
                5. Potencia 
                6. Raíz cuadrada 
                7. Salir 
                ================================ 
                """;

        // Bucle infinito para mantener el programa en ejecución hasta que el usuario decida salir.
        while (true) {
            System.out.print(menu); // Muestra el menú de operaciones.
            System.out.print("Ingrese el número de la operación: "); // Pide al usuario que ingrese el número de la operación.
            String operacion = scanner.nextLine(); // Lee la entrada del usuario.

            // Comprueba si el usuario quiere salir del programa.
            if (operacion.equals("7")) {
                System.out.println("Gracias por usar la calculadora. ¡Hasta luego!"); // Mensaje de despedida.
                break; // Sale del bucle.
            }

            try {
                // Maneja la operación de raíz cuadrada (opción 6).
                if (operacion.equals("6")) {
                    System.out.print("Ingrese un número: "); // Pide al usuario que ingrese un número.
                    double num1 = Double.parseDouble(scanner.nextLine()); // Convierte la entrada a un número.
                    double resultado = calculadora.realizarOperacion("raiz", new Numero(num1)); // Realiza la operación de raíz cuadrada.
                    System.out.printf("Resultado: √%.2f = %.2f%n", num1, resultado); // Muestra el resultado formateado.
                } else {
                    // Maneja las operaciones con dos números.
                    System.out.print("Ingrese el primer número: "); // Pide el primer número.
                    double num1 = Double.parseDouble(scanner.nextLine()); // Convierte la entrada a un número.
                    System.out.print("Ingrese el segundo número: "); // Pide el segundo número.
                    double num2 = Double.parseDouble(scanner.nextLine()); // Convierte la entrada a un número.

                    // Determina el tipo de operación según la opción seleccionada por el usuario.
                    String tipoOperacion = switch (operacion) {
                        case "1" -> "suma";
                        case "2" -> "resta";
                        case "3" -> "multiplicacion";
                        case "4" -> "division";
                        case "5" -> "potencia";
                        default -> throw new IllegalArgumentException("Operación no válida."); // Lanza excepción si la operación no es válida.
                    };

                    // Realiza la operación seleccionada y muestra el resultado.
                    double resultado = calculadora.realizarOperacion(tipoOperacion, new Numero(num1), new Numero(num2));
                    System.out.printf("Resultado: %.2f %s %.2f = %.2f%n", num1, getOperacionSimbolo(tipoOperacion), num2, resultado);
                }
            } catch (NumberFormatException e) {
                // Maneja la excepción si la entrada no es un número válido.
                System.out.println("Entrada no válida. Por favor, ingrese números.");
            } catch (ArithmeticException e) {
                // Maneja excepciones específicas de operaciones aritméticas.
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                // Maneja excepciones si la operación no es válida.
                System.out.println(e.getMessage());
            }
        }

        scanner.close(); // Cierra el scanner al finalizar el programa.
    }

    // Método que devuelve el símbolo de operación correspondiente.
    private static String getOperacionSimbolo(String operacion) {
        // Se utiliza un switch para determinar el símbolo según la operación.
        return switch (operacion) {
            case "suma" -> "+"; // Retorna "+" para suma.
            case "resta" -> "-"; // Retorna "-" para resta.
            case "multiplicacion" -> "*"; // Retorna "*" para multiplicación.
            case "division" -> "/"; // Retorna "/" para división.
            case "potencia" -> "^"; // Retorna "^" para potencia.
            default -> "?"; // Retorna "?" si la operación no es válida.
        };
    }
}
