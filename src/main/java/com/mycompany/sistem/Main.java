/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.sistem;

import java.util.Scanner;
import com.mycompany.account.*;
import java.util.InputMismatchException;

/**
 *
 * @author りおん塩田
 */
public class Main {

    public static void main(String[] args) {
        Menu menu = new Menu();
        BookManagement bm = new BookManagement();
        Admin admin = new Admin();
        User user = new User();
        Scanner s = new Scanner(System.in);
        menu.AplicationName();
        boolean valid = false;
        boolean exit = false;
        while (!exit) {
            try {
                menu.LoginMenu();
                System.out.print("Pilih opsi : ");
                int opsi = s.nextInt();
                s.nextLine();
                menu.headerFooter();
                switch (opsi) {
                    case 1:
                        admin.menuInside(admin.loginValidation());
                        break;
                    case 2:
                        user.menuInside(user.loginValidation());
                        break;
                    case 3:
                        System.out.println("Terima kasih telah menggunakan aplikasi ini!");
                        s.close();
                        exit = true;
                        break;
                    default:
                        System.out.println("Opsi tidak valid!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input tidak valid! Mohon masukkan angka yang benar.");
                s.nextLine();
            }catch (Exception e) {
                System.out.println("Error : " + e.getMessage());
            }
        }

    }
}
