package BookCase;

import java.util.Scanner;

public class MainMenu implements AbstractMenu {
	public static void main(String[] args) {
        AbstractMenu mainMenu = new MainMenu();
        mainMenu.showMenu();
    }
    @Override
    
    public void showMenu() {
    	
        Scanner scanner = new Scanner(System.in);

        System.out.println("Menu Utama");
        System.out.println("1. Buku");
        System.out.println("2. Penulis");
        System.out.println("3. Penerbit");
        System.out.println("0. Keluar");
        System.out.print("Pilih opsi: ");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                new BookMenu().showMenu();
                break;
            case 2:
                new AuthorMenu().showMenu(); // Menghubungkan ke AuthorMenu
                break;
            case 3:
                new PublisherMenu().showMenu();
                break;
            case 0:
                System.out.println("Keluar...");
                System.exit(0);
            default:
                System.out.println("Opsi tidak valid!");
                showMenu();
        }
    }
}
