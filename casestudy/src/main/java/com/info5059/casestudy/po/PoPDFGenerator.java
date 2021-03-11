package com.info5059.casestudy.po;
import com.info5059.casestudy.vendor.Vendor;
import com.info5059.casestudy.vendor.VendorRepository;
import com.info5059.casestudy.product.Product;
import com.info5059.casestudy.product.ProductRepository;
import com.info5059.casestudy.pdfgenerator.Generator;
import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
import org.springframework.web.servlet.view.document.AbstractPdfView;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.net.URL;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * PoPDFGenerator - a class for creating dynamic product po output in PDF
 * format using the iText 7 library
 *
 * @author Andrea
 */
public abstract class PoPDFGenerator extends AbstractPdfView {
    public static ByteArrayInputStream generatePo(String poid,
                                                      PurchaseOrderDAO poDAO,
                                                      VendorRepository vendorRepository,
                                                      ProductRepository productRepository) throws IOException {
        URL imageUrl = Generator.class.getResource("/static/assets/logo.png");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfWriter writer = new PdfWriter(baos);
// Initialize PDF document to be written to a stream not a file
        PdfDocument pdf = new PdfDocument(writer);
// Document is the main object
        Document document = new Document(pdf);
        PdfFont font = PdfFontFactory.createFont(StandardFonts.HELVETICA);
// add the image to the document
        Image img = new Image(ImageDataFactory.create(imageUrl))
                .scaleAbsolute(120, 40)
                .setFixedPosition(80, 710);
        document.add(img);
// now let's add a big heading
        document.add(new Paragraph("\n\n"));
        Locale locale = new Locale("en", "US");
        NumberFormat formatter = NumberFormat.getCurrencyInstance(locale);
        try {
            PurchaseOrder po = poDAO.findOne(Long.parseLong(poid));
            List<PurchaseOrderLineItem> poitems = po.getItems();
            document.add(new Paragraph(String.format("Purchase Order"))
                    .setFont(font)
                    .setFontSize(24)
                    .setMarginRight(75)
                    .setTextAlignment(TextAlignment.RIGHT)
                    .setBold());
            document.add(new Paragraph("Purchase Order#:" + poid)
                    .setFont(font)
                    .setFontSize(16)
                    .setBold()
                    .setMarginRight(90)
                    .setMarginTop(-10)
                    .setTextAlignment(TextAlignment.RIGHT));
            document.add(new Paragraph("\n\n"));
            Table table = new Table(2);
            table.setWidth(new UnitValue(UnitValue.PERCENT, 20));
            //table headings
            Cell cell = new Cell().add(new Paragraph("Vendor:")
                    .setFont(font)
                    .setFontSize(12)
                    .setBold())
                    .setMarginLeft(100)
                    .setBorder(Border.NO_BORDER)
                    .setTextAlignment(TextAlignment.RIGHT);
            table.addCell(cell);
            Optional<Vendor> ven = vendorRepository.findById(po.getVendorid());
            if (ven.isPresent()) {
                Vendor vendor = ven.get();

                String name = vendor.getName();
                String address = vendor.getAddress1();
                String city = vendor.getCity();
                String province = vendor.getProvince();
                String email = vendor.getEmail();
                String phone = vendor.getPhone();

                //Vendor table in top left of report

                cell = new Cell().add(new Paragraph(name)
                        .setFont(font)
                        .setFontSize(11)
                        .setBold())
                        .setBorder(Border.NO_BORDER)
                        .setBackgroundColor(ColorConstants.LIGHT_GRAY)
                        .setTextAlignment(TextAlignment.LEFT);
                table.addCell(cell);
                cell = new Cell().add(new Paragraph()
                        .setFont(font)
                        .setFontSize(11)
                        .setBold())
                        .setBorder(Border.NO_BORDER)
                        .setTextAlignment(TextAlignment.CENTER);
                table.addCell(cell);
                cell = new Cell().add(new Paragraph(address)
                        .setFont(font)
                        .setFontSize(11)
                        .setBold())
                        .setBorder(Border.NO_BORDER)
                        .setBackgroundColor(ColorConstants.LIGHT_GRAY)
                        .setTextAlignment(TextAlignment.LEFT);
                table.addCell(cell);
                cell = new Cell().add(new Paragraph()
                        .setFont(font)
                        .setFontSize(11)
                        .setBold())
                        .setBorder(Border.NO_BORDER)
                        .setTextAlignment(TextAlignment.CENTER);
                table.addCell(cell);
                cell = new Cell().add(new Paragraph(city)
                        .setFont(font)
                        .setFontSize(11)
                        .setBold())
                        .setBorder(Border.NO_BORDER)
                        .setBackgroundColor(ColorConstants.LIGHT_GRAY)
                        .setTextAlignment(TextAlignment.LEFT);
                table.addCell(cell);
                cell = new Cell().add(new Paragraph()
                        .setFont(font)
                        .setFontSize(11)
                        .setBold())
                        .setBorder(Border.NO_BORDER)
                        .setTextAlignment(TextAlignment.CENTER);
                table.addCell(cell);
                cell = new Cell().add(new Paragraph(province)
                        .setFont(font)
                        .setFontSize(11)
                        .setBold())
                        .setBorder(Border.NO_BORDER)
                        .setBackgroundColor(ColorConstants.LIGHT_GRAY)
                        .setTextAlignment(TextAlignment.LEFT);
                table.addCell(cell);
                cell = new Cell().add(new Paragraph()
                        .setFont(font)
                        .setFontSize(11)
                        .setBold())
                        .setBorder(Border.NO_BORDER)
                        .setTextAlignment(TextAlignment.CENTER);
                table.addCell(cell);
                cell = new Cell().add(new Paragraph(email)
                        .setFont(font)
                        .setFontSize(11)
                        .setBold())
                        .setBorder(Border.NO_BORDER)
                        .setBackgroundColor(ColorConstants.LIGHT_GRAY)
                        .setTextAlignment(TextAlignment.LEFT);
                table.addCell(cell);
                cell = new Cell().add(new Paragraph()
                        .setFont(font)
                        .setFontSize(11)
                        .setBold())
                        .setBorder(Border.NO_BORDER)
                        .setTextAlignment(TextAlignment.CENTER);
                table.addCell(cell);
                cell = new Cell().add(new Paragraph(phone)
                        .setFont(font)
                        .setFontSize(11)
                        .setBold())
                        .setBorder(Border.NO_BORDER)
                        .setBackgroundColor(ColorConstants.LIGHT_GRAY)
                        .setTextAlignment(TextAlignment.LEFT);
                table.addCell(cell);
            }
            document.add(table);
            //add two spaces for the larger table
            document.add(new Paragraph("\n\n"));  //

            //po product table
            table = new Table(5);
            table.setWidth(new UnitValue(UnitValue.PERCENT, 100));
            //table headers
            cell = new Cell().add(new Paragraph("Product Code")
                    .setFont(font)
                    .setFontSize(12)
                    .setBold())
                    .setTextAlignment(TextAlignment.CENTER);
            table.addCell(cell);
            cell = new Cell().add(new Paragraph("Description")
                    .setFont(font)
                    .setFontSize(12)
                    .setBold())
                    .setTextAlignment(TextAlignment.CENTER);
            table.addCell(cell);
            cell = new Cell().add(new Paragraph("Qty Sold")
                    .setFont(font)
                    .setFontSize(12)
                    .setBold())
                    .setTextAlignment(TextAlignment.CENTER);
            table.addCell(cell);
            cell = new Cell().add(new Paragraph("Price")
                    .setFont(font)
                    .setFontSize(12)
                    .setBold())
                    .setTextAlignment(TextAlignment.CENTER);
            table.addCell(cell);
            cell = new Cell().add(new Paragraph("Ext. Price")
                    .setFont(font)
                    .setFontSize(12)
                    .setBold())
                    .setTextAlignment(TextAlignment.CENTER);
            table.addCell(cell);
            //Table data

            BigDecimal subtot = new BigDecimal(0.0);

            for(PurchaseOrderLineItem poitem : poitems) {
                Optional<Product> optx = productRepository.findById(poitem.getProductid());
                if (optx.isPresent()) {
                    Product product = optx.get();
                    String productcode = product.getId();
                    String description = product.getName();
                    int qoo = product.getQoo();
                    int quantitySold = poitem.getQty();
                    BigDecimal costprice = product.getCostprice();
                    BigDecimal extAm = new BigDecimal(0.0);
                    extAm = costprice.multiply(BigDecimal.valueOf(quantitySold), new MathContext(8, RoundingMode.UP));

                    //extAm =  extAm.add(msrp, new MathContext(8, RoundingMode.UP));
                    subtot = subtot.add(extAm, new MathContext(8, RoundingMode.UP));

                    //report data from items

                    cell = new Cell().add(new Paragraph(productcode))
                            .setFont(font)
                            .setFontSize(12)
                            .setTextAlignment(TextAlignment.CENTER);
                    table.addCell(cell);
                    cell = new Cell().add(new Paragraph(description)
                            .setFont(font)
                            .setFontSize(12)
                            .setTextAlignment(TextAlignment.CENTER));
                    table.addCell(cell);
                    cell = new Cell().add(new Paragraph(String.valueOf(quantitySold)))
                            .setFont(font)
                            .setFontSize(12)
                            .setTextAlignment(TextAlignment.RIGHT);
                    table.addCell(cell);
                    cell = new Cell().add(new Paragraph(formatter.format(costprice)))
                            .setFont(font)
                            .setFontSize(12)
                            .setTextAlignment(TextAlignment.RIGHT);
                    table.addCell(cell);
                    cell = new Cell().add(new Paragraph(formatter.format(extAm)))
                            .setFont(font)
                            .setFontSize(12)
                            .setTextAlignment(TextAlignment.RIGHT);
                    table.addCell(cell);

                }
            }
            BigDecimal tax = new BigDecimal(0.0);
            BigDecimal total = new BigDecimal(0.0);
            BigDecimal tax_rate = new BigDecimal(0.13);
            tax = subtot.multiply(tax_rate, new MathContext(8, RoundingMode.UP));
            total = subtot.add(tax, new MathContext(8, RoundingMode.UP));
            //table totals
            cell = new Cell(1, 4).add(new Paragraph("Sub Total:")
                    .setFont(font)
                    .setFontSize(12)
                    .setBold()
                    .setBorderBottom(Border.NO_BORDER)
                    .setBorderLeft(Border.NO_BORDER)
                    .setTextAlignment(TextAlignment.RIGHT));
            table.addCell(cell);
            cell = new Cell().add(new Paragraph(formatter.format(subtot))
                    .setFont(font)
                    .setFontSize(12)
                    .setBold()
                    .setTextAlignment(TextAlignment.RIGHT));
            table.addCell(cell);
            cell = new Cell(1, 4).add(new Paragraph("Tax:")
                    .setFont(font)
                    .setFontSize(12)
                    .setBold()
                    .setBorder(Border.NO_BORDER)
                    .setTextAlignment(TextAlignment.RIGHT));
            table.addCell(cell);
            cell = new Cell().add(new Paragraph(formatter.format(tax))
                    .setFont(font)
                    .setFontSize(12)
                    .setBold()
                    .setTextAlignment(TextAlignment.RIGHT));
            table.addCell(cell);
            cell = new Cell(1, 4).add(new Paragraph("Total:")
                    .setFont(font)
                    .setFontSize(12)
                    .setBold()
                    .setBorder(Border.NO_BORDER)
                    .setTextAlignment(TextAlignment.RIGHT));
            table.addCell(cell);
            cell = new Cell().add(new Paragraph(formatter.format(total))
                    .setFont(font)
                    .setFontSize(12)
                    .setBold()
                    .setTextAlignment(TextAlignment.RIGHT)
                    .setBackgroundColor(ColorConstants.YELLOW));
            table.addCell(cell);
            document.add(table);
            document.add(new Paragraph("\n\n"));
            String pattern = "yyyy-MM-dd HH:mm.ss z";
            TimeZone tz = TimeZone.getTimeZone("EST");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            simpleDateFormat.setTimeZone(tz);
            document.add(new Paragraph(String.valueOf(simpleDateFormat.format(po.getPodate())))
                    .setTextAlignment(TextAlignment.CENTER));

            document.close();
        } catch (Exception ex) {
            Logger.getLogger(Generator.class.getName()).log(Level.SEVERE, null, ex);
        }
// finally send stream back to the controller
        return new ByteArrayInputStream(baos.toByteArray());
    }
}
