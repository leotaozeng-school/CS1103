public class LibraryCatalogTest {
    public static void main(String[] args) {
        testCatalogWithStrings();
        testCatalogWithIntegers();
        testCatalogWithCustomType();
    }

    public static void testCatalogWithStrings() {
        System.out.println("Testing catalog with String IDs:");
        Catalog<String> catalog = new Catalog<>();

        // Add various types of items
        catalog.addItem(new LibraryItem<>("The Great Gatsby", "F. Scott Fitzgerald", "BOOK001"));
        catalog.addItem(new LibraryItem<>("Inception", "Christopher Nolan", "DVD001"));
        catalog.addItem(new LibraryItem<>("National Geographic", "Various", "MAG001"));

        catalog.displayCatalog();

        // Remove an item
        catalog.removeItem("DVD001");
        System.out.println("\nAfter removing 'Inception':");
        catalog.displayCatalog();

        // Try to remove a non-existent item
        catalog.removeItem("BOOK002");

        // Retrieve an item
        LibraryItem<String> item = catalog.getItem("MAG001");
        System.out.println("\nRetrieved item: " + (item != null ? item : "Not found"));
    }

    public static void testCatalogWithIntegers() {
        System.out.println("\nTesting catalog with Integer IDs:");
        Catalog<Integer> catalog = new Catalog<>();

        catalog.addItem(new LibraryItem<>("1984", "George Orwell", 1001));
        catalog.addItem(new LibraryItem<>("The Matrix", "Wachowski Sisters", 2001));

        catalog.displayCatalog();

        // Remove an item
        catalog.removeItem(1001);
        System.out.println("\nAfter removing '1984':");
        catalog.displayCatalog();
    }

    public static void testCatalogWithCustomType() {
        System.out.println("\nTesting catalog with custom ItemID type:");
        Catalog<ItemID> catalog = new Catalog<>();

        catalog.addItem(new LibraryItem<>("The Catcher in the Rye", "J.D. Salinger", new ItemID("BOOK", 3001)));
        catalog.addItem(new LibraryItem<>("Friends: The Complete Series", "Various", new ItemID("DVD", 3002)));

        catalog.displayCatalog();

        // Remove an item
        catalog.removeItem(new ItemID("DVD", 3002));
        System.out.println("\nAfter removing 'Friends: The Complete Series':");
        catalog.displayCatalog();
    }
}

// Custom ItemID class for demonstration
class ItemID {
    private final String type;
    private final int number;

    public ItemID(String type, int number) {
        this.type = type;
        this.number = number;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ItemID itemID = (ItemID) obj;
        return number == itemID.number && type.equals(itemID.type);
    }

    @Override
    public String toString() {
        return type + "-" + number;
    }
}
