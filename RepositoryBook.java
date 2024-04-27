package BookCase;

import java.util.ArrayList;
import java.util.List;

public class RepositoryBook  {
    private List<Book> books;
    private List<Author> authors;
    private List<Novelis> novelis;
    private List<Mangaka> mangaka;
    private List<Publisher> publisher;

    public RepositoryBook() {
        this.books = new ArrayList<>();
        this.authors = new ArrayList<>();
        this.novelis = new ArrayList<>();
        this.mangaka = new ArrayList<>();
        this.publisher = new ArrayList<>();
        addBooks();
        addAuthors();
        addNovelis();
        addMangaka();
        addPublisher();
    }

	private void addBooks() {
        books.add(new Book("001", "Memahami Hamka", "Haidar Musyafa", "Mizan"));
        books.add(new Book("002", "Head First Java: Your Brain on Java - A Learner's Guide", "Bert Bates", "O Reilly Media"));
        books.add(new Book("003", "Java For Dummies", "Barry Burd", "O Reilly Media"));
        books.add(new Book("004", "Flutter For Dummies", "Barry Burd", "O Reilly Media"));
        books.add(new Book("005", "The Subtle Art of Not Giving", "Mark Manson", "Harper One"));
        books.add(new Book("006", "Will", "Mark Manson", "Harper One"));
        books.add(new Book("007", "Sejarah Indonesia", "Andi Susanto", "Gramedia Pustaka Utama"));
        books.add(new Book("008", "Teknologi Baru", "Adi Sutanto", "Elex Media Kompuntindo"));
        
    }
    private void addAuthors() {
        // Tambahkan penulis ke dalam daftar
        authors.add(new Author("Haidar ", "Musyafa","Indonesia", 30));
        authors.add(new Author("Bert ", "Bates", "United State", 50));
        authors.add(new Author("Barry ", "Burd", "United State", 52));
        authors.add(new Author("Mark ", "Manson", "United State", 38));
        authors.add(new Author("Andi ", "Susanto", "Indonesia", 32));
        authors.add(new Author("Adi ", "Sutanto", "Indonesia", 27));
    }
    private void addNovelis() {
        // Tambahkan novelis ke dalam daftar
        novelis.add(new Novelis("J.K ", "Rowling", "England", 57, true, "Best Seller"));
        novelis.add(new Novelis("Tere ", "Liye", "Indonesia", 35, true, "Best Seller"));
        novelis.add(new Novelis("Dee ", "Lestari", "Indonesia", 30, true, "Good"));
        novelis.add(new Novelis("Faisal ", "Syahreza", "Indonesia", 40, true, "New Commer"));
        novelis.add(new Novelis("Julia ", "Golding", "England", 41, false, "Best Seller"));
    }
    private void addMangaka() {
        // Tambahkan mangaka ke dalam daftar
        mangaka.add(new Mangaka("Masashi ", "Kisimoto", "Japan", 48, "Best Seller"));
        mangaka.add(new Mangaka("Yoshihiro ", "Togashi", "Japan", 56, "Good"));
        mangaka.add(new Mangaka("Eiichiro ", "Oda", "Japan", 57, "Best Seller"));
        mangaka.add(new Mangaka("Rizki ", "Anwar", "Indonesia", 25, "New Commer"));
        mangaka.add(new Mangaka("Yusuf ", "Fadli", "Indonesia", 32, "New Commer"));
    }
    private void addPublisher() {
        // Tambahkan penerbit ke dalam daftar
        publisher.add(new Publisher("Bloomsbury", "United Kingdom", 30.0));
        publisher.add(new Publisher("Gramedia", "Indonesia", 50.0));
        publisher.add(new Publisher("Mizan", "Indonesia", 25.0));
        publisher.add(new Publisher("Shueisha", "Japan", 25.0));
        publisher.add(new Publisher("Elex Media Komputindo", "Indonesia", 12.0));
        publisher.add(new Publisher("Gramedia Pustaka Utama", "Indonesia", 15.0));
        publisher.add(new Publisher("Lion Hudson", "England", 15.0));
        publisher.add(new Publisher("O Reilly Media", "United State", 30.0));
        publisher.add(new Publisher("Harper One", "United State", 25.0));
    }

    public List<Book> getBooks() {
        return books;
    }
    public List<Author> getAuthor(){
    	return authors;
    }
    public List<Novelis> getNovelis(){
    	return novelis;
    }
    public List<Mangaka> getMangaka(){
    	return mangaka;
    }
    public List<Publisher> getPublisher(){
    	return publisher;
    }
}

