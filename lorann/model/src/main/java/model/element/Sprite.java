package model.element;

import java.awt.Image;

public class Sprite {
	
	private Image image;
	private String imageName;
	private char consoleImage;
	
	public Sprite(final char character, final String imageName) {
        this.setConsoleImage(character);
        this.setImageName(imageName);
    }
	
	public Sprite(final char character) {
        this(character, "noimage.jpg");
    }
	
	public Image getImage() {
		return image;
	}

	public String getImageName() {
		return imageName;
	}

	public char getConsoleImage() {
		return consoleImage;
	}

	public void setConsoleImage(char consoleImage) {
		this.consoleImage = consoleImage;
	}

	public void setImage(Image image) {
		this.image = image;
	}
	
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
		
}
