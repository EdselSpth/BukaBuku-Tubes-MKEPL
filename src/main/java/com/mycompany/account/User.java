/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.account;

import java.util.ArrayList;
import java.util.Scanner;
import com.mycompany.sistem.Menu;
import com.mycompany.sistem.BookManagement;
import com.mycompany.sistem.Pembelian;
import com.mycompany.sistem.Perpustakaan;
import com.mycompany.sistem.ReadBook;
import com.mycompany.book.Book;
import com.mycompany.book.Komik;
import com.mycompany.book.Majalah;
import com.mycompany.book.Novel;
import com.mycompany.book.Pendidikan;
import com.mycompany.book.Sejarah;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;

/**
 *
 * @author りおん塩田
 */
public class User implements IAccount {

    private ArrayList<Account> userList;
    Scanner S = new Scanner(System.in);
    Menu menu = new Menu();
    boolean passwordValidation = false;
    BookManagement BM = BookManagement.getInstance();
    Pembelian P = new Pembelian();
    Perpustakaan perpus = new Perpustakaan();
    ReadBook RB = new ReadBook();
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter format = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy HH:mm:ss");
    String tanggal = now.format(format);
    String username, password;

    public User() {
        userList = new ArrayList<>();
        userList.add(new Account("User123", "User123"));
        userList.add(new Account("Rinitial", "RintialPassword"));
        userList.add(new Account("AgusKopling", "Agus@RumahBaru"));
    }

    @Override
    public boolean loginValidation() {
        System.out.print("> Username : ");
        username = S.nextLine();
        System.out.print("> Password : ");
        password = S.nextLine();
        for (int i = 0; i < userList.size(); i++) {
            if (username.equals(userList.get(i).getUsername()) && password.equals(userList.get(i).getPassword())) {
                passwordValidation = true;
                return true;
            }
        }
        return false;
    }

    @Override
    public void menuInside(boolean passwordValidation) throws Exception {
        try {
            if (passwordValidation) {
                int pilihan = 0;
                boolean exit = false;
                int i, index = 99999, milihBuku = 999;
                menu.headerFooter();
                System.out.println("Selamat Datang!! " + username);
                while (!exit) {
                    menu.headerFooter();
                    menu.menuUser();
                    System.out.print("Pilih Menu : ");
                    try {
                        pilihan = S.nextInt();
                        S.nextLine();
                        switch (pilihan) {
                            case 1:
                                menu.headerFooter();
                                System.out.println("Daftar Buku");
                                menu.FormatBukuPrint();
                                BM.printBuku();
                                menu.headerFooter();
                                menu.menuBeliBuku();
                                System.out.print("Pilih Menu : ");
                                int pilihanSistem = S.nextInt();
                                S.nextLine();
                                switch (pilihanSistem) {
                                    case 1:
                                        menu.headerFooter();
                                        System.out.println("Lihat Informasi Buku");
                                        System.out.print("Pilih Buku : ");
                                        milihBuku = S.nextInt();
                                        S.nextLine();
                                        index = milihBuku - 1;
                                        if (index < 0 || index >= BM.books.size()) {
                                            System.out.println("Pilihan Buku tidak ada");
                                            break;
                                        }
                                        menu.headerFooter();
                                        BM.books.get(index).printInfoBuku();
                                        menu.headerFooter();
                                        System.out.println("Mau Beli Buku?");
                                        System.out.println("Iya");
                                        System.out.println("Tidak");
                                        System.out.print("Konfirmasi : ");
                                        String confirm = S.nextLine();
                                        if (confirm.equalsIgnoreCase("Iya") || confirm.equalsIgnoreCase("iya")) {
                                            menu.headerFooter();
                                            P.beliBuku(index, BM, perpus);
                                            break;
                                        } else {
                                            break;
                                        }
                                    case 2:
                                        menu.headerFooter();
                                        System.out.println("Beli Buku");
                                        System.out.print("Pilih Buku : ");
                                        milihBuku = S.nextInt();
                                        index = milihBuku - 1;
                                        if (index < 0 || index >= BM.books.size()) {
                                            System.out.println("Pilihan Buku tidak ada");
                                            break;
                                        }
                                        menu.headerFooter();
                                        P.beliBuku(index, BM, perpus);
                                        break;
                                    case 3:
                                        break;
                                    default:
                                        System.out.println("Pilihan Menu Tidak tersedia");
                                }
                                break;
                            case 2:
                                System.out.print("Judul buku yang ingin dicari: ");
                                String judul = S.nextLine();
                                index = BM.cariBuku(judul);
                                if (index == -1) {
                                    System.out.println("Buku " + judul + " tidak ditemukan");
                                    break;
                                } else {
                                    System.out.println("Buku ditemukan!");
                                }
                                menu.menuBeliBuku();
                                System.out.print("Pilih Menu : ");
                                pilihanSistem = S.nextInt();
                                S.nextLine();
                                switch (pilihanSistem) {
                                    case 1:
                                        menu.headerFooter();
                                        BM.books.get(index).printInfoBuku();
                                        break;
                                    case 2:
                                        menu.headerFooter();
                                        P.beliBuku(index, BM, perpus);
                                        break;
                                    case 3:
                                        break;
                                    default:
                                        System.out.println("Pilihan Menu Tidak tersedia");
                                }
                                break;
                            case 3:
                                menu.headerFooter();
                                System.out.println("Pilih Kategori yang mau ditampilkan");
                                menu.menuKategoriBuku();
                                System.out.print("Pilih Opsi : ");
                                int pilihanc3 = S.nextInt();
                                menu.headerFooter();
                                switch (pilihanc3) {
                                    case 1:
                                        System.out.println("Daftar Buku Pendidikan");
                                        menu.FormatBukuPrintPendidikan();
                                        int no = 1;

                                        for (Book book : BM.books) {
                                            if (book instanceof Pendidikan) {
                                                Pendidikan p = (Pendidikan) book;
                                                System.out.printf("%-4d %s\n", no, p.toString() + p.getNamaBidang());
                                                no++;
                                            }
                                        }
                                        break;
                                    case 2:
                                        System.out.println("Daftar Buku Sejarah");
                                        menu.FormatBukuPrint();
                                        no = 1;
                                        for (Book book : BM.books) {
                                            if (book instanceof Sejarah) {
                                                Sejarah s = (Sejarah) book;
                                                System.out.printf("%-4d %s\n", no, s.toString());
                                                no++;
                                            }
                                        }
                                        break;
                                    case 3:
                                        System.out.println("Daftar Buku Novel");
                                        menu.FormatBukuPrint();
                                        no = 1;
                                        for (Book book : BM.books) {
                                            if (book instanceof Novel) {
                                                Novel n = (Novel) book;
                                                System.out.printf("%-4d %s\n", no, n.toString());
                                                no++;
                                            }
                                        }
                                        break;
                                    case 4:
                                        System.out.println("Daftar Buku Komik");
                                        menu.FormatBukuPrint();
                                        no = 1;
                                        for (Book book : BM.books) {
                                            if (book instanceof Komik) {
                                                Komik k = (Komik) book;
                                                System.out.printf("%-4d %s\n", no, k.toString());
                                                no++;
                                            }
                                        }
                                        break;
                                    case 5:
                                        System.out.println("Daftar Buku Majalah");
                                        menu.FormatBukuPrint();
                                        no = 1;
                                        for (Book book : BM.books) {
                                            if (book instanceof Majalah) {
                                                Majalah m = (Majalah) book;
                                                System.out.printf("%-4d %s\n", no, m.toString());
                                                no++;
                                            }
                                        }
                                        break;
                                    default:
                                        System.out.println("Pilihan tidak tersedia");
                                        break;
                                }
                                break;
                            case 4:
                                menu.menuPerpustakaan();
                                System.out.print("Pilih Menu: ");
                                pilihan = S.nextInt();
                                S.nextLine();
                                switch (pilihan) {
                                    case 1:
                                        if (!perpus.koleksiBuku.isEmpty()) {
                                            perpus.printBuku();
                                            System.out.print("Pilih Buku (1 - " + perpus.koleksiBuku.size() + "): ");
                                            int milihBuku2 = S.nextInt();

                                            if (milihBuku2 < 1 || milihBuku2 > perpus.koleksiBuku.size()) {
                                                System.out.println("Pilihan buku tidak valid");
                                                break;
                                            }

                                            menu.menuPilihBuku();
                                            System.out.print("Pilih Menu : ");
                                            int pilihanc4 = S.nextInt();

                                            switch (pilihanc4) {
                                                case 1:
                                                    RB.bacaBuku();
                                                    menu.menuBacaBuku();
                                                    System.out.print("Pilih Menu : ");
                                                    int pilihanc41 = S.nextInt();
                                                    S.nextLine();
                                                    if (pilihanc41 == 1) {
                                                        perpus.koleksiBuku.get(milihBuku2 - 1).printComment();
                                                        System.out.println("Tambahkan komentar...");
                                                        System.out.print("Masukkan nama : ");
                                                        String nama = S.nextLine();
                                                        System.out.print("Masukkan komentar : ");
                                                        String comment = S.nextLine();
                                                        perpus.koleksiBuku.get(milihBuku2 - 1).addComment(nama, comment, tanggal);
                                                    } else if (pilihanc41 == 2) {
                                                        break;
                                                    } else {
                                                        System.out.println("Pilihan tidak tersedia");
                                                    }
                                                    break;
                                                case 2:
                                                    P.refundBuku(milihBuku2 - 1, BM, perpus);
                                                    break;
                                                case 3:
                                                    break;
                                                default:
                                                    System.out.println("Pilihan tidak tersedia");
                                            }
                                        } else {
                                            System.out.println("Belum ada buku yang dimiliki");
                                        }
                                        break;
                                    case 2:
                                        System.out.print("Judul buku yang ingin dicari di perpus: ");
                                        String title = S.nextLine();
                                        int indeks = perpus.cariBuku(title);
                                        if (indeks == -1) {
                                            System.out.println("Buku " + title + " tidak ditemukan di perpus anda");
                                            break;
                                        }
                                        menu.menuPilihBuku();
                                        System.out.print("Pilih opsi: ");
                                        pilihanSistem = S.nextInt();
                                        switch (pilihanSistem) {
                                            case 1:
                                                RB.bacaBuku();
                                                menu.menuBacaBuku();
                                                System.out.print("Pilih Menu : ");
                                                int pilihanc41 = S.nextInt();
                                                if (pilihanc41 == 1) {
                                                    break;
                                                } else {
                                                    System.out.println("Pilihan tidak tersedia");
                                                }
                                                break;
                                            case 2:
                                                P.refundBuku(indeks, BM, perpus);
                                                break;
                                            case 3:
                                                break;
                                            default:
                                                System.out.println("Pilihan Tidak ada");
                                        }
                                        break;
                                    case 3:
                                        break;
                                }

                                break;
                            case 5:
                                exit = true;
                                break;
                            default:
                                System.out.println("Pilihan Menu Tidak Ada");
                                break;
                        }
                    } catch (InputMismatchException ex){
                        System.out.println("Error, Masukkan input angka");
                        S.nextLine();
                    }
                }
            } else {
                throw new Exception("Username atau Password Salah");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
