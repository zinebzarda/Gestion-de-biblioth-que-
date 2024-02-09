import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Student {

    private static int nextId = 1;
    private int Id;
    private String Nom;
    private String Prenom;
    private String Adresse;
    private ArrayList<Book> books = new ArrayList<Book>();
    Scanner scanner = new Scanner(System.in);
    public Student() {
        this.Id=nextId++;
    }
    //Constructor Parametric
    public Student(String Nom, String Prenom, String Adresse) {
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.Adresse = Adresse;
        this.Id=nextId++;
    }

    //------------------getters------------------
    public int getId() {
        return Id;
    }

    public String getNom() {
        return Nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public String getAdresse() {
        return Adresse;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    //------------------setters------------------
    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
    }

    public void setAdresse(String Adresse) {
        this.Adresse = Adresse;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books=books;
    }
    //------------------toString------------------
    @Override
    public String toString() {
        return "Id:"+Id+"   Nom:" + Nom + "  Prenom:" + Prenom + " Adresse:" + Adresse;
    }

    //------------------methods------------------

    //Modify Student
    public void ModifyStudent() {
        System.out.print("Nom :");
        Nom = scanner.next();
        System.out.print("Prenom :");
        Prenom = scanner.next();
        System.out.print("Adresse :");
        Adresse = scanner.next();
    }



}
