package com.BEBuildweek2.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.io.FileReader;
import java.io.BufferedReader;
import static java.lang.Integer.parseInt;

public class ImportCsv {
    public static void main(String[] args) {
        String jdbcUrl="jdbc:postgresql://localhost:5432/public.be_service";
        String username="postgres";
        String password="root";

        String filePath="C:\\Users\\brink\\Documents\\GitHub\\BE-Buildweek-2\\comuni-italiani.csv";
        String filePath2= "C:\\Users\\brink\\Documents\\GitHub\\BE-Buildweek-2\\province-italiane.csv";

        int batchSize=20;

        Connection connection=null;


        try{
            connection= DriverManager.getConnection(jdbcUrl,username,password);
            connection.setAutoCommit(false);

            String sql="insert into be_service_comuni(codiceprovincia,progressivodelcomune,comune,provincia) values(?,?,?,?)";
            String sql2="insert into be_service_province(sigla,provincia,regione) values(?,?,?)";

            PreparedStatement statement=connection.prepareStatement(sql);
            PreparedStatement statement2=connection.prepareStatement(sql2);
            

            BufferedReader lineReader=new BufferedReader(new FileReader(filePath));
            BufferedReader lineReader2=new BufferedReader(new FileReader(filePath2));
            
            String lineText=null;
            int count=0;

            lineReader.readLine();
            lineReader2.readLine();
            while ((lineText=lineReader.readLine())!=null){
                String[] data=lineText.split(";");

                String codiceprovincia=data[0];
                String progressivodelcomune=data[1];
                String comune=data[2];
                String provincia=data[3];

                statement.setString(1,codiceprovincia);
                statement.setString(2,progressivodelcomune);
                statement.setString(3,comune);
                statement.setString(4,provincia);
                statement.addBatch();
                if(count%batchSize==0){
                    statement.executeBatch();
                }
            }
            while ((lineText=lineReader2.readLine())!=null){
                String[] data=lineText.split(";");

                String sigla=data[0];
                String provincia=data[1];
                String regione=data[2];

                statement2.setString(1,sigla);
                statement2.setString(2,provincia);
                statement2.setString(3,regione);
                statement2.addBatch();
                if(count%batchSize==0){
                    statement2.executeBatch();
                }
            }
            lineReader.close();
            statement.executeBatch();
            lineReader2.close();
            statement2.executeBatch();
            connection.commit();
            connection.close();
            System.out.println("Data has been inserted successfully.");

        }
        catch (Exception exception){
            exception.printStackTrace();
        }

    }
}