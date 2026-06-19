package com.mycompany.account;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mycompany.book.Book;
import com.mycompany.book.Komik;
import com.mycompany.book.Majalah;
import com.mycompany.book.Novel;
import com.mycompany.book.Pendidikan;
import com.mycompany.book.Sejarah;
import com.mycompany.sistem.BookManagement;
import com.mycompany.sistem.Menu;
import com.mycompany.sistem.Pembelian;
import com.mycompany.sistem.Perpustakaan;
import com.mycompany.sistem.ReadBook;

/**
 *
 * @author りおん塩田
 */
@SuppressWarnings({"java:S106", "java:S2068", "java:S3776"})
public class User implements IAccount {

    private final List<Account> userList;
    private final Scanner scanner = new Scanner(System.in);
    private final Menu menu = new Menu();
    private final BookManagement bookManagement = BookManagement.getInstance();
    private final Pembelian pembelian = new Pembelian();
    private final Perpustakaan perpus = new Perpustakaan();
    private final ReadBook readBook = new ReadBook();
    private final DateTimeFormatter format = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy HH:mm:ss");
    
    String username;

    public User() {
        userList = new ArrayList<>();
        userList.add(new Account("User123", "User123"));
        userList.add(new Account("Rinitial", "RintialPassword"));
        userList.add(new Account("AgusKopling", "Agus@RumahBaru"));
    }

    public String getUsername() {
        return username;
    }

    // Untuk keperluan Unit Testing jika dibutuhkan
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean loginValidation() {
        System.out.print("> Username : ");
        username = scanner.nextLine();
        System.out.print("> Password : ");
        String password = scanner.nextLine(); // Dibuat lokal karena tidak dipakai di tempat lain
        System.out.println("(Hint : User123, Rinitial, AgusKopling)");
        
        for (Account user : userList) {
            if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void menuInside(boolean isPasswordValid) {
        if (!isPasswordValid) {
            throw new SecurityException("Username atau Password Salah");
        }

        boolean exit = false;
        menu.headerFooter();
        System.out.println("Selamat Datang!! " + username);
        
        while (!exit) {
            menu.headerFooter();
            menu.menuUser();
            System.out.print("Pilih Menu : ");
            try {
                int pilihan = Integer.parseInt(scanner.nextLine());
                switch (pilihan) {
                    case 1:
                        handleDaftarBuku();
                        break;
                    case 2:
                        handleCariBuku();
                        break;
                    case 3:
                        handleKategoriBuku();
                        break;
                    case 4:
                        handlePerpustakaan();
                        break;
                    case 5:
                        exit = true;
                        break;
                    default:
                        System.out.println("Pilihan Menu Tidak Ada");
                        break;
                }
            } catch (NumberFormatException ex) {
                System.out.println("Error, Masukkan input angka");
            } catch (RuntimeException ex) {
                System.out.println("Terjadi kesalahan: " + ex.getMessage());
            }
        }
    }

    // --- HELPER METHODS UNTUK MEMECAH COGNITIVE COMPLEXITY ---

    private void handleDaftarBuku() {
        menu.headerFooter();
        System.out.println("Daftar Buku");
        menu.FormatBukuPrint();
        bookManagement.printBuku();
        menu.headerFooter();
        menu.menuBeliBuku();
        System.out.print("Pilih Menu : ");
        
        int pilihanSistem = Integer.parseInt(scanner.nextLine());
        if (pilihanSistem == 1) {
            beliBukuDenganInfo();
        } else if (pilihanSistem == 2) {
            beliBukuLangsung();
        } else if (pilihanSistem != 3) {
            System.out.println("Pilihan Menu Tidak tersedia");
        }
    }

    private void beliBukuDenganInfo() {
        menu.headerFooter();
        System.out.println("Lihat Informasi Buku");
        System.out.print("Pilih Buku : ");
        int milihBuku = Integer.parseInt(scanner.nextLine());
        int index = milihBuku - 1;
        
        if (index < 0 || index >= bookManagement.books.size()) {
            System.out.println("Pilihan Buku tidak ada");
            return;
        }
        
        menu.headerFooter();
        bookManagement.books.get(index).printInfoBuku();
        menu.headerFooter();
        System.out.println("Mau Beli Buku?\nIya\nTidak");
        System.out.print("Konfirmasi : ");
        String confirm = scanner.nextLine();
        
        if (confirm.equalsIgnoreCase("Iya")) {
            menu.headerFooter();
            pembelian.beliBuku(index, bookManagement, perpus);
        }
    }

    private void beliBukuLangsung() {
        menu.headerFooter();
        System.out.println("Beli Buku");
        System.out.print("Pilih Buku : ");
        int milihBuku = Integer.parseInt(scanner.nextLine());
        int index = milihBuku - 1;
        
        if (index < 0 || index >= bookManagement.books.size()) {
            System.out.println("Pilihan Buku tidak ada");
            return;
        }
        menu.headerFooter();
        pembelian.beliBuku(index, bookManagement, perpus);
    }

    private void handleCariBuku() {
        System.out.print("Judul buku yang ingin dicari: ");
        String judul = scanner.nextLine();
        int index = bookManagement.cariBuku(judul);
        
        if (index == -1) {
            System.out.println("Buku " + judul + " tidak ditemukan");
            return;
        } 
        
        System.out.println("Buku ditemukan!");
        menu.menuBeliBuku();
        System.out.print("Pilih Menu : ");
        int pilihanSistem = Integer.parseInt(scanner.nextLine());
        
        if (pilihanSistem == 1) {
            menu.headerFooter();
            bookManagement.books.get(index).printInfoBuku();
        } else if (pilihanSistem == 2) {
            menu.headerFooter();
            pembelian.beliBuku(index, bookManagement, perpus);
        } else if (pilihanSistem != 3) {
            System.out.println("Pilihan Menu Tidak tersedia");
        }
    }

    private void handleKategoriBuku() {
        menu.headerFooter();
        System.out.println("Pilih Kategori yang mau ditampilkan");
        menu.menuKategoriBuku();
        System.out.print("Pilih Opsi : ");
        int pilihan = Integer.parseInt(scanner.nextLine());
        menu.headerFooter();

        switch (pilihan) {
            case 1:
                System.out.println("Daftar Buku Pendidikan");
                menu.FormatBukuPrintPendidikan();
                printKategoriBuku(Pendidikan.class);
                break;
            case 2:
                System.out.println("Daftar Buku Sejarah");
                menu.FormatBukuPrint();
                printKategoriBuku(Sejarah.class);
                break;
            case 3:
                System.out.println("Daftar Buku Novel");
                menu.FormatBukuPrint();
                printKategoriBuku(Novel.class);
                break;
            case 4:
                System.out.println("Daftar Buku Komik");
                menu.FormatBukuPrint();
                printKategoriBuku(Komik.class);
                break;
            case 5:
                System.out.println("Daftar Buku Majalah");
                menu.FormatBukuPrint();
                printKategoriBuku(Majalah.class);
                break;
            default:
                System.out.println("Pilihan tidak tersedia");
                break;
        }
    }

    // DRY (Don't Repeat Yourself) - Menghindari perulangan for-loop di setiap case kategori
    private void printKategoriBuku(Class<?> categoryClass) {
        int no = 1;
        for (Book book : bookManagement.books) {
            if (categoryClass.isInstance(book)) {
                if (book instanceof Pendidikan) {
                    Pendidikan p = (Pendidikan) book;
                    System.out.printf("%-4d %s\n", no, p.toString() + p.getNamaBidang());
                } else {
                    System.out.printf("%-4d %s\n", no, book.toString());
                }
                no++;
            }
        }
    }

    private void handlePerpustakaan() {
        menu.menuPerpustakaan();
        System.out.print("Pilih Menu: ");
        int pilihan = Integer.parseInt(scanner.nextLine());
        
        if (pilihan == 1) {
            if (perpus.koleksiBuku.isEmpty()) {
                System.out.println("Belum ada buku yang dimiliki");
                return;
            }
            perpus.printBuku();
            System.out.print("Pilih Buku (1 - " + perpus.koleksiBuku.size() + "): ");
            int milihBuku2 = Integer.parseInt(scanner.nextLine());
            
            if (milihBuku2 < 1 || milihBuku2 > perpus.koleksiBuku.size()) {
                System.out.println("Pilihan buku tidak valid");
                return;
            }
            prosesPilihBukuPerpus(milihBuku2 - 1);
            
        } else if (pilihan == 2) {
            System.out.print("Judul buku yang ingin dicari di perpus: ");
            String title = scanner.nextLine();
            int indeks = perpus.cariBuku(title);
            
            if (indeks == -1) {
                System.out.println("Buku " + title + " tidak ditemukan di perpus anda");
                return;
            }
            prosesPilihBukuPerpus(indeks);
        }
    }

    private void prosesPilihBukuPerpus(int indexBuku) {
        menu.menuPilihBuku();
        System.out.print("Pilih opsi: ");
        int pilihan = Integer.parseInt(scanner.nextLine());
        
        if (pilihan == 1) {
            readBook.bacaBuku();
            menu.menuBacaBuku();
            System.out.print("Pilih Menu : ");
            int pilihanBaca = Integer.parseInt(scanner.nextLine());
            
            if (pilihanBaca == 1) {
                perpus.koleksiBuku.get(indexBuku).printComment();
                System.out.println("Tambahkan komentar...");
                System.out.print("Masukkan nama : ");
                String nama = scanner.nextLine();
                System.out.print("Masukkan komentar : ");
                String comment = scanner.nextLine();
                
                // Bug fix: Dapatkan waktu SEKARANG saat user submit komentar, bukan saat objek user dibuat
                String tanggalSekarang = LocalDateTime.now().format(format);
                perpus.koleksiBuku.get(indexBuku).addComment(nama, comment, tanggalSekarang);
            }
        } else if (pilihan == 2) {
            pembelian.refundBuku(indexBuku, bookManagement, perpus);
        } else if (pilihan != 3) {
            System.out.println("Pilihan Tidak ada");
        }
    }
}