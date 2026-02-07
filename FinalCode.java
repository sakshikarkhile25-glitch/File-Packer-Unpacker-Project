// Unpacking Final Code

import java.io.*;
import java.util.*;

//////////////////////////////////////////////////////////
//
//  Function Name :     UnpackFile
//  Description   :     This function reads a packed file,
//                      extracts header information such as
//                      original file name and file size,
//                      decrypts the packed data using XOR
//                      operation, and recreates the original
//                      files on disk.
//  Input         :     Packed file name from user
//  Output        :     Restored original files
//  Author        :     Sakshi Damodar Karkhile
//  Date          :     05/02/2026
//
//////////////////////////////////////////////////////////

class program614
{
    public static void main(String A[]) throws Exception
    {
        // Variable creation
        int FileSize = 0;
        int i = 0;
        int iRet = 0;

        byte Key = 0x11;

        Scanner sobj = null;
        String FileName = null;
        String Header = null;
        String Tokens[] = null;

        File fpackobj = null;
        File fobj = null;
    
        FileInputStream fiobj = null;
        FileOutputStream foobj = null;
    
        byte bHeader[] = new byte[100];
        byte Buffer[] = null;

        sobj = new Scanner(System.in);
        
        System.out.println("Enter the name of packed file : ");
        FileName = sobj.nextLine();

        fpackobj = new File(FileName);

        if(fpackobj.exists() == false)
        {
            System.out.println("Error : There is no such packed file");
            return;
        }
        
        fiobj = new FileInputStream(fpackobj);

        // Read the header
        while((iRet = fiobj.read(bHeader,0,100)) != -1)
        {
            Header = new String(bHeader);

            Header = Header.trim();

            Tokens = Header.split(" ");

            System.out.println("File name : "+Tokens[0]);
            System.out.println("File size : "+Tokens[1]);
            
            fobj = new File(Tokens[0]);

            fobj.createNewFile();

            foobj = new FileOutputStream(fobj);

            FileSize = Integer.parseInt(Tokens[1]);

            // Buffer for reading the data
            Buffer = new byte[FileSize];

            // Read from packed file
            fiobj.read(Buffer,0,FileSize);

            // Decrypt the data
            for(i = 0; i < FileSize ; i++)
            {
                Buffer[i] = (byte)(Buffer[i] ^ Key);
            }

            // Write into extracted file
            foobj.write(Buffer,0,FileSize);
        }
    }

}
