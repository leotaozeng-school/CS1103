/*
a. Create a generic LibraryItem class with attributes such as title, author, and itemID
b. Ensure that the LibraryItem class is compatible with the generic catalog
*/

public class LibraryItem<T> {
    private String title;  // private = restricted access
    private String author;
    private T itemID;

    // Create a class constructor for the LibraryItem class
    public LibraryItem(String title, String author, T itemID) {
        this.title = title;
        this.author = author;
        this.itemID = itemID;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public T getItemID() {
        return itemID;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", ID: " + itemID;
    }
}
