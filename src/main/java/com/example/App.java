package com.example;

import java.io.File;
import java.io.FileInputStream;
import  java.io.FileOutputStream;

import org.apache.poi.xwpf.usermodel.XWPFDocument;

import fr.opensagres.poi.xwpf.converter.pdf.PdfConverter;
import fr.opensagres.poi.xwpf.converter.pdf.PdfOptions;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
            // File curDir = new File("./uploads");
            // getAllFiles(curDir);
            String fileName = "demo.docx".replace(".docx", "");
            FileInputStream docFile = new FileInputStream(new File("./uploads/" + fileName + ".docx"));
            XWPFDocument doc = new XWPFDocument(docFile);
            PdfOptions pdfOptions = PdfOptions.create();

            FileOutputStream out = new FileOutputStream(new File("./uploads/" + fileName + ".pdf"));
            PdfConverter.getInstance().convert(doc, out, pdfOptions);
            doc.close();
            out.close();
        }
        catch(Exception C) {
            C.printStackTrace();
        }
    }
    private static void getAllFiles(File curDir) {

        File[] filesList = curDir.listFiles();
        for(File f : filesList){
            if(f.isDirectory())
                getAllFiles(f);
            if(f.isFile()){
                System.out.println(f.getName());
            }
        }
    }

}
