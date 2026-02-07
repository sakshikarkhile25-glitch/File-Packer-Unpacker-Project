// Unpacking Code

import java.io.*;
import java.util.*;

class program607
{
    public static void main(String A[]) throws Exception
    {
        // Variable Creation
        Scanner sobj = null;
        String FileName = null;

        sobj = new Scanner(System.in);

        System.out.println("Enter the name of Packed file");
        FileName = sobj.nextLine();

        File fpackobj = new File(FileName);

        if(! fpackobj.exists() == false)
        {
            System.out.println("Error : There is no such packed file");
            return;
        }

    }   
}