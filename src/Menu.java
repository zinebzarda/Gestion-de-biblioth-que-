import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.Scanner;

public class Menu {
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

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        int Exit=0;
        System.out.println(ANSI_CYAN+"########################################################################");
        System.out.println("##        ###########  ####      ##  ##########  ##########          ## ");
        System.out.println("##        ##           ## ##     ##  ##      ##  ##      ##          ## ");
        System.out.println("##        ##           ##  ##    ##  ##      ##  ##      ##          ## ");
        System.out.println("##        ###########  ##   ##   ##  ##########  ##########          ## ");
        System.out.println("##        ##           ##    ##  ##  ##      ##  ##      ##          ## ");
        System.out.println("##        ##           ##     ## ##  ##      ##  ##      ##          ## ");
        System.out.println("##        ###########  ##      ####  ##      ##  ##      ##          ## ");
        System.out.println("########################################################################");
        loop:while(Exit==0){
            int Choose;
            System.out.println(ANSI_GREEN+"***************************************************************");
            System.out.println("**************** CHOOSE ONE OPTION  ***************************");
            System.out.println(ANSI_YELLOW+"**     Add Student[1]        |       Add Book[2]             **");
            System.out.println(ANSI_PURPLE+"** Display All Students[3]   |   Display All Books[4]        **");
            System.out.println(ANSI_GREEN+"**    Search Student[5]      |      Search Book[6]           **");
            System.out.println(ANSI_RED+"**    remove Student[7]      |      remove Book[8]           **");
            System.out.println(ANSI_YELLOW+"** Add Book For Student[9]   |"+ANSI_RED+" Remove book From Student[10]  **");
            System.out.println(ANSI_BLUE+"**     Modify Student[11]    |      Modify Book[12]          **");
            System.out.println(ANSI_GREEN+"**       Exit All[13]        |                               **");
            System.out.println("***************************************************************");
            System.out.println("***************************************************************"+ANSI_RESET);
            Choose = scanner.nextInt();
            switch (Choose) {
                case 1:
                    library.addStudent();
                    break;
                case 2:
                    library.addBook();
                    break;
                case 3:
                    library.displayStudents();
                    break;
                case 4:
                    library.displayBooks();;
                    break;
                case 5:
                    library.searchStudent();;
                    break;
                case 6:
                    library.searchBook();
                    break;
                case 7:
                    library.removeStudent();
                    break;
                case 8:
                    library.removeBook();
                    break;
                case 9:
                    library.addBookForStudent();;
                    break;
                case 10:
                    library.RemoveBookForStudent();
                    break;
                case 11:
                    library.ModifyStudent();
                    break;
                case 12:
                    library.ModifyBook();
                    break;
                case 13:
                    Exit=1;
                    break;
                default:
                    System.out.println(ANSI_RED+"!!!!This option is not available!!!");
                    break;
            }

        }




    }
}
