package com.dbimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;


public class Generator {

    public static Connection getConnection() throws Exception
    {
        System.out.println("Getting Connected to database...");
        
        String url = "jdbc:postgresql://localhost:5432/dbimpl";
        String username = "postgres";
        String password = "tiktok007";

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);

            System.out.println("Database connection established");
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
		return conn;
    }

    public static void main(String[] args) throws Exception
    {
        Connection conn= Generator.getConnection();
        Generator t=new Generator();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter no. of tables:");
        int tc=sc.nextInt();
        int[] tuplecount=new int[tc];
        String[] tablename=new String[tc];

        for(int i=0;i<tc;i++) {
            System.out.println("Enter table name:");
            tablename[i]=sc.next();
            System.out.println("Enter no. of tuples in the table:");
            tuplecount[i]=sc.nextInt();
        }
        sc.close();

        for(int j=0;j<tc;j++) {
            int maxt=tuplecount[j];

            Statement stmt=null;
            try {
                stmt = conn.createStatement();
                stmt.execute("create table "+tablename[j]+"(unique1 integer NOT NULL CONSTRAINT unique1_check check (unique1 between 0 and "+(maxt-1)+"),unique2 integer NOT NULL PRIMARY KEY CONSTRAINT unique2_check check (unique2 between 0 and "+(maxt-1)+"),two integer NOT NULL CONSTRAINT two_check CHECK (two in (0,1)), four integer NOT NULL CONSTRAINT four_check CHECK (four in (0,1,2,3)), ten integer NOT NULL CONSTRAINT ten_check CHECK (ten between 0 and 9),twenty integer NOT NULL CONSTRAINT twenty_check CHECK (twenty between 0 and 19),onepercent integer NOT NULL CONSTRAINT onepercent_check CHECK (onepercent between 0 and 99),tenpercent integer NOT NULL CONSTRAINT tenpercent_check CHECK (tenpercent between 0 and 9),twentypercent integer NOT NULL CONSTRAINT twentypercent_check CHECK(twentypercent in (0,1,2,3,4)),fiftypercent integer NOT NULL CONSTRAINT fiftypercent_check CHECK(fiftypercent in (0,1)),unique3 integer NOT NULL CONSTRAINT unique3_check check (unique3 between 0 and "+(maxt-1)+"), evenOnePercent integer NOT NULL CONSTRAINT evenOnePercent_check CHECK(evenOnePercent between 0 and 198 and evenOnePercent%2=0),oddOnePercent integer NOT NULL CONSTRAINT oddOnePercent_check CHECK(oddOnePercent between 0 and 199 and oddOnePercent%2!=0),stringu1 char(52) NOT NULL, stringu2 char(52) NOT NULL, string4 char(52) NOT NULL,CONSTRAINT "+tablename[j]+"_unique1 UNIQUE (unique1),CONSTRAINT "+tablename[j]+"_unique2 UNIQUE (unique2),CONSTRAINT "+tablename[j]+"_unique3 UNIQUE (unique3),CONSTRAINT "+tablename[j]+"_stringu1 UNIQUE (stringu1),CONSTRAINT "+tablename[j]+"_stringu2 UNIQUE (stringu2))");

            } catch (SQLException e) {
                e.printStackTrace();
            }

            int[] unique1=new int[maxt];
            int[] unique2=new int[maxt];
            int[] two=new int[maxt];
            int[] four=new int[maxt];
            int[] ten=new int[maxt];
            int[] twenty=new int[maxt];
            int[] onepercent=new int[maxt];
            int[] tenpercent=new int[maxt];
            int[] twentypercent=new int[maxt];
            int[] fiftypercent=new int[maxt];
            int[] unique3=new int[maxt];
            int[] evenOnePercent=new int[maxt];
            int[] oddOnePercent=new int[maxt];
            String[] stringu1=new String[maxt];
            String[] stringu2=new String[maxt];
            String[] string4=new String[maxt];
            int str4count=1;

            ArrayList<Integer> s=new ArrayList<>();
            for(int k=0;k<maxt;k++) {
                s.add(k);
            }
            Collections.shuffle(s);
            for(int i=0;i<maxt;i++) {
                unique1[i]=s.get(i);
                unique2[i]=i;
                two[i]=unique1[i]%2;
                four[i]=unique1[i]%4;
                ten[i]=unique1[i]%10;
                twenty[i]=unique1[i]%20;
                onepercent[i]=unique1[i]%100;
                tenpercent[i]=unique1[i]%10;
                twentypercent[i]=unique1[i]%5;
                fiftypercent[i]=unique1[i]%2;
                unique3[i]=unique1[i];
                evenOnePercent[i]=onepercent[i]*2;
                oddOnePercent[i]=(onepercent[i]*2)+1;
                stringu1[i]=t.generateStringu12(unique1[i]);
                stringu2[i]=t.generateStringu12(unique2[i]);
                string4[i]=t.generateString4(str4count);
                if(str4count==4) {
                    str4count=1;
                }else {
                    str4count++;
                }
                try {
                    stmt.addBatch("insert into "+tablename[j]+" values("+unique1[i]+","+unique2[i]+","+two[i]+","+four[i]+","+ten[i]+","+twenty[i]+","+onepercent[i]+","+tenpercent[i]+","+twentypercent[i]+","+fiftypercent[i]+","+unique3[i]+","+evenOnePercent[i]+","+oddOnePercent[i]+",'"+stringu1[i]+"','"+stringu2[i]+"','"+string4[i]+"')");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            try {
                stmt.executeBatch();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public String generateStringu12(int unique1) {
        char[] result=new char[52];
        for(int k=0;k<52;k++) {
            result[k]='x';
        }
        String stru12="";
        int rem=0;
        for(int i=0;i<7;i++) {
            result[i]='A';
        }
        int i=6;
        char temp[]=new char[7];
        while(unique1>0) {
            rem=unique1%26;
            temp[i]=(char) ('A'+rem);
            unique1=unique1/26;
            i--;
        }
        for(i=i+1;i<=6;i++) {
            result[i]=temp[i];
        }
        stru12=String.copyValueOf(result);
        return stru12;
    }

    public String generateString4(int count) {
        char[] result=new char[52];
        for(int k=0;k<52;k++) {
            result[k]='x';
        }
        String str4="";
        char str1 = 0;

        switch (count) {
            case 1:
                str1='A';
                count++;
                break;

            case 2:
                str1='H';
                count++;
                break;

            case 3:
                str1='O';
                count++;
                break;

            case 4:
                str1='V';
                count=1;
                break;
        }

        for(int z=0;z<4;z++) {
            result[z]=str1;
            str4=String.copyValueOf(result);
        }
        return str4;
    }
    
}
