import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Book {

    private String Title;
    private String Writer;
    private String ISBN;
    private LocalDate DatePublication;
    //borrower
    private Student Borrower;
    //Scanner
    Scanner scanner = new Scanner(System.in);

    //Constructor Parametric
    public Book(
            String Title,
            String Writer,
            String ISBN,
            LocalDate DatePublication
    ) {
        this.Title = Title;
        this.Writer = Writer;
        this.ISBN = ISBN;
        this.DatePublication = DatePublication;
    }

    //------------------getters------------------
    public String getTitle() {
        return Title;
    }

    public String getWriter() {
        return Writer;
    }

    public String getISBN() {
        return ISBN;
    }

    public LocalDate getDatePublication() {
        return DatePublication;
    }

    public Student getBorrower() {
        return Borrower;
    }

    //------------------Setters------------------
    public void setTitle(String Title) {
        this.Title = Title;
    }

    public void setWriter(String Writer) {
        this.Writer = Writer;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setDatePublication(LocalDate DatePublication) {
        this.DatePublication = DatePublication;
    }

    public void setBorrower(Student Borrower) {
        this.Borrower = Borrower;
    }

    //toString
    @Override
    public String toString() {
        if (Borrower != null) {
            return (
                    "| Title: " +
                            Title +
                            "| Writter: " +
                            Writer +
                            "| ISBN: " +
                            ISBN +
                            "| Date Of Publication: " +
                            DatePublication +
                            "\n| Borrower:" +
                            Borrower.toString()
            );
        }
        return (
                "| Title: " +
                        Title +
                        "| Writter: " +
                        Writer +
                        "| ISBN: " +
                        ISBN +
                        "| Date Of Publication: " +
                        DatePublication
        );
    }

    //------------------Methods------------------

    //Modify
    public void ModifyBook() {
        System.out.print("Title :");
        Title = scanner.next();
        System.out.print("Writer :");
        Writer = scanner.next();
        System.out.print("ISBN :");
        ISBN = scanner.next();
        if(Borrower!=null){
            System.out.print("Borrower ID:");
            // Borrower = scanner.next();
        }
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
    }

    //Add Borrower
    public void AddBorrower(Student Borrower) {
        this.Borrower = Borrower;
    }

    //Remove Borrower
    public void RemoveBorrower(Student Borrower) {
        this.Borrower = null;
    }
}
