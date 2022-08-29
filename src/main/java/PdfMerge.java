import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;
import java.io.IOException;

public class PdfMerge {
    public static void main(String[] args) throws IOException{
        File file1 = new File("Pdf/Sample.pdf");
        PDDocument doc1 = PDDocument.load(file1);

        File file2 = new File("Pdf/Sample2.pdf");
        PDDocument doc2 = PDDocument.load(file2);

        File file3 = new File("Pdf/Sample3.pdf");
        PDDocument doc3 = PDDocument.load(file3);

        PDFMergerUtility PdfMerger = new PDFMergerUtility();

        PdfMerger.setDestinationFileName("Pdf/merged.pdf");

        PdfMerger.addSource(file1);
        PdfMerger.addSource(file2);
        PdfMerger.addSource(file3);

        PdfMerger.mergeDocuments();
        System.out.println("Documents have been merged");

        //Closing the documents
        doc1.close();
        doc2.close();
        doc3.close();

    }
}
