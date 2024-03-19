public class Book implements Comparable {

    private String name;
    private String author;
    private int pages;
    private int year;

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
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public String toString() {
        return this.getName() + " - " + this.getAuthor() + " - syf: " + getPages() + " - yıl: " + getYear();
    }
}
