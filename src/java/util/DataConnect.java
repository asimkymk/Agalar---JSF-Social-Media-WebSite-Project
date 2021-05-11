/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author asimk
 */
import java.sql.Connection;
import java.sql.DriverManager;

public class DataConnect {

	public static Connection getConnection() {
		try {
			
			Connection con = DriverManager.getConnection(
					"jdbc:derby://localhost:1527/agalar", "agalar", "agalar123");
                        System.out.println("ok");
			return con;
		} catch (Exception ex) {
			System.out.println("Database.getConnection() Hatası =" + ex.getMessage());
			return null;
		}
	}

	public static void close(Connection con) {
		try {
			con.close();
		} catch (Exception ex) {
		}
	}
}