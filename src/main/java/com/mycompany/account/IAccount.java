/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.account;

/**
 *
 * @author りおん塩田
 */
public interface IAccount {
    public boolean loginValidation();
    public void menuInside(boolean passwordValidation) throws Exception;
}
