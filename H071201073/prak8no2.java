import java.util.Scanner;
import java.io.*;

public class prak8no2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner dhian = new Scanner(System.in);
        FileWriter fileWrite = null;
        PrintWriter printWrite = null;
        FileReader fileRead = null;
        BufferedReader buffRead = null;

        try {
            String firstFile = dhian.next();
            String secondFile = dhian.next();
            dhian.close();
            fileRead = new FileReader(String.format("%s.txt", firstFile));
            buffRead = new BufferedReader(fileRead);
            fileWrite = new FileWriter(String.format("%s.txt", secondFile));
            printWrite = new PrintWriter(fileWrite);

            String test;

            int max = 0;
            while ((test = buffRead.readLine()) != null) {
                max = test.length() > max ? test.length() : max;
            }
            fileRead = new FileReader(String.format("%s.txt", firstFile));
            buffRead = new BufferedReader(fileRead);

            String test1;

            while ((test1 = buffRead.readLine()) != null) {
                printWrite.write(String.format("%" + max + "s\n", test1));
            }

        } catch (IOException ioe) {
            System.out.println("Gagal");
        } finally {
            try {
                if (fileWrite != null) {
                    System.out.println("Berhasil");
                    fileWrite.close();
                }
                if (fileRead != null) {
                    fileRead.close();
                }
            } catch (IOException ioe) {
                System.out.println(ioe.getMessage());
            }
        }
    }
}
