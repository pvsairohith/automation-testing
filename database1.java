package Testcases;
import java.util.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import static org.testng.AssertJUnit.assertEquals;
import org.openqa.selenium.WebDriver;

public class database1 {
	static Connection con = null;
private static Statement stmt;
private static PreparedStatement ps;
public static String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";

public static String DB_USER = "system";

public static String DB_PASSWORD = "root";
	  
	@BeforeTest
	public void setUp() throws Exception{
				try {
			String dbclass = "oracle.jdbc.driver.OracleDriver";
			Class.forName(dbclass).newInstance();
			Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			stmt = con.createStatement();
		}
		catch (Exception e)
		{
		e.printStackTrace();
		}
		
	}
	@Test(priority = 100)
	public void test1() throws SQLException
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("enter no of items");
		int n = sc.nextInt();
		for(int i=0;i<n;i++)
		{
		System.out.println("enter id");
		int id = sc.nextInt();
		System.out.println("enter item");
		String item = sc.next();
		System.out.println("enter cost");
		int cost = sc.nextInt();
		
		String query = "insert into sales values("+id+",'"+item+"',"+cost+")";
		stmt.executeQuery(query);
		}
		ResultSet rs = stmt.executeQuery("select * from sales");
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+""+rs.getString(2)+""+rs.getInt(3));
		}
		System.out.println("total");
		ResultSet rs1 = stmt.executeQuery("select sum(cost) from sales");
		while(rs1.next())
		{
			System.out.println(rs1.getInt(1));
		}
		stmt.executeQuery("truncate table sales");
				
	}
	
	}





































































































