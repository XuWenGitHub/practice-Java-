package book;

public class Book {
    private String name;
    private String author;
    private int price;
    private String type;
    private boolean isBorrow;
    private Book next;

    public Book(String name, String author, int price, String type) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isBorrow() {
        return isBorrow;
    }

    public void setBorrow(boolean borrow) {
        isBorrow = borrow;
    }

    public Book getNext() {
        return next;
    }

    public void setNext(Book next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Book{" +
                "书名='" + name + '\'' +
                ", 作者='" + author + '\'' +
                ", 价钱=" + price +
                ", 类型='" + type + '\'' +
                ", 是否被借出=" + isBorrow +
                '}';
    }
}
