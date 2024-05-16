public class Books {
    private String bookTitle;
    private String bookType;
    private String author;
    private String aboutTheBook;

    Books(String name,String type , String writer,String aboutTheBook){
        bookTitle = name ;
        bookType = type ;
        this.author = writer ;
        this.aboutTheBook = aboutTheBook;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String writer) {
        this.author = writer;
    }

    public String getAboutTheBook() {
        return aboutTheBook;
    }

    public void setAboutTheBook(String aboutTheBook) {
        this.aboutTheBook = aboutTheBook;
    }

    @Override
    public String toString() {
        return
                "\n bookTitle =" + bookTitle +
                        "\n bookType =" + bookType +
                        "\n Author =" + author  +
                        "\n aboutTheBook =" + aboutTheBook ;
    }
}
