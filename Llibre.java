import java.util.*;

public class Llibre {
    private String titol;
    private String autor;
    private String isbn;
    private double preu;

    public Llibre(String titol, String autor, String isbn, double preu) {
        this.titol = titol;
        this.autor = autor;
        this.isbn = isbn;
        this.preu = preu;
    }

    public String getTitol() {
        return titol;
    }

    public String getAutor() {
        return autor;
    }

    public double getPreu() {
        return preu;
    }
    public String getIsbn() {
        return isbn;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setPreu(double preu) {
        this.preu = preu;
    }

    public String toString() {
        return "llibre [titol=" + titol + ", autor=" + autor + ", isbn=" + isbn + ", preu=" + preu + "]";
    }

    public boolean validarISBN(String isbn) {
    if (this.isbn != null && this.isbn.length() == 13) {
        return true;
    } else {
        return false;
    }
}


}