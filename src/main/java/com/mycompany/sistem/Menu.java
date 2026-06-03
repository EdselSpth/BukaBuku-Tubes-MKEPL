/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistem;

/**
 *
 * @author りおん塩田
 */
public class Menu {
    public void LoginMenu(){
        headerFooter();
        System.out.println("Pilih Menu Pengguna");
        System.out.println("1. Admin");
        System.out.println("2. Pengguna");
        System.out.println("3. Keluar");
    }
    
    public void AplicationName(){
        headerFooter();
        System.out.println("                  BukaBuku");
        System.out.println("               E-Book Platform");
        System.out.println("         Made by BukaBuku Corporation");
    }
    
    public void headerFooter(){
        System.out.println("===================================================");
    }
    
    public void menuAdmin(){
        headerFooter();
        System.out.println("Menu Admin");
        System.out.println("1. Tambah Data Buku"); 
        System.out.println("2. Hapus Data Buku");
        System.out.println("3. Edit Data Buku");
        System.out.println("4. Kembali");
    }
    
    public void menuUser(){
        System.out.println("Menu User");
        System.out.println("1. Daftar E-Book");
        System.out.println("2. Cari E-Book");
        System.out.println("3. Tampilkan E-Book berdasarkan kategori");
        System.out.println("4. Perpustakaan Pengguna");
        System.out.println("5. Kembali");
    }
    
    public void menuPilihBuku(){
        headerFooter();
        System.out.println("Pilih Menu Buku");
        System.out.println("1. Baca Buku");
        System.out.println("2. Refund Buku");
        System.out.println("3. Kembali ke menu");
    }
    
    public void menuBacaBuku(){
        headerFooter();
        System.out.println("Pilih Opsi");
        System.out.println("1. Komentar");
        System.out.println("2. Kembali ke menu");
    }
    
    public void FormatBukuPrint() {
        System.out.printf("%-4s %-30s %-20s %-20s %-15s %-10s %-10s\n","No", "Judul Buku", "Penulis Buku", "Penerbit", "Kategori", "Harga", "Rating");
    }
    
    public void FormatBukuPrintPendidikan() {
        System.out.printf("%-4s %-30s %-20s %-20s %-15s %-10s %-10s %-10s\n","No", "Judul Buku", "Penulis Buku", "Penerbit", "Kategori", "Harga", "Rating", "Bidang");
    }
    
    
    public void FormatBukuPrintAdmin() {
        System.out.printf("%-4s %-10s %-30s %-20s %-20s %-15s %-10s %-10s\n",
                      "No", "ID Buku", "Judul Buku", "Penulis Buku", "Penerbit", "Kategori", "Harga", "Rating");
    }
    
    public void menuKategoriBuku(){
        System.out.println("1. Pendidikan"); 
        System.out.println("2. Sejarah");
        System.out.println("3. Novel");
        System.out.println("4. Komik");
        System.out.println("5. Majalah");
    }
    
    public void pilihanEditBukuPendidikan(){
        this.headerFooter();
        System.out.println("Pilih Opsi Edit");
        System.out.println("1. Judul");
        System.out.println("2. Penulis");
        System.out.println("3. Penerbit");
        System.out.println("4. Kategori");
        System.out.println("5. Harga");
        System.out.println("6. Tahun Terbit");
        System.out.println("7. Rating");
        System.out.println("8. Kembali");
    }
    
    public void menuBeliBuku(){
        System.out.println("Mau Lakukan Apa?");
        System.out.println("1. Lihat Informasi Buku");
        System.out.println("2. Beli Buku");
        System.out.println("3. Kembali ke menu");
    }
    
    public void menuPerpustakaan(){
        this.headerFooter();
        System.out.println("Menu Perpustakaan");
        System.out.println("1. Tampilkan seluruh buku");
        System.out.println("2. Cari buku");
        System.out.println("3. Kembali");
    }
}
