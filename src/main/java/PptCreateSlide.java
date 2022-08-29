import org.apache.poi.xslf.usermodel.*;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class PptCreateSlide {
    public static void main(String args[]) throws IOException{
        XMLSlideShow ppt = new XMLSlideShow();

        XSLFSlideMaster slideMaster = ppt.getSlideMasters().get(0);

        XSLFSlideLayout slideLayout = slideMaster.getLayout(SlideLayout.TITLE_AND_CONTENT);

        XSLFSlide slide = ppt.createSlide(slideLayout);

        XSLFTextShape title = slide.getPlaceholder(0);

        title.setText("introduction");

        XSLFTextShape body = slide.getPlaceholder(1);

        body.clearText();

        String page = "https://en.wikipedia.org/wiki/Lists_of_countries_and_territories";
        //Connecting to the web page
        Connection conn = Jsoup.connect(page);
        //executing the get request
        Document doc = conn.get();

        String result = doc.body().text();

        System.out.println(result);

        String sbody = result.substring(0, 300);

        body.addNewTextParagraph().addNewTextRun().setText(sbody);

        XSLFSlideMaster slideMaster2 = ppt.getSlideMasters().get(0);;
        slideLayout = slideMaster2.getLayout(SlideLayout.TITLE_AND_CONTENT);
        XSLFSlide slide2 = ppt.createSlide(slideLayout);
        //selection of title place holder
        XSLFTextShape title2 = slide2.getPlaceholder(0);

        title2.setText("introduction - part 2");

        XSLFTextShape body2 = slide2.getPlaceholder(1);

        //clear the existing text in the slide
        body2.clearText();

        sbody=result.substring(301, 600);

        //adding new paragraph
        body2.addNewTextParagraph().addNewTextRun().setText(sbody);

        File file = new File("Pdf/content.pptx");

        FileOutputStream out = new FileOutputStream(file);

        ppt.write(out);

        System.out.println("slide created successfully");

        out.close();

    }
}
