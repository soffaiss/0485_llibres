import java.util.*;
import java.io.*;

public class main {

    public static void main(String[] args) throws Exception {
        String FITXER = "dades.txt";
        InventariLlibres gestor = new InventariLlibres(FITXER);
        Scanner scanner = new Scanner(System.in);
        int opcio = 99;
        
        while (opcio != 0) {
            imprimirMenu();
            
            String input = scanner.nextLine(); 
            opcio = Integer.parseInt(input); 

            switch (opcio) {
                case 1:
                    gestor.afegirLlibre();
                    break;
                case 2:
                    System.out.print("ISBN a eliminar: ");
                    String isbnEliminar = scanner.nextLine();
                    gestor.eliminarLlibre(isbnEliminar);
                    break;
                case 3:
                    System.out.print("ISBN a buscar: ");
                    String isbnCerca = scanner.nextLine();
                    Llibre llibreTrobat = gestor.buscarLlibrePerISBN(isbnCerca);
                    if (llibreTrobat != null) {
                        System.out.println(llibreTrobat);
                    } else {
                        System.out.println("No trobat.");
                    }
                    break;
                case 4:
                    for (int i = 0; i < gestor.obtenirTotsElsLlibres().size(); i++) {
                        System.out.println(gestor.obtenirTotsElsLlibres().get(i));
                    }
                    break;
                case 0:
                    gestor.guardarInventariEnFitxer(FITXER);
                    System.out.println("Adéu.");
                    break;
                default:
                    System.out.println("Opció incorrecta");
                    break;
            }
        }
    }
     public static void imprimirMenu() {
        System.out.println("1. Afegir");
        System.out.println("2. Eliminar");
        System.out.println("3. Buscar");
        System.out.println("4. Llistar");
        System.out.println("0. Sortir");
    }
}