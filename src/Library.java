import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    // ANSI escape codes for colors
    public static final  String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public ArrayList<Book> LibraryBooks = new ArrayList<Book>();
    public ArrayList<Student> LibraryStudents = new ArrayList<Student>();
    Scanner scanner = new Scanner(System.in);

    //--------------Methods---------------

    //Add Book
    public void addBook() {
        System.out.print(ANSI_YELLOW+"Title :");
        String Title = scanner.next();
        System.out.print("Writer :");
        String Writer = scanner.next();
        System.out.print("ISBN :");
        String ISBN = scanner.next();
        LocalDate DatePublication = null;

        while (DatePublication == null) {
            try {
                System.out.print("Date Publication (YYYY-MM-DD): ");
                String date = scanner.next();
                DatePublication = LocalDate.parse(date);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please enter date in YYYY-MM-DD format.");
            }
        }
            Book B = new Book(Title,Writer,ISBN,DatePublication);
            LibraryBooks.add(B);
        }

    //Add Student

    public void addStudent() {
        System.out.print(ANSI_YELLOW+"Nom :");
        String Nom = scanner.next();
        System.out.print("Prenom :");
        String Prenom = scanner.next();
        System.out.print("Adresse :");
        String Adresse = scanner.next();
        Student S = new Student(Nom, Prenom, Adresse);
        LibraryStudents.add(S);
    }




    }


