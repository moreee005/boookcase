package BookCase;

import java.util.List;
import java.util.Scanner;

public class BookMenu implements AbstractMenu {
    private RepositoryBook bookList;
    

    public BookMenu() {
        this.bookList = new RepositoryBook();
    }

    @Override
    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Book Menu Searching");
        System.out.println("1. Cari data book yang memiliki price paling Murah.");
        System.out.println("2. Cari data book yang memiliki price paling Mahal.");
        System.out.println("3. Cari data book berdasarkan range Price. (Lebih Kecil, C/ masukan price 50. Maka akan menampilkan Book dengan harga 50 Kebawah)");
        System.out.println("4. Cari Comic Berdasarkan Rating mangaka.");
        System.out.println("5. Cari Book berdasarkan Country dari Publishernya.");
        System.out.println("6. Cari Book berdasarkan Country dari Authornya.");
        System.out.println("7. Cari data Comic yang memiliki price paling Mahal.");
        System.out.println("0. Back to Main Menu");
        System.out.print("Pilih opsi: ");

        int option = scanner.nextInt();
        switch (option) {
            case 1:
                displayBookData();
                showMenu(); // Kembali ke menu buku setelah menampilkan data
                break;
            case 2:
                displayAuthorData();
                showMenu(); // Kembali ke menu buku setelah menampilkan data
                break;    
            case 0:
                System.out.println("Kembali ke menu utama...");
                new MainMenu().showMenu();
                break;
            default:
                System.out.println("Opsi tidak valid!");
                showMenu();
        }
        scanner.close();
    }

    private void displayBookData() {
        List<Book> books = bookList.getBooks();
        System.out.println("Daftar Buku:");
        for (Book book : books) {
            book.displayDetails();
        }
    }
    private void displayAuthorData() {
        List<Author> authors = bookList.getAuthor();
        System.out.println("Daftar Buku:");
        for (Author book : authors) {
            book.displayDetails();
        }
    }
}
