package Algorithm_DataStructures.Exercise6.Library_Management_System;

class Book {
    int bookId;
    String title;
    String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }
}

class BookSearch {
    public static Book linearSearch(Book[] books, String title) {
        for (Book book : books) {
            if (book.title.equals(title)) {
                return book;
            }
        }
        return null;
    }

    public static Book binarySearch(Book[] books, String title) {
        int low = 0;
        int high = books.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int compare = title.compareTo(books[mid].title);

            if (compare == 0) {
                return books[mid];
            } else if (compare < 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return null;
    }
}

public class LMS {
    public static void main(String[] args) {
        Book[] books = {
            new Book(1, "Java Programming", "John Smith"),
            new Book(2, "Algorithms Unlocked", "Thomas Cormen"),
            new Book(3, "Clean Code", "Robert C. Martin")
        };

        String searchTitle = "Clean Code";

        // Linear Search
        Book linearResult = BookSearch.linearSearch(books, searchTitle);
        if (linearResult != null) {
            System.out.println("Book found using linear search: " + linearResult.title + " by " + linearResult.author);
        } else {
            System.out.println("Book not found using linear search.");
        }

        // Binary Search (Assuming books array is sorted by title)
        // Sorting the array for binary search
        java.util.Arrays.sort(books, (book1, book2) -> book1.title.compareTo(book2.title));

        Book binaryResult = BookSearch.binarySearch(books, searchTitle);
        if (binaryResult != null) {
            System.out.println("Book found using binary search: " + binaryResult.title + " by " + binaryResult.author);
        } else {
            System.out.println("Book not found using binary search.");
        }
    }
}