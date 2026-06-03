/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistem;

import com.mycompany.book.Book;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

/**
 *
 * @author りおん塩田
 */
public class Pembelian {

    protected String idPembelian;
    Perpustakaan perpus = new Perpustakaan();
    BookManagement BM = new BookManagement();
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter format = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy HH:mm:ss");
    String tanggalPembelian = now.format(format);
    String randomID = UUID.randomUUID().toString().substring(0, 12);

    public void beliBuku(int index, BookManagement BM, Perpustakaan perpus) {
        try {
            if (index < BM.books.size() && index >= 0 ) {
                BM.books.get(index).setLicense(true);
                perpus.tambahBuku(index, BM.getBook(index));
                System.out.println("Pembelian E-Book Berhasil");
                System.out.println("Tanggal Pembelian : " + tanggalPembelian);
                System.out.println("ID Pembelian : " + randomID);
                BM.books.get(index).printInfoBuku();
            } else {
                throw new Exception("Buku tidak ditemukan");
            }
        } catch (Exception e) {
            System.out.println("Error :" + e.getMessage());
        }
    }

    public void refundBuku(int index, BookManagement BM, Perpustakaan perpus) {
        try {
            if(index < 0 || index > perpus.koleksiBuku.size()) {
                throw new Exception("Index buku tidak valid!");
            }
            
            boolean bukuKetemu = false;
            Book bukuRefund = perpus.koleksiBuku.get(index);
            
            for(int i = 0; i < BM.books.size(); i++){
                if (bukuRefund.getIdBuku().equals(BM.books.get(i).getIdBuku())){
                    BM.books.get(i).setLicense(false);
                    System.out.println("Refund E-Book Berhasil");
                    System.out.println("Uang dikembalikan sebesar Rp." + BM.books.get(i).harga());
                    perpus.hapusBuku(index);
                    bukuKetemu = true;
                    break;
                } 
            }
            
            if (!bukuKetemu){
                throw new Exception("Buku tidak dapat di refund");
            }
        } catch (Exception e) {
            System.out.println("Error :" + e.getMessage());
        }

    }
}