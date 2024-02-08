import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import static java.lang.System.exit;
class Book {
    String title;
    String author;
    String isbn;
    LocalDate pubDate;

    public Book(String title, String author, String isbn, LocalDate pubDate) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.pubDate = pubDate;
    }

    public  Book(){

    }


//    public String toString() {
//        return "Titre : "+title+" Autaur : "+author+"  isbn :"+isbn+" la date de publication"+publicationDate;
//    }

    public void editBook(String nv_Title , String nv_author , String nv_isbn , LocalDate nv_pubDate ) {
        if (nv_Title != null) {
            this.title = nv_Title;
        }
        if (nv_author != null) {
            this.author = nv_author;
        }
        if ( nv_isbn != null){
            this.isbn = nv_isbn;
        }
        if (nv_pubDate != null){
            this.pubDate = nv_pubDate;
        }
    }
}

 class Student  {
    String name;
    String address;
    int  id_number;
    List<Book> listBooks;
    public Student(String name ,String address, int id_number){
        this.name=name;
        this.address=address;
        this.id_number=id_number;
        this.listBooks = new ArrayList<>();

    }

//    public String toString(){
//        return "le nom : "+name+" Adresse : "+address+" le numéro d'identification"+id_number;
//    }
}


class Library {
    static ArrayList<Book> ListBook = new ArrayList<Book>();
    ArrayList<Student> ListStudent = new ArrayList<Student>();

    // ajouter un livre
    static void addBook() {
        Scanner input = new Scanner(System.in);
        Book book = new Book();
        System.out.println("Entrer le titre du livre :");
        book.title = input.nextLine();
        System.out.println("Entrer le nom de l'auteur :");
        book.author = input.nextLine();
        System.out.println("Entrer l'ISBN du livre :");
        book.isbn = input.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.print("Enter a date (dd/MM/yyyy): ");
        String pubDate = input.nextLine();
        LocalDate localDate = LocalDate.parse(pubDate, formatter);
        book.pubDate = LocalDate.parse(pubDate);
        ListBook.add(book);
    }

    //  afficher les livres
   static void displayBooks() {
        System.out.println("Liste des livres dans la bibliothèque :");
        for (Book book : ListBook) {
            System.out.println("Titre : " + book.title);
            System.out.println("Auteur : " + book.author);
            System.out.println("ISBN : " + book.isbn);
            System.out.println("Date de publication : " + book.pubDate);
            System.out.println();
        }
    }
}

class Menu {
    // Méthode pour afficher le men

    // Méthode pour exécuter le menu
    public static void runMenu() {


        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("|-------------------------------------------------|");
            System.out.println("|             Books management                    |");
            System.out.println("|-------------------------------------------------|");
            System.out.println("|              1-- Add Book                       |");
            System.out.println("|              2-- Display Books                  |");
            System.out.println("|              3-- Delete Book                    |");
            System.out.println("|              4-- Update Book                    |");
            System.out.println("|              5-- Search to Book                 |");
            System.out.println("|              6-- return to the Main interface   |");
            System.out.println("|              7-- Quitter                        |");
            System.out.println("|-------------------------------------------------|");
            System.out.println("|-------------------------------------------------|");
           // displayMenu();
            System.out.print("Enter your choice (1-6): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                     Library.addBook();
                    break;
                case 2:
                    Library.displayBooks();
                    break;
                case 3:
                    //  searchBook();
                    break;

                case 4:
                    //  returnBook();
                    break;
                case 5:
                      exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        }
    }
}

public class Main  {
    public static void main(String[] args){
       // Menu menu = new Menu();
       // Menu.displayMenu();
        Menu.runMenu();
    }
}


