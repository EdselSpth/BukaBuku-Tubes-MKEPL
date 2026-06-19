package com.mycompany.account;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mycompany.sistem.BookManagement;
import com.mycompany.sistem.Menu;

/**
 *
 * @author りおん塩田
 */


public class Admin implements IAccount {

    private final Menu menu = new Menu();
    private final List<Account> adminList;
    private final Scanner scanner = new Scanner(System.in);
    private final BookManagement bookManagement = BookManagement.getInstance();
    
    private String username;

    public Admin() {
        adminList = new ArrayList<>();
        adminList.add(new Account("Admin123", "Admin123"));
        adminList.add(new Account("SelametKopling", "MenyalaKoplingku"));
        adminList.add(new Account("Kobo1212", "Kobo123"));
    }

    @Override
    public boolean loginValidation() {
        System.out.print("> Username : ");
        username = scanner.nextLine();
        System.out.print("> Password : ");
        System.out.println("(Hint : Admin123, SelametKopling, Kobo1212)");
        System.out.print("> ");
        String password = scanner.nextLine();

        // Menggunakan Enhanced For-Loop yang lebih clean
        for (Account admin : adminList) {
            if (username.equals(admin.getUsername()) && password.equals(admin.getPassword())) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param isPasswordValid
     */
    @Override
    public void menuInside(boolean isPasswordValid) {
        if (!isPasswordValid) {
            // Gunakan exception spesifik, bukan generic Exception
            throw new SecurityException("Username atau Password Salah");
        }

        menu.headerFooter();
        System.out.println("Selamat Datang!! " + username);
        boolean exit = false;
        
        while (!exit) {
            menu.menuAdmin();
            System.out.print("Pilih Menu : ");
            try {
                // Menggunakan parseInt untuk menghindari bug buffer newline dari nextInt()
                int pilihan = Integer.parseInt(scanner.nextLine());
                
                switch (pilihan) {
                    case 1 -> {
                        menu.headerFooter();
                        System.out.println("Menu Tambah Buku");
                        try {
                            bookManagement.tambahDataBuku();
                        } catch (Exception ex) {
                            System.out.println("Error: " + ex.getMessage());
                        }
                    }
                    case 2 -> {
                        menu.headerFooter();
                        System.out.println("Menu Hapus Buku");
                        bookManagement.hapusDataBuku();
                    }
                    case 3 -> {
                        menu.headerFooter();
                        System.out.println("Menu Edit Buku");
                        try {
                            bookManagement.editDataBuku(bookManagement);
                        } catch (Exception ex) {
                            System.out.println("Error: " + ex.getMessage());
                        }
                    }
                    case 4 -> exit = true;
                    default -> System.out.println("Masukkan tidak valid");
                }
            } catch (NumberFormatException ex) {
                // Menangkap spesifik input string dari parseInt
                System.out.println("Error, Harap Masukkan Input Angka");
            } catch (RuntimeException ex) {
                // Menangkap error runtime lainnya agar program tidak langsung crash
                System.out.println("Terjadi kesalahan: " + ex.getMessage());
            }
        }
    }
}