package com.press.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfWriter;

public class TranslatePDF {
	public static void changePDF(List lists, String path)
			throws FileNotFoundException, DocumentException {
		Document document = new Document(PageSize.A4, 50, 50, 50, 50);
		PdfWriter writer = PdfWriter.getInstance(document,
				new FileOutputStream(path));
		document.open();
		Anchor anchorTarget = new Anchor(lists.get(0).getClass().getSimpleName());
		anchorTarget.setName("BackToTop");
		Paragraph paragraph1 = new Paragraph();

		paragraph1.setSpacingBefore(50);
		paragraph1.add(anchorTarget);
		document.add(paragraph1);
		for (Object o : lists) {
			String string = o.toString();
			document.add(new Paragraph(string, FontFactory.getFont(
					FontFactory.COURIER, 8, Font.BOLD, new CMYKColor(0, 255,
							0, 0))));
		}
		document.close();
	}
}
