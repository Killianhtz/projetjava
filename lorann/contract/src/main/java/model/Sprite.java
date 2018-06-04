package model;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprite {
	private Image image;
	private String imageName;
	private String consoleImage;
	private Boolean imageLoaded;
	
	public Sprite(final String CHARACTER, final String IMAGENAME) {
        this.setConsoleImage(CHARACTER);
        this.setImageName(IMAGENAME);
    }
	
	public void loadImage() throws IOException {
        this.setImage(ImageIO.read(new File("..\\model\\src\\main\\java\\model\\sprite\\" + this.getImageName())));
        this.setImageLoaded(true);
    }
	
	public Sprite(final String CHARACTER) {
        this(CHARACTER, "noimage.jpg");
    }
	
	public Image getImage() {
		return image;
	}

	public String getImageName() {
		return imageName;
	}

	public String getConsoleImage() {
		return consoleImage;
	}

	public void setConsoleImage(String consoleImage) {
		this.consoleImage = consoleImage;
	}

	public void setImage(Image image) {
		this.image = image;
	}
	
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	
	public Boolean isImageLoaded() {
		return this.imageLoaded;
	}
	
	public void setImageLoaded(Boolean isImageLoaded) {
		this.imageLoaded = isImageLoaded;
	}
}
