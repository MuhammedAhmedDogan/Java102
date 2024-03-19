public class Book implements Comparable<Book> {

    private final String name;
    private final String author;
    private final int pages;
    private final int year;

    public Book(String name, String author, int pages, int year) {
        this.name = name;
        this.author = author;
        this.pages = pages;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getPages() {
        return pages;
    }

    public int getYear() {
        return year;
    }

    @Override
    public int compareTo(Book o) {
        return this.name.compareTo(o.getName());
    }

    @Override
    public String toString() {
        return this.getName() + " - " + this.getAuthor() + " - syf: " + getPages() + " - yıl: " + getYear();
    }
}
