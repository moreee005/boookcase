// PublisherMenu.java
package BookCase;

//PublisherMenu.java
public class PublisherMenu implements AbstractMenu {
 @Override
 public void showMenu() {
     System.out.println("\nMenu Pencarian Penerbit");
     System.out.println("1. Cari Penerbit dengan productionCost paling Mahal.");
     System.out.println("2. Cari Penerbit dengan productionCost paling Murah.");
     System.out.println("0. Kembali ke Menu Utama");
     System.out.print("Pilih opsi: ");
     // Tambahkan logika pemrosesan pilihan menu untuk Penerbit
 }
}
