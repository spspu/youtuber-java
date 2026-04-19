package com.mainapp.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.mainapp.entity.StudentEntity;

public class QrCodeGenerated {
	
	public static void generatedQrCode(StudentEntity studentEntity) throws WriterException, IOException {
//		String qrCodePath="C:\\Users\\suraj\\OneDrive\\Desktop\\";

		String qrCodePath = System.getProperty("user.home") + "\\Desktop\\";
		File desktop = new File(qrCodePath);
		if (!desktop.exists()) {
		    qrCodePath = System.getProperty("user.home") + "\\OneDrive\\Desktop\\";
		}

		
		String qrCodeName=qrCodePath+studentEntity.getFirstName()+studentEntity.getId()+"-QRCODE.png";
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		BitMatrix bitMatrix = qrCodeWriter.encode("ID"+studentEntity.getId()+
				"firstName: "+studentEntity.getFirstName()+"\n"+
				"lastname: "+studentEntity.getLastName()+"\n"+
				"EmailId: "+studentEntity.getEmail()+"\n"+
				"MobileNo: "+studentEntity.getMobile()
				,BarcodeFormat.QR_CODE,400,400);
		Path path = FileSystems.getDefault().getPath(qrCodeName);
		MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
		
	}

}
