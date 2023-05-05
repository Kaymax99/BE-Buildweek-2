package com.BEBuildweek2.runner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import org.apache.ibatis.jdbc.ScriptRunner;

public class OneTimeDBRunner {
   public static void main(String args[]) throws Exception {
      //Getting the connection
      String mysqlUrl = "jdbc:postgresql://localhost:5432/public.be_service";
      Connection con = DriverManager.getConnection(mysqlUrl, "postgres", "Renoir");
      System.out.println("Connection established......");
      //Initialize the script runner
      ScriptRunner sr = new ScriptRunner(con);
      //Creating a reader object
      Reader reader = new BufferedReader(new FileReader("C:\\Users\\alebe\\Desktop\\SQL_BW_2.sql"));
      //Running the script
      sr.runScript(reader);
   }
}
