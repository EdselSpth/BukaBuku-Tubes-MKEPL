/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.book;

/**
 *
 * @author りおん塩田
 */
public class Pendidikan extends Book {
    private String namaBidang;
    private double discountRate = 0.35;

    public Pendidikan(String idBuku,  String judulBuku, String namaBidang, String namaPenulis, String namaPenerbit, int harga, int tahunTerbit, double rating) {
        super( idBuku, judulBuku, namaPenulis, namaPenerbit, harga, tahunTerbit, rating, "Pendidikan", false);
        this.namaBidang = namaBidang;
    }
    
    @Override
    public double harga(){
        return super.getHarga() - (discountRate * super.getHarga());
    }
    
    @Override
    public void printInfoBuku(){
        System.out.println("Judul Buku : " + super.getJudulBuku());
        System.out.println("Nama Penulis : " + super.getNamaPenulis());
        System.out.println("Penerbit : " + super.getNamaPenerbit());
        System.out.println("Kategori : " + super.getKategori());
        System.out.println("Bidang : " + this.namaBidang);
        System.out.println("Rating : " + super.getRating());
        System.out.println("Tahun Terbit : " + super.getTahunTerbit());
        System.out.println("Harga : " + harga());
    }

    public String getNamaBidang() {
        return namaBidang;
    }

    public void setNamaBidang(String namaBidang) {
        this.namaBidang = namaBidang;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }
    
    @Override
    public String toStringAdmin() {
        return String.format("%-10s %-30s %-20s %-20s %-15s %-10.2f %-10.1f", super.getIdBuku(), super.getJudulBuku(), super.getNamaPenulis(), super.getNamaPenerbit(), super.getKategori(), harga(), super.getRating());
    }
    
     @Override
    public String toString() {
        return String.format("%-30s %-20s %-20s %-15s %-10.2f %-10.1f",
                super.getJudulBuku(), super.getNamaPenulis(), super.getNamaPenerbit(), super.getKategori(), harga(), super.getRating());
    }
}
