import java.util.Scanner;

public class App {

    static Scanner sc = new Scanner(System.in);
    static String nombre = "N/A";
    static double nota1 = -1, nota2 = -1, nota3 = -1;
    public static void main(String[] args) throws Exception {
        mostrarMenu();
    }

    
        static void mostrarMenu() {
            var opciones = """
                --- Sistema de Registro de Estudiantes ---

                1. Registrar datos de un estudiante
                2. Mostrar datos del estudiante actual
                3. Calcular promedio de notas
                4. Mostrar resumen completo del estudiante
                5. Limpiar datos del estudiante actual
                0. Salir
                """;
            System.out.print(opciones);
            System.out.println("Seleccione una opción: ");
        }

        static void registrarEstudiante() {
            // Lógica para registrar datos de un estudiante
            if (!nombre.equals("N/A")) {
                leerEstudiante();
            }else{
                System.out.println("Ya hay un estudiante registrado. Desea sobrescribirlo? (s/n)");
                String respuesta = sc.nextLine();
                if(respuesta.equalsIgnoreCase("s")){
                    leerEstudiante();            
            }
                else{
                    System.out.println("Operación cancelada. No se sobrescribieron los datos.");
                }
            }

        }

        static void leerEstudiante() {
            System.out.print("Ingrese el nombre del estudiante: ");
            nombre = sc.nextLine();
            nota1 = solicitarNota();
            System.out.print("ingrese la segunda nota: ");
            nota2 = solicitarNota();
            System.out.print("ingrese la tercera nota: ");
            nota3 = solicitarNota();
            sc.nextLine(); // Limpiar el buffer
    }

        static boolean esValidaNota(double nota) {
            return nota >= 0 && nota <= 100;

        }

        static double solicitarNota() {
            double nota;
            do {
                System.out.print("Ingrese una nota (0-100): ");
                nota = sc.nextDouble();
                if (!esValidaNota(nota)) {
                    System.out.println("Nota inválida. Debe estar entre 0 y 100.");
                }
            } while (!esValidaNota(nota));
            return nota;
        }

        static void mostrarEstudiante() {
            if (nombre.equals("N/A")) {
                System.out.println("No hay datos de estudiante registrado actualmente.");
            } else {
                System.out.println("Nombre del estudiante: " + nombre);
                System.out.println("Notas: " + nota1 + ", " + nota2 + ", " + nota3);
            }
        }

        
}