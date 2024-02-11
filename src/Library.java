import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Library {

    public ArrayList<Book> LibraryBooks = new ArrayList<Book>();
    public ArrayList<Student> LibraryStudents = new ArrayList<Student>();
    Scanner scanner = new Scanner(System.in);

    //--------------Methods---------------

    //Add Book
    public void addBook() {
        System.out.print("Title :");
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
    }

}
