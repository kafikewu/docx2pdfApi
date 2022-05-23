package com.example.converter;

import java.io.File;
import java.io.FileInputStream;
import  java.io.FileOutputStream;

import org.apache.poi.xwpf.usermodel.XWPFDocument;

import fr.opensagres.poi.xwpf.converter.pdf.PdfConverter;
import fr.opensagres.poi.xwpf.converter.pdf.PdfOptions;

public class docx2pdf {
    public static String convert( String fileName )
    {
        try {
            fileName = fileName.replace(".docx", "");
            FileInputStream docFile = new FileInputStream(new File("./uploads/" + fileName + ".docx"));
            XWPFDocument doc = new XWPFDocument(docFile);
            PdfOptions pdfOptions = PdfOptions.create();

            FileOutputStream out = new FileOutputStream(new File("./uploads/" + fileName + ".pdf"));
            PdfConverter.getInstance().convert(doc, out, pdfOptions);
            doc.close();
            out.close();
            return fileName + ".pdf";
        }
        catch(Exception C) {
            C.printStackTrace();
            return null;
        }
    }
}
