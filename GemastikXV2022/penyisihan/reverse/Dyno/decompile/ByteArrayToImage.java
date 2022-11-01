import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import javax.imageio.ImageIO;

public class ByteArrayToImage {
  public static void main(String[] paramArrayOfString) throws Exception {
    BufferedImage bufferedImage = removeBG(ImageIO.read(new FileInputStream("./build/im/Big4.png")));
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    ImageIO.write(bufferedImage, "png", byteArrayOutputStream);
    byte[] arrayOfByte = byteArrayOutputStream.toByteArray();
    for (byte b = 0; b < arrayOfByte.length; b++)
      System.out.print("" + arrayOfByte[b] + ", "); 
  }
  
  public static BufferedImage removeBG(BufferedImage paramBufferedImage) {
    BufferedImage bufferedImage = new BufferedImage(paramBufferedImage.getWidth(), paramBufferedImage.getHeight(), 2);
    Color color1 = new Color(paramBufferedImage.getRGB(0, 0));
    if (paramBufferedImage.getWidth() == 59)
      color1 = new Color(paramBufferedImage.getRGB(6, 0)); 
    Color color2 = new Color(paramBufferedImage.getRGB(4, 0));
    for (byte b = 0; b < paramBufferedImage.getWidth(); b++) {
      for (byte b1 = 0; b1 < paramBufferedImage.getHeight(); b1++) {
        Color color = new Color(paramBufferedImage.getRGB(b, b1));
        if (!color.equals(color1) && !color.equals(color2))
          bufferedImage.setRGB(b, b1, color.getRGB()); 
      } 
    } 
    return bufferedImage;
  }
}
