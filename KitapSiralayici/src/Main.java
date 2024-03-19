import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        TreeSet<Book> booksSortedName = new TreeSet<>(new NameComparator());

        booksSortedName.add(new Book("Dune", "Frank Herbert", 896, 1965));
        booksSortedName.add(new Book("Harry Potter and the Philosopher's Stone", "J. K. Rowling", 223, 1997));
        booksSortedName.add(new Book("The Hobbit", "J. R. R. Tolkien", 310, 1937));
        booksSortedName.add(new Book("Martin Eden", "Jack London", 393, 1909));
        booksSortedName.add(new Book("Foundation", "Isaac Asimov", 255, 1951));

        TreeSet<Book> bookSortedPages = new TreeSet<>(new PagesComparator());
        bookSortedPages.addAll(booksSortedName);

        System.out.println("\nKitap ismine göre sıralama:\n");
        for (Book book : booksSortedName){
            System.out.println(book.toString());
        }
        System.out.println("----------------------------------------------");
        System.out.println("Sayfa sayısına göre sıralama:\n");
        for (Book book : bookSortedPages){
            System.out.println(book.toString());
        }

    }
}