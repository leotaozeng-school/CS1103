public class LibraryCatalogTest {
    public static void main(String[] args) {
        testCatalog();
    }

    public static void testCatalog() {
        Catalog<String> catalog = new Catalog<>();

        // Test adding items
        LibraryItem<String> book1 = new LibraryItem<>("The Great Gatsby", "F. Scott Fitzgerald", "B001");
        LibraryItem<String> book2 = new LibraryItem<>("To Kill a Mockingbird", "Harper Lee", "B002");
        LibraryItem<String> dvd1 = new LibraryItem<>("Inception", "Christopher Nolan", "D001");

        catalog.addItem(book1);
        catalog.addItem(book2);
        catalog.addItem(dvd1);

        // Test displaying catalog
        System.out.println("Catalog after adding items:");
        catalog.displayCatalog();

        // Test removing an item
        catalog.removeItem("B001");

        System.out.println("\nCatalog after removing 'The Great Gatsby':");
        catalog.displayCatalog();

        // Test removing a non-existent item
        catalog.removeItem("B003");

        // Test getting an item
        LibraryItem<String> retrievedItem = catalog.getItem("D001");
        if (retrievedItem != null) {
            System.out.println("\nRetrieved item: " + retrievedItem);
        } else {
            System.out.println("\nItem not found");
        }

        // Test getting a non-existent item
        LibraryItem<String> nonExistentItem = catalog.getItem("B003");
        if (nonExistentItem == null) {
            System.out.println("Non-existent item correctly returned null");
        }
    }
}
