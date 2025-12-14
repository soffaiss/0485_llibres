import java.io.*;
import java.util.*;

public class InventariLlibres {

    private final Scanner scanner = new Scanner(System.in);
    private ArrayList<Llibre> inventari;
    private String nomFitxer;

    public InventariLlibres(String nomFitxer) {
        this.inventari = new ArrayList<Llibre>();
        this.nomFitxer = nomFitxer;
    }

    public ArrayList<Llibre> getInventari() {
        return inventari;
    }

    public String getNomFitxer() {
        return nomFitxer;
    }

    private boolean validarISBN(String isbn) {
        return isbn != null && isbn.length() == 13;
    }

    public void afegirLlibre() {

        String isbnNou = "";
        String titolNou;
        String autorNou;
        double preuNou;
        boolean isbnCorrecte = false;

        System.out.println("VAMOS A DAR DE ALTA UN NUEVO LIBRO");

        do {
            System.out.print("INTRODUCE ISBN DEL NUEVO LIBRO (13 carácteres): ");
            isbnNou = scanner.nextLine();

            if (validarISBN(isbnNou)) {
                isbnCorrecte = true;
            } else {
                System.out.println("ISBN incorrecto. Debe tener 13 caracteres.");
            }
        } while (!isbnCorrecte);

        System.out.print("INTRODUCE EL TÍTULO: ");
        titolNou = scanner.nextLine();

        System.out.print("INTRODUCE EL AUTOR: ");
        autorNou = scanner.nextLine();

        System.out.print("INTRODUCE EL PRECIO: ");
        preuNou = scanner.nextDouble();

        scanner.nextLine();

        Llibre nouLlibre = new Llibre(titolNou, autorNou, isbnNou, preuNou);
        this.inventari.add(nouLlibre);
        System.out.println("Llibre afegit: " + titolNou);
    }

    public Llibre buscarLlibrePerISBN(String isbn) {
        for (int i = 0; i < inventari.size(); i++) {
            Llibre llibre = inventari.get(i);
            if (llibre.getIsbn().equals(isbn)) {
                return llibre;
            }
        }
        return null;
    }

    public boolean eliminarLlibre(String isbn) {
        Llibre llibreAEliminar = buscarLlibrePerISBN(isbn);

        if (llibreAEliminar != null) {
            inventari.remove(llibreAEliminar);
            System.out.println("Llibre eliminat.");
            return true;
        } else {
            System.out.println("No s'ha trobat cap llibre amb ISBN: " + isbn);
            return false;
        }
    }

    public List<Llibre> obtenirTotsElsLlibres() {
        return inventari;
    }

    public void guardarInventariEnFitxer(String nomFitxer) throws IOException {
        FileOutputStream fos = new FileOutputStream(nomFitxer);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(inventari);

        oos.close();
        fos.close();
        System.out.println("Inventari guardat.");
    }

    public void carregarInventariDesDeFitxer(String nomFitxer) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(nomFitxer);
        ObjectInputStream ois = new ObjectInputStream(fis);

        this.inventari = (ArrayList<Llibre>) ois.readObject();

        ois.close();
        fis.close();
        System.out.println("Inventari carregat.");
    }
}