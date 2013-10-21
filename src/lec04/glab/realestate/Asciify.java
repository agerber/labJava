package lec04.glab.realestate;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class Asciify {


	// ===============================================
	// == PSUEDOCODE
	// ===============================================
	//get contents of clipboard and assign to strUrl
	//try to download the original image given strUrl and create a new Buffered image from it
		//catch exception and give error message
	//resize buffered-image to some reasonably-sized width around 150 pixels
	//for each pixel in row
		//for each pixel in col
			//get the RGB color of the pixel and store in colPixel
			//create a greyscale value from colPixel (values from 0.0 to 255.0) and store in double
			//convert greyscale value to an ascii char (@ and # for dark and * and . for light, etc.)
			//add ascii char to strBuilder
	    //add a line break to strBuilder
	//copy strBuilder out to clipboard
	//give success message for feedback. 
	


	public static void main(String[] args) {

		int nGreyValue;
		StringBuilder stbOut = new StringBuilder();
		
		// sournd with try/catch
		try {

			// copy contents from clipboard into string
			String strClipURL = getClipboardContents();
			BufferedImage bufImg = getBuffered(strClipURL);
			// resize it
			bufImg = resize(bufImg);
			Color colPixel;
			String strAscii;

			for (int nRow = 0; nRow < bufImg.getHeight(); nRow++) 
													
			{
				for (int nCol = 0; nCol < bufImg.getWidth(); nCol++) 
														
				{
					 colPixel = new Color(bufImg.getRGB(nCol, nRow));
															
					nGreyValue = (int)(((colPixel.getRed() * 0.2989)
							+ (colPixel.getBlue() * 0.5870) + (colPixel
							.getGreen() * 0.1140))); 
			
					strAscii = getAsciiValue(nGreyValue);
					System.out.print(strAscii);
					stbOut.append(strAscii);
				}
	
				System.out.println();
				stbOut.append("\n");

			}
			writeToClipboard(stbOut.toString());
			JOptionPane.showMessageDialog(null, strClipURL
					+ " successfully ascii-fied and copied to clipboard.");
		} catch (Exception e) {

			// set the error message and display dialogBox
			JOptionPane
					.showMessageDialog(
							null,
							e.getMessage()
									+ " make sure you copy the URL of an image from the Internet to the clipboard before executing this program." +
									"you may use local files too; for exmaple: file:\\\\\\C:\\dir\\image.jpg");

		}

	}//end main
	
	
	//resize to 150 width
	private static BufferedImage resize(BufferedImage bufImage) {

		// get the size of the width
		int nWidth = bufImage.getWidth();
		double dScaling = 150.0 / nWidth;

		BufferedImage bufResizedImage = new BufferedImage(
				(int) (bufImage.getWidth() * dScaling),
				(int) (bufImage.getHeight() * dScaling),
				BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = bufResizedImage.createGraphics();
		g.drawImage(bufImage, 0, 0, (int) (bufImage.getWidth() * dScaling),
				(int) (bufImage.getHeight() * dScaling), null);
		g.dispose();
		return bufResizedImage;

	}
	
	
	private static BufferedImage resize(BufferedImage bufImage, int nDimW) {

		// get the size of the width
		int nWidth = bufImage.getWidth();
		double dScalingW = (double)nDimW / nWidth;
		
		BufferedImage bufResizedImage = new BufferedImage(
				(int) (bufImage.getWidth() * dScalingW),
				(int) (bufImage.getHeight() * dScalingW),
				BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = bufResizedImage.createGraphics();
		g.drawImage(bufImage, 0, 0, (int) (bufImage.getWidth() * dScalingW),
				(int) (bufImage.getHeight() * dScalingW), null);
		g.dispose();
		return bufResizedImage;

	}
	
	
	private static BufferedImage resize(BufferedImage bufImage, int nDimW, int nDimH) {

		// get the size of the width
		int nWidth = bufImage.getWidth();
		double dScalingW = (double)nDimW / nWidth;
		
		int nHeight = bufImage.getHeight();
		double dScalingH = (double)nDimH / nHeight;

		BufferedImage bufResizedImage = new BufferedImage(
				(int) (bufImage.getWidth() * dScalingW),
				(int) (bufImage.getHeight() * dScalingH),
				BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = bufResizedImage.createGraphics();
		g.drawImage(bufImage, 0, 0, (int) (bufImage.getWidth() * dScalingW),
				(int) (bufImage.getHeight() * dScalingH), null);
		g.dispose();
		return bufResizedImage;

	}
	

	private static BufferedImage getBuffered(String strURL) throws IOException {
		// String imagesRootPath = "http://www.mysite.com/images";
		try {
			URL url = new URL(strURL);
			BufferedImage bufImage = ImageIO.read(url);
			return bufImage;
		} catch (IOException ioe) {
			return null;
		}

	}



	public static void writeToClipboard(String writeMe) {
		// get the system clipboard
		Clipboard clpBoard = Toolkit.getDefaultToolkit()
				.getSystemClipboard();

		Transferable trnContent = new StringSelection(writeMe);
		clpBoard.setContents(trnContent, null);

	}

	public static String getClipboardContents() {
		String strR = "";
		Clipboard clpBoard = Toolkit.getDefaultToolkit().getSystemClipboard();
		// odd: the Object param of getContents is not currently used
		Transferable trnContents = clpBoard.getContents(null);
		boolean hasTransferableText = (trnContents != null)
				&& trnContents.isDataFlavorSupported(DataFlavor.stringFlavor);
		if (hasTransferableText) {
			try {
				strR = (String) trnContents
						.getTransferData(DataFlavor.stringFlavor);
			} catch (UnsupportedFlavorException ex) {
				// highly unlikely since we are using a standard DataFlavor
				System.out.println(ex);
				ex.printStackTrace();
			} catch (IOException ex) {
				System.out.println(ex);
				ex.printStackTrace();
			}
		}
		return strR.trim();
	}


	
	private static String getAsciiValue(int nGrey)// takes the grayscale value as
		// parameter
	{
			String str = " ";
			/*
			* Create a new string and assign to it a string based on the grayscale
			* value. If the grayscale value is very high, the pixel is very bright
			* and assign characters such as . and , that do not appear very dark.
			* If the grayscale value is very low the pixel is very dark, assign
			* characters with a high bit-depth such as # and @ which appear dark.
			*/
			
			if (nGrey >= 230) {
			str = " ";
			} else if (nGrey >= 200) {
			str = ".";
			} else if (nGrey >= 180) {
			str = "*";
			} else if (nGrey >= 160) {
			str = ":";
			} else if (nGrey >= 130) {
			str = "o";
			} else if (nGrey >= 100) {
			str = "&";
			} else if (nGrey >= 70) {
			str = "8";
			} else if (nGrey >= 50) {
			str = "#";
			} else {
			str = "@";
		}
		
		return str; // return the character

     }
	
	
	private static char getAsciiValueChar(int nGrey)// takes the grayscale value as
	// parameter
{
		char cVal = ' ';

		
		if (nGrey >= 230) {
		cVal = ' ';
		} else if (nGrey >= 200) {
		cVal = '.';
		} else if (nGrey >= 180) {
		cVal = '*';
		} else if (nGrey >= 160) {
		cVal = ':';
		} else if (nGrey >= 130) {
		cVal = 'o';
		} else if (nGrey >= 100) {
		cVal = '&';
		} else if (nGrey >= 70) {
		cVal = '8';
		} else if (nGrey >= 50) {
		cVal = '#';
		} else {
		cVal = '@';
	}
	
	return cVal; // return the character

 }
	
	
	public static char[][] getAsciiChars(String strClipURL, int nDimW, int nDimH){
		
		int nGreyValue;
	
		char[][] cAsciis = new char[nDimH][nDimW];
		
		// sournd with try/catch
		try {

		
			BufferedImage bufImg = getBuffered(strClipURL);
			// resize it to dim
			bufImg = resize(bufImg, nDimW, nDimH);
			Color colPixel;
			//String strAscii;

			for (int nRow = 0; nRow < bufImg.getHeight(); nRow++) 
														
			{
				for (int nCol = 0; nCol < bufImg.getWidth(); nCol++) 
															
				{
					 colPixel = new Color(bufImg.getRGB(nCol, nRow)); 
																
					nGreyValue = (int)(((colPixel.getRed() * 0.2989)
							+ (colPixel.getBlue() * 0.5870) + (colPixel
							.getGreen() * 0.1140))); 
			
					cAsciis[nRow][nCol] = getAsciiValueChar(nGreyValue);
		
				}
	
		

			}
		
		} catch (Exception e) {

			
			return null;
		}

		return cAsciis;
	}
	
   public static char[][] getAsciiChars(String strClipURL, int nDimW){
		
		int nGreyValue;
		char[][] cAsciis;
		
		
		// sournd with try/catch
		try {

		
			BufferedImage bufImg = getBuffered(strClipURL);
			// resize it to dim
			bufImg = resize(bufImg, nDimW);
			Color colPixel;
			//String strAscii;
			cAsciis = new char[bufImg.getHeight()][nDimW];

			for (int nRow = 0; nRow < bufImg.getHeight(); nRow++) 
														
			{
				for (int nCol = 0; nCol < bufImg.getWidth(); nCol++) 
									
				{
					 colPixel = new Color(bufImg.getRGB(nCol, nRow));
																
					nGreyValue = (int)(((colPixel.getRed() * 0.2989)
							+ (colPixel.getBlue() * 0.5870) + (colPixel
							.getGreen() * 0.1140))); 
			
					cAsciis[nRow][nCol] = getAsciiValueChar(nGreyValue);
		
				}
	
		

			}
		
		} catch (Exception e) {

			
			return null;
		}

		return cAsciis;
	}
	

   
   public static void printToConsole(BufferedImage bufImg, int nDimW){
		
		int nGreyValue;
		char[][] cAsciis;
		
		
		// sournd with try/catch
		try {

		
			
			// resize it to dim
			bufImg = resize(bufImg, nDimW);
			Color colPixel;
			//String strAscii;
			cAsciis = new char[bufImg.getHeight()][nDimW];

			for (int nRow = 0; nRow < bufImg.getHeight(); nRow++) 
														
			{
				for (int nCol = 0; nCol < bufImg.getWidth(); nCol++) 
									
				{
					 colPixel = new Color(bufImg.getRGB(nCol, nRow));
																
					nGreyValue = (int)(((colPixel.getRed() * 0.2989)
							+ (colPixel.getBlue() * 0.5870) + (colPixel
							.getGreen() * 0.1140))); 
			
					System.out.print(getAsciiValueChar(nGreyValue));
		
				}
	
		    System.out.println();

			}
		
		} catch (Exception e) {

			return;
			
		}

	}//end meth
	
   



}
