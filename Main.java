public class Main {
    public static void main(String[] args) {
        // Creating a new Book object using different constructors
        Book book1 = new Book();
        Book book2 = new Book("Title", "Author", "ISBN", "Publication Date");
        Book book3 = new Book(book2); // Creating a copy of book2

        // Setting values using setter methods
        book1.setTitle("New Title");
        book1.setAuthor("New Author");
        book1.setIsbn("New ISBN");
        book1.setPublicationDate("New Publication Date");

        // Displaying book information using the afficher() method
        book1.afficher();
        book2.afficher();
        book3.afficher();
    }
}