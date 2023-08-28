Package library;
Import java.util.ArrayList;
	Import java.util.HashMap;
	Import java.util.List;
	Import java.util.Map;
	Import java.util.Scanner;

	Class Book {
	    Private int bookId;
	    Private String title;
	    Private String author;
	    Private boolean isAvailable;

	    Public Book(int bookId, String title, String author) {
	        This.bookId = bookId;
	        This.title = title;
	        This.author = author;
	        This.isAvailable = true;
	    }

	    Public int getBookId() {
	        Return bookId;
	    }

	    Public String getTitle() {
	        Return title;
	    }

	    Public String getAuthor() {
	        Return author;
	    }

	    Public boolean isAvailable() {
	        Return isAvailable;
	    }

	    Public void setAvailable(boolean available) {
	        isAvailable = available;
	    }

	    @Override
	    Public String toString() {
	        Return “[“ + bookId + “] “ + title + “ by “ + author + “ (Available: “ + isAvailable + “)”;
	    }
	}

	Class Library {
	    Private Map<Integer, Book> books;

	    Public Library() {
	        Books = new HashMap<>();
	    }

	    Public void addBook(Book book) {
	        Books.put(book.getBookId(), book);
	    }

	    Public Book getBook(int bookId) {
	        Return books.get(bookId);
	    }

	    Public List<Book> getAllBooks() {
	        Return new ArrayList<>(books.values());
	    }

	    Public List<Book> getAvailableBooks() {
	        List<Book> availableBooks = new ArrayList<>();
	        For (Book book : books.values()) {
	            If (book.isAvailable()) {
	                availableBooks.add(book);
	            }
	        }
	        Return availableBooks;
	    }
	}

	Public class LibraryManagementSystem {
	    Public static void main(String[] args) {
	        Library library = new Library();
	        Library.addBook(new Book(1, “Java: The Complete Reference”, “Herbert Schildt”));
	        Library.addBook(new Book(2, “Effective Java”, “Joshua Bloch”));
	        Library.addBook(new Book(3, “Clean Code”, “Robert C. Martin”));

	        Scanner scanner = new Scanner(System.in);
	        Int choice;
	        Do {
	            System.out.println(“\n==== Library Management System ====”);
	            System.out.println(“1. View all books”);
	            System.out.println(“2. View available books”);
	            System.out.println(“3. Borrow a book”);
	            System.out.println(“4. Return a book”);
	            System.out.println(“0. Exit”);
	            System.out.print(“Enter your choice: “);
	            Choice = scanner.nextInt();

	            Switch (choice) {
	                Case 1:
	                    displayBooks(library.getAllBooks());
	                    break;
	                case 2:
	                    displayBooks(library.getAvailableBooks());
	                    break;
	                case 3:
	                    borrowBook(library);
	                    break;
	                case 4:
	                    returnBook(library);
	                    break;
	                case 0:
	                    System.out.println(“Thank you for using the Library Management System. Goodbye!”);
	                    Break;
	                Default:
	                    System.out.println(“Invalid choice. Please try again.”);
	            }
	        } while (choice != 0);

	        Scanner.close();
	    }

	    Private static void displayBooks(List<Book> books) {
	        If (books.isEmpty()) {
	            System.out.println(“No books found.”);
	            Return;
	        }

	        System.out.println(“Available Books:”);
	        For (Book book : books) {
	            System.out.println(book);
	        }
	    }

	    Private static void borrowBook(Library library) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print(“Enter the book ID you want to borrow: “);
	        Int bookId = scanner.nextInt();
	        Book book = library.getBook(bookId);

	        If (book == null) {
	            System.out.println(“Book not found.”);
	        } else if (!book.isAvailable()) {
	            System.out.println(“The book is currently not available for borrowing.”);
	        } else {
	            Book.setAvailable(false);
	            System.out.println(“You have successfully borrowed the book: “ + book.getTitle());
	        }
	    }

	    Private static void returnBook(Library library) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print(“Enter the book ID you want to return: “);
	        Int bookId = scanner.nextInt();
	        Book book = library.getBook(bookId);

	        If (book == null) {
	            System.out.println(“Book not found.”);
	        } else if (book.isAvailable()) {
	            System.out.println(“This book is already in the library.”);
	        } else {
	            Book.setAvailable(true);
	            System.out.println(“You have successfully returned the book: “ + book.getTitle());
	        }
	    }
	}

}
