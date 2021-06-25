package utils.impresion;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class GeneraEvidencias {
    static XWPFDocument doc;
    static XWPFParagraph title;
    static XWPFRun run;




    public static void defineVariables() throws IOException, HeadlessException, AWTException, InvalidFormatException{
        doc = new XWPFDocument();
        title = doc.createParagraph();
        run = title.createRun();



        //Initialize a Header Instance
        CTSectPr sectPr = doc.getDocument().getBody().addNewSectPr();
        XWPFHeaderFooterPolicy policy = new XWPFHeaderFooterPolicy(doc, sectPr);

        //write header content
        CTP ctpHeader = CTP.Factory.newInstance();
        CTR ctrHeader = ctpHeader.addNewR();
        CTText ctHeader = ctrHeader.addNewT();
        String autor = "    DARIO_GUARDIA";
        String datos = "Reporte de Ejecución de Pruebas Automatizadas".toUpperCase();
        String version = "V1.0";
        String headerText = "||" + autor + " || " + datos + " || " + version;



        ctHeader.setStringValue(headerText);
        XWPFParagraph headerParagraph = new XWPFParagraph(ctpHeader, doc);
        headerParagraph.setBorderBottom(Borders.BASIC_BLACK_DASHES);
        headerParagraph.setBorderLeft(Borders.BASIC_BLACK_DASHES);
        headerParagraph.setBorderRight(Borders.BASIC_BLACK_DASHES);
        headerParagraph.setBorderTop(Borders.BASIC_BLACK_DASHES);
        XWPFParagraph[] parsHeader = new XWPFParagraph[1];
        parsHeader[0] = headerParagraph;
        policy.createHeader(XWPFHeaderFooterPolicy.DEFAULT, parsHeader);



        //write footer content
        XWPFParagraph[] parsFooter;



        CTP ctp2 = CTP.Factory.newInstance();
        CTR ctr2 = ctp2.addNewR();



        CTText textt2 = ctr2.addNewT();
        //CTText textt4 = ctr2.addNewT();
        CTPPr ctppr = ctp2.addNewPPr();
        CTJc ctjc = ctppr.addNewJc();
        ctjc.setVal(STJc.THAI_DISTRIBUTE);
        ctppr.addNewRPr();
        CTString pst = ctppr.addNewPStyle();
        pst.setVal("style21");



        CTFldChar fch = ctr2.addNewFldChar();
        fch.setFldCharType(STFldCharType.BEGIN);



        ctr2.addNewInstrText().setStringValue(" PAGE ");
        ctp2.addNewR().addNewFldChar().setFldCharType(STFldCharType.SEPARATE);
        ctp2.addNewR().addNewT().setStringValue("1");
        ctp2.addNewR().addNewFldChar().setFldCharType(STFldCharType.END);
        textt2.setStringValue("||                                                                              PAGE"+" ");



        XWPFParagraph footerParagraph = new XWPFParagraph(ctp2, doc);
        parsFooter = new XWPFParagraph[1];
        parsFooter[0] = footerParagraph;
        policy.createFooter(XWPFHeaderFooterPolicy.DEFAULT, parsFooter);
    }




    public static int OpenFile(int i, String x) throws InvalidFormatException, IOException {
        run.setText(x);
        run.setBold(true);
        title.setAlignment(ParagraphAlignment.CENTER);
        return i;
    }



    public static int screenshoot() throws InvalidFormatException, IOException, HeadlessException, AWTException {
        BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        ImageIO.write(image, "jpg", new File("evidencia.jpg"));



        String imgFile = "evidencia.jpg";
        FileInputStream is = new FileInputStream(imgFile);
        run.addBreak();
        run.addBreak();
        run.addPicture(is, XWPFDocument.PICTURE_TYPE_JPEG, imgFile, Units.toEMU(450), Units.toEMU(270));
        run.addBreak();
        run.addBreak();
        is.close();
        return 0;
    }



    public static void CloseFile(String arg1) throws IOException {
        FileOutputStream fos = new FileOutputStream("D:\\automatizacion_avanzada_bootcamp\\src\\test\\java\\evidencias\\" + arg1);
        doc.write(fos);
        fos.close();
        //return arg1;
    }
}