import java.util.Scanner;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageProcessor {
	//scanner to receive user input
	Scanner scanner;
	//image to be processed
	BufferedImage picture;
	//number of pixels in final image
	int pixeledWidth;
	
	//constructor
	public ImageProcessor() {
		//create scanner
		scanner = new Scanner(System.in);
	}

	//get user's photo from website
	BufferedImage UploadUserPhoto() {
		//TODO: create a way for user to upload photo, add to try catch block
		//check website for file
		String filename = "zucc.jpg"; //change this to user's filename
		try {
			//TODO: change this block to the user upload code
			//TEMP: try to find photo in working directory
			picture = ImageIO.read(new File(filename));
			System.out.println("Image found successfully.");
		} catch (IOException except) {
			//TODO: put the zucc photo code from the try block here, to use in case no photo is found
			//if photo not found, print working directory and stack trace, don't set photo
			String workingDir = System.getProperty("user.dir");
			System.out.println("Photo not found. Current working directory: " + workingDir);
			except.printStackTrace();
			picture = null;
		}
		return picture;
	}
	
	//gets user input on number of pixels
	void GetUserInput() {
		//print user prompt
		System.out.println("How many pixels wide should your final image be?");
		//get next integer from scanner and set pixeledWidth
		pixeledWidth = scanner.nextInt();
	}
	
	//break image up into pixels
	void Pixelate() {
		//height of image file
		int height = picture.getHeight();
		//width of image file
		int width = picture.getWidth();
		//size of each "pixel" that will be created, in actual pixels
		int pixelSize = width/pixeledWidth;
		//number of blocks tall the image will be
		int pixeledHeight = height/pixelSize;
	}
}
