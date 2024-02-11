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

    //-------------------------------Display Books-------------------------------------
    public void displayBooks(){
        for(Book b : LibraryBooks){
            if(b!=null){
                System.out.println(b.toString());
            }
        }
    }
    //-------------------------------Display Students-------------------------------------
    public void displayStudents(){
        for(Student s : LibraryStudents){
            if(s!=null){
                System.out.print(ANSI_PURPLE);
                System.out.println(s.toString());
                if(s.getBooks()!=null){
                    for(Book b : s.getBooks()){
                        if(b!=null){
                            System.out.println(b.toString());
                        }
                    }
                }
            }
        }
    }



//-------------------------------Search Book-------------------------------------
    public void searchBook() {
        int n ;
        System.out.print(ANSI_GREEN+"Choose one option :\n| Search by Title[1]       |  Search by Writer[2]\n| Search by Number ISBN[3] |  Search by Number Borrower ID[4]\n Exit[5]\n:");
        n = scanner.nextInt();
        switch (n) {
            case 1:
                System.out.print("Insert Title:");
                String t = scanner.next();
                for (Book b : LibraryBooks) {
                    if (b != null) {
                        if (t.equals(b.getTitle())) {
                            System.out.println(b.toString());
                        }
                    }
                }
                break;
            case 2:
                System.out.print("Insert Writer:");
                String w = scanner.next();
                for (Book b : LibraryBooks) {
                    if (b != null) {
                        if (w.equals(b.getWriter())) {
                            System.out.println(b.toString());
                        }
                    }
                }
                break;
            case 3:
                System.out.print("Insert ISBN:");
                String i = scanner.next();
                for (Book b : LibraryBooks) {
                    if (b != null) {
                        if (i.equals(b.getISBN())) {
                            System.out.println(b.toString());
                        }
                    }
                }
                break;
            case 4:
                System.out.print("Insert  Browwer ID:");
                int B = scanner.nextInt();
                for (Book b : LibraryBooks) {
                    if (b != null) {
                        if (B == b.getBorrower().getId()) {
                            System.out.println(b.toString());
                        }
                    }
                }
                break;
            default:
                System.out.println(ANSI_RED+"!!!!This option is not available!!!");
                break;
        }
    }

    //-------------------------------Search Student-------------------------------------
    public void searchStudent() {
        System.out.print(ANSI_GREEN+"Choose one option:\n| Search by ID[1]                  |  Search by Nom[2]\n| Search by Prenom[3]              |  Search by  Adresse[4]\n| Search by Borrowed book Title[5] |  Exit [6]\n: ");
        int n = scanner.nextInt();
        switch (n) {
            case 1:
                System.out.print("Insert ID:");
                int t = scanner.nextInt();
                for (Student s : LibraryStudents) {
                    if (s != null) {
                        if (t == s.getId()) {
                            System.out.println(s.toString());
                        }
                    }
                }
                break;
            case 2:
                System.out.print("Insert Nom:");
                String N = scanner.next();
                for (Student s : LibraryStudents) {
                    if (s != null) {
                        if (N.equals(s.getNom())) {
                            System.out.println(s.toString());
                        }
                    }
                }
                break;
            case 3:
                System.out.print("Insert  Prenom:");
                String p = scanner.next();
                for (Student s : LibraryStudents) {
                    if (s != null) {
                        if (p.equals(s.getPrenom())) {
                            System.out.println(s.toString());
                        }
                    }
                }
                break;
            case 4:
                System.out.print("Insert Adresse:");
                String a = scanner.next();
                for (Student s : LibraryStudents) {
                    if (s != null) {
                        if (a.equals(s.getAdresse())) {
                            System.out.println(s.toString());
                        }
                    }
                }
                break;
            case 5:
                System.out.print("Insert  Borrowed Book Title:");
                String b = scanner.next();
                for (Student s : LibraryStudents) {
                    if (s != null) {
                        for (Book B : s.getBooks()) {
                            if (b.equals(B.getTitle())) {
                                System.out.println(s.toString());
                            }
                        }
                    }
                }
                break;
            default:
                System.out.println(ANSI_RED+"!!!!This option is not available!!!");
                break;
        }
    }
    //-------------------------------Remove Book-------------------------------------
    public void removeBook() {
        System.out.print(ANSI_RED + "Insert Title:");
        String t = scanner.next();
        boolean removed = false;

        for (Book b : LibraryBooks) {
            if (b != null && t.equals(b.getTitle())) {
                LibraryBooks.remove(b);
                removed = true;
                break;
            }
        }

        if (removed) {
            System.out.println("Book removed successfully.");
        } else {
            System.out.println("No book with the given title found.");
        }
    }
}


