package BookCase;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;


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
            case 11:
                displayBookData();
                showMenu(); // Kembali ke menu buku setelah menampilkan data
                break;
            case 12:
                displayAuthorData();
                showMenu(); // Kembali ke menu buku setelah menampilkan data
                break;
            case 13:
                displayPublisherData();
                showMenu(); // Kembali ke menu buku setelah menampilkan data
                break;
            case 1:
                displayCheapestBook();
                showMenu();
                break;
            case 2:
                displayExpensiveBook();
                showMenu();
                break;
            case 3:
                displayRangeBook();
                showMenu();
                break;
            case 4:
                displayRangeManga();
                showMenu();
                break;
            case 5:
                displayRangeCountryBook();
                showMenu();
                break;
            case 6:
                displayRangeCountryAuthor();
                showMenu();
                break;
//           case 7:
//                displayExpensiveComic();
//                showMenu();
//                break;
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
        List<Publisher> publishers = bookList.getPublisher();

        for (Publisher publisher : publishers) {
            for (Book book : books) {
                if (publisher.getName() == book.getPublisher()) {
                    String code = book.getCode();
                    String title = book.getTitle();
                    String author = book.getAuthor();
                    String wow = book.getPublisher();

                    double productionCost = publisher.getProductionCost();
                    double price = productionCost * 1.2;
                    System.out.println("Code : " + code);
                    System.out.println("Title : " + title);
                    System.out.println("Author : " + author);
                    System.out.println("Wow : " + wow);
                    System.out.println("Price : " + price);
                    System.out.println();
                }
            }
        }
    }

    private void displayAuthorData() {
        List<Author> authors = bookList.getAuthor();
        System.out.println("Daftar Buku:");
        for (Author book : authors) {
            book.displayDetails();
        }
    }

    private void displayPublisherData() {
        List<Publisher> publisher = bookList.getPublisher();

        System.out.println("Daftar Buku:");
        for (Publisher book : publisher) {
            book.displayDetails();
        }
    }

    private void displayCheapestBook() {
        List<Book> books = bookList.getBooks();
        List<Publisher> publishers = bookList.getPublisher();
        Publisher cheapestPublisher = null;
        double minPrice = 16;
        Book cheapestBook = null;
        List<Book> booksBelowRange = new ArrayList<>();
        // Mencari harga termurah berdasarkan harga produksi dari penerbit
        for (Publisher publisher : publishers) {
            for (Book book : books) {
                if (publisher.getName().equals(book.getPublisher())) {
                    double productionCost = publisher.getProductionCost();
                    double price = productionCost * 1.2;

                    if (price < minPrice) {
                        minPrice = price;
                        // cheapestPublisher = publisher;
                        //cheapestBook = book;
                        booksBelowRange.add(book);
                        System.out.println("Code: " + book.getCode());
                        System.out.println("Title: " + book.getTitle());
                        System.out.println("Author: " + book.getAuthor());
                        System.out.println("Publisher: " + book.getPublisher());
                        System.out.println("Price: " + price);
                    }
                }
            }
        }
        // Menampilkan detail buku dari penerbit dengan harga terendah
        //if (cheapestPublisher != null) {
        //  System.out.println("Code: " + cheapestBook.getCode());
        //System.out.println("Title: " + cheapestBook.getTitle());
        //System.out.println("Author: " + cheapestBook.getAuthor());
        // System.out.println("Publisher: " + cheapestBook.getPublisher());
        //double productionCost = cheapestPublisher.getProductionCost();
        //double price = productionCost * 1.2;
        //System.out.println("Price: " + price);
        //} else {
        //   System.out.println("No book found.");
        //}
    }

    private void displayExpensiveBook() {
        List<Book> books = bookList.getBooks();
        List<Publisher> publishers = bookList.getPublisher();
        Publisher expensivePublisher = null;
        double maxPrice = 30;
        List<Book> expensiveBooks = new ArrayList<>(); // Daftar untuk menyimpan buku yang harganya di atas maxPrice

        // Mencari buku dengan harga di atas maxPrice berdasarkan harga produksi dari penerbit
        for (Publisher publisher : publishers) {
            for (Book book : books) {
                if (publisher.getName().equals(book.getPublisher())) {
                    double productionCost = publisher.getProductionCost();
                    double price = productionCost * 1.2;

                    if (price > maxPrice) {
                        expensiveBooks.add(book); // Menambahkan buku ke daftar buku mahal
                        expensivePublisher = publisher;
                    }
                }
            }
        }

        // Menampilkan detail buku-buku dengan harga di atas maxPrice
        if (!expensiveBooks.isEmpty()) {
            for (Book book : expensiveBooks) {
                System.out.println("Code: " + book.getCode());
                System.out.println("Title: " + book.getTitle());
                System.out.println("Author: " + book.getAuthor());
                System.out.println("Publisher: " + book.getPublisher());
                double productionCost = expensivePublisher.getProductionCost();
                double price = productionCost * 1.2;
                System.out.println("Price: " + price);
                System.out.println();
            }
        } else {
            System.out.println("No book found with price above " + maxPrice);
        }
    }

    private void displayRangeBook() {
        List<Book> books = bookList.getBooks();
        List<Publisher> publishers = bookList.getPublisher();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input Range Price: ");
        double rangePrice = scanner.nextDouble();

        List<Book> booksBelowRange = new ArrayList<>(); // ArrayList untuk menyimpan buku di bawah rangePrice
        List<Publisher> rangePublisher = new ArrayList<>(); //  ArrayList untuk menyimpan production cost buku di bawah rangePrice

        for (Publisher publisher : publishers) {
            for (Book book : books) {
                if (publisher.getName().equals(book.getPublisher())) {
                    double productionCost = publisher.getProductionCost();
                    double price = productionCost * 1.2;


                    if (price < rangePrice) {
                        booksBelowRange.add(book); // Menambahkan buku ke dalam ArrayList
                        rangePublisher.add(publisher);
                    }
                }
            }
        }

        // Mencetak semua buku yang memiliki harga di bawah rangePrice
        if (!booksBelowRange.isEmpty()) {
            System.out.println("Buku dengan harga di bawah " + rangePrice + ":");
            for (Book book : booksBelowRange) {
                Double productionCost = null;


                for (Publisher publisher : rangePublisher) {
                    if (book.getPublisher().equalsIgnoreCase(publisher.getName())) {
                        productionCost = publisher.getProductionCost();
                        break;
                    }
                }
                System.out.println("Code: " + book.getCode());
                System.out.println("Title: " + book.getTitle());
                System.out.println("Author: " + book.getAuthor());
                System.out.println("Publisher: " + book.getPublisher());
                double price = productionCost * 1.2;
                System.out.println("Price: " + price);
                System.out.println();
            }
        } else {
            System.out.println("Tidak ada buku dengan harga di bawah " + rangePrice);
        }
    }

    private void displayRangeManga() {
        List<Mangaka> mangaka = bookList.getMangaka();
        List<Publisher> publishers = bookList.getPublisher();
        List<Comic> comics = bookList.getComic();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input Rating: ");
        String ratingInput = scanner.nextLine();

        List<Comic> booksBelowRange = new ArrayList<>(); // ArrayList untuk menyimpan buku di bawah rangePrice
        List<Publisher> rangePublisher = new ArrayList<>(); //  ArrayList untuk menyimpan production cost buku di bawah rangePrice
        List<Mangaka> mangakaBelowRange = new ArrayList<>();
        for (Publisher publisher : publishers) {
            for (Comic comic1 : comics) {
                for (Mangaka mangaka1 : mangaka) {
                    String publisher1 = publisher.getName();
                    String firstName = mangaka1.getFirstName();
                    String lastName = mangaka1.getLastName();
                    String name = firstName + lastName;
                    String author1 = comic1.getAuthor();

                    // System.out.println(author1);
                    // System.out.println(publisher1);
                    //System.out.println(name);
                    if (name.equals(comic1.getAuthor())) {
                        booksBelowRange.add(comic1); // Menambahkan buku ke dalam ArrayList
                        rangePublisher.add(publisher);
                        if (comic1.getPublisher().equalsIgnoreCase(publisher.getName())) {

                            double productionCost = publisher.getProductionCost();
                            double price = 0.0;
                            if (mangaka1.getRating().equals("New Commer")) {
                                if (comic1.getSeries()) {
                                    price = productionCost * 1.35;

                                } else {
                                    price = productionCost * 1.25;
                                }
                            } else if (mangaka1.getRating().equals("Good")) {
                                if (comic1.getSeries()) {
                                    price = productionCost * 1.45;
                                } else {
                                    price = productionCost * 1.3;
                                }
                            } else if (mangaka1.getRating().equals("Best Seller")) {
                                if (comic1.getSeries()) {
                                    price = productionCost * 1.5;
                                } else {
                                    price = productionCost * 1.4;
                                }
                            }

                            if (price > 0) {
                                if (ratingInput.equals(mangaka1.getRating())) {
                                    booksBelowRange.add(comic1);
                                    rangePublisher.add(publisher);
                                    mangakaBelowRange.add(mangaka1);
                                    System.out.println("Code : " + comic1.getCode());
                                    System.out.println("Title : " + comic1.getTitle());
                                    System.out.println("Author : " + comic1.getAuthor());
                                    System.out.println("Publisher : " + comic1.getPublisher());
                                    System.out.println("Series : " + comic1.getSeries());
                                    System.out.println("Price: " + price);
                                    System.out.println("Rating :" + mangaka1.getRating());
                                    System.out.println();
                                }
                            }


                        }

                    }

                }
            }

        }
    }

    private void displayRangeCountryBook() {
        List<Book> books = bookList.getBooks();
        List<Publisher> publishers = bookList.getPublisher();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input Country: ");
        String countryInput = scanner.nextLine();

        List<Book> booksBelowRange = new ArrayList<>(); // ArrayList untuk menyimpan buku di bawah rangePrice
        List<Publisher> rangePublisher = new ArrayList<>(); //  ArrayList untuk menyimpan production cost buku di bawah rangePrice

        for (Publisher publisher : publishers) {
            for (Book book : books) {
                if (publisher.getName().equals(book.getPublisher())) {
                    double productionCost = publisher.getProductionCost();
                    double price = productionCost * 1.2;
                    booksBelowRange.add(book);
                    rangePublisher.add(publisher);
                    if (countryInput.equals(publisher.getCountry())) {
                        System.out.println("Code : " + book.getCode());
                        System.out.println("Title : " + book.getTitle());
                        System.out.println("Author : " + book.getAuthor());
                        System.out.println("Publisher: " + book.getPublisher());
                        System.out.println(price);
                        System.out.println("Country:" + publisher.getCountry());
                        System.out.println();
                    } else {
                        System.out.println("");
                    }
                }
            }
        }
    }

    private void displayRangeCountryAuthor() {
        List<Book> books = bookList.getBooks();
        List<Publisher> publishers = bookList.getPublisher();
        List<Author> authors = bookList.getAuthor();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input Country: ");
        String countryInput = scanner.nextLine();

        List<Book> booksBelowRange = new ArrayList<>(); // ArrayList untuk menyimpan buku di bawah rangePrice
        List<Publisher> rangePublisher = new ArrayList<>(); //  ArrayList untuk menyimpan production cost buku di bawah rangePrice
        List<Author> authorsBelowRange = new ArrayList<>();
        for (Author author : authors) {
            if (countryInput.equals(author.getCountry())) {
                authorsBelowRange.add(author);
            }
        }

//        Get comic
        for (Author author : authorsBelowRange) {
            String firstName = author.getFirstName();
            String lastName = author.getLastName();
            String name = firstName + lastName;
            for (Book book : books) {
                if (book.getAuthor().equals(name)) {
                    booksBelowRange.add(book);
                }
            }
        }

        for (Author author : authorsBelowRange) {
            for (Book book : booksBelowRange) {
                for (Publisher publisher : publishers) {
                    if (book.getPublisher().equals(publisher.getName())) {
                        rangePublisher.add(publisher);
                        double price = publisher.getProductionCost() * 1.2;
                        System.out.println("Code : " + book.getCode());
                        System.out.println("Title : " + book.getTitle());
                        System.out.println("Author : " + book.getAuthor());
                        System.out.println("Publisher : " + book.getPublisher());
                        System.out.println("Price: " + price);
                        System.out.println("Country :" + author.getCountry());
                        System.out.println();

                    }
                }
            }
        }
    }
}

//    private void displayExpensiveComic() {
//        List<Comic> comics = bookList.getComic();
//        List<Publisher> publishers = bookList.getPublisher();
//        Publisher expensivePublisher = null;
//        double maxPrice = 30;
//        List<Comic> expensiveBooks = new ArrayList<>(); // Daftar untuk menyimpan buku yang harganya di atas maxPrice
//
//        // Mencari buku dengan harga di atas maxPrice berdasarkan harga produksi dari penerbit
//        for (Publisher publisher : publishers) {
//            for (Comic comic : comics) {
//                if (publisher.getName().equals(comic.getPublisher())) {
//                    double productionCost = publisher.getProductionCost();
//                    double price = productionCost * 1.2;
//
//                    if (price > maxPrice) {
//                        expensiveBooks.add(comic); // Menambahkan buku ke daftar buku mahal
//                        expensivePublisher = publisher;
//                    }
//                }
//            }
//        }
//        if (!expensiveBooks.isEmpty()) {
//            for (Comic comic : expensiveBooks) {
//                System.out.println("Code: " + book.getCode());
//                System.out.println("Title: " + book.getTitle());
//                System.out.println("Author: " + book.getAuthor());
//                System.out.println("Publisher: " + book.getPublisher());
//                double productionCost = expensivePublisher.getProductionCost();
//                double price = productionCost * 1.2;
//                System.out.println("Price: " + price);
//                System.out.println();
//            }
//        } else {
//            System.out.println("No book found with price above " + maxPrice);
//        }
//    }
//    }









