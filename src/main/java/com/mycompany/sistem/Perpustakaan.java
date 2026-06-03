/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistem;

import com.mycompany.book.Book;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author りおん塩田
 */


public class Perpustakaan {
    public List<Book> koleksiBuku = new ArrayList<>();
    Menu menu = new Menu();
    
    
    public void tambahBuku(int index, Book buku) {
       koleksiBuku.add(buku);
    }
    
    public void hapusBuku(int index) throws Exception {
        if (index >= 0 && index < koleksiBuku.size()) {
            koleksiBuku.remove(index);    
        } else {
            throw new Exception("Buku tidak ditemukan!");
        }
    }
    
    public void printBuku(){
        int no = 1;
        menu.headerFooter();
        System.out.println("Perpustakaan Pengguna");
        if (koleksiBuku.isEmpty()) {
            System.out.println("Tidak Ada E-Book yang sudah anda beli");
        }else {
            menu.FormatBukuPrint();
            for (Book book : koleksiBuku) {
                System.out.printf("%-4d %s\n", no, book);
                no++;
            }
        }
    }
    public int cariBuku(String judul){
        for (int i = 0; i < koleksiBuku.size(); i++) {
            if(koleksiBuku.get(i).getJudulBuku().equalsIgnoreCase(judul)){
                return i;
            }
        }
        return -1;
    }
}
