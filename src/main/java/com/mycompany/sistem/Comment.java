/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistem;

/**
 *
 * @author りおん塩田
 */
public class Comment {
    private String tanggal;
    private String Comment;

    public Comment(String Comment, String tanggal) {
        this.Comment = Comment;
        this.tanggal = tanggal;
    }

    public String getTanggal() {
        return tanggal;
    }

    public String getComment() {
        return Comment;
    }
    
    
}
