package student;

import java.util.*;
import java.io.*;

public class Student {
    
    int no,mark1,mark2,mark3,mark4,total;
    float per;
    String name;
    Scanner sc = new Scanner(System.in);
    
    Student()
    {
      no = 0;
      mark1 = 0;
      mark2 = 0;
      mark3 = 0;
      mark4 = 0;
      total = 0;
      per = 0;
      name = "";
    }
    
    void swtch() throws IOException
    {
        int ch,sno;
        System.out.println("Enter 1 to enter new student data\nEnter 2 to display data: ");
        ch = sc.nextInt();
        switch (ch)
        {
            case 1:
                System.out.println("Enter student no: ");
                sno = sc.nextInt();
                getdata(sno);
                break;
            case 2:
                System.out.println("Enter student no: ");
                sno = sc.nextInt();
                display(sno);
                break;
            default:System.out.println("Invaid");
        }
    }
    
    void getdata(int sno) throws IOException
    {
        System.out.println("Enter Name:");
        name = sc.nextLine();
        name = sc.nextLine();
        no = sno;
        System.out.println("Enter Java marks:");
        mark1 = sc.nextInt();
        System.out.println("Enter SP marks:");
        mark2 = sc.nextInt();
        System.out.println("Enter ADA marks");
        mark3 = sc.nextInt();
        System.out.println("Enter MI marks:");
        mark4 = sc.nextInt();
        total = mark1+mark2+mark3+mark4;
        per = (total*100)/400;
        File file = new File(no+".txt");
        boolean createFile = file.createNewFile();
        FileWriter fw = new FileWriter(no+".txt");
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("Name is: "+name);
        bw.newLine();
        bw.write("NO. is: "+no);
        bw.newLine();
        bw.write("Java marks is: "+mark1);
        bw.newLine();
        bw.write("SP marks is: "+mark2);
        bw.newLine();
        bw.write("ADA marks is: "+mark3);
        bw.newLine();
        bw.write("MI marks is: "+mark4);
        bw.newLine();
        bw.write("Total marks is: "+total);
        bw.newLine();
        bw.write("Percentage is: "+per);
        bw.close();
        fw.close();
        System.out.println("Data write successfully");
    }
    
    void display(int sno) throws FileNotFoundException, IOException
    {
        int no;
        no=sno;
        FileReader fr = new FileReader(no+".txt");
        BufferedReader br = new BufferedReader(fr);
        int i;
        while((i=br.read())!=-1)
        {
            System.out.print((char)i);
        }
        br.close();
        fr.close();
    }
    
    public static void main(String args[]) throws IOException 
    {
        Scanner sc = new Scanner(System.in);
        int stno;
        System.out.println("Enter no. of operation: ");
        stno = sc.nextInt();
        Student[] st;
        st = new Student[stno];
        for(int i=0;i<stno;i++)
        {
            st[i] = new Student();
            st[i].swtch();
        }
    }
}