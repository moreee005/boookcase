// AuthorMenu.java
package BookCase;
import java.util.Scanner;
//AuthorMenu.java
public class AuthorMenu implements AbstractMenu {
 @Override
 public void showMenu() {
	 Scanner scanner = new Scanner(System.in);
     System.out.println("\nMenu Pencarian Penulis");
     System.out.println("1. Cari Data semua Mangaka.");
     System.out.println("2. Cari Data semua Penulis.");
     System.out.println("3. Cari Data semua Novelis.");
     System.out.println("4. Cari penulis berdasarkan Rentang umur.");
     System.out.println("5. Cari penulis berdasarkan Negara.");
     System.out.println("0. Kembali ke Menu Utama");
     System.out.print("Pilih opsi: ");
     int option = scanner.nextInt();
     switch (option) {
         
         default:
             System.out.println("Opsi tidak valid!");
             showMenu();
     
     
 }
}
}