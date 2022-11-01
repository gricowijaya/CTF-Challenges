import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class DinoGame extends JFrame implements KeyListener {
  Dimension ss = Toolkit.getDefaultToolkit().getScreenSize();
  
  Random rand = new Random();
  
  Robot r;
  
  static int fr = 15;
  
  final int FW = 700;
  
  final int FH = 500;
  
  final int SW = (int)this.ss.getWidth();
  
  final int SH = (int)this.ss.getHeight();
  
  boolean uK = false;
  
  boolean lK = false;
  
  boolean rK = false;
  
  boolean dK = false;
  
  boolean sK = false;
  
  boolean dd = false;
  
  boolean dW = false;
  
  boolean bF = false;
  
  boolean dg = false;
  
  byte[] x1 = new byte[] { 
      -119, 80, 78, 71, 13, 10, 26, 10, 0, 0, 
      0, 13, 73, 72, 68, 82, 0, 0, 0, 44, 
      0, 0, 0, 45, 8, 6, 0, 0, 0, -43, 
      -40, -119, -92, 0, 0, 0, -5, 73, 68, 65, 
      84, 120, 94, -19, -112, 65, 14, -61, 48, 8, 
      4, -13, 71, -1, -1, 29, 57, -74, -105, 82, 
      69, -45, 80, 112, 109, -120, -36, 48, -46, 74, 
      85, 88, -61, -88, -37, 22, -60, -66, -17, -113, 
      -103, -31, -2, 105, -16, 80, 107, 109, 40, 37, 
      76, 102, -119, 50, 97, -30, -102, 48, 123, -100, 
      91, -71, 68, -8, -20, -73, 55, 37, 44, 124, 
      19, 62, -62, -71, -107, 116, -31, -47, -108, -80, 
      80, -62, -81, -108, -80, -112, 38, 44, 31, 62, 
      6, 78, -8, -98, 7, 123, 99, 122, -16, 32, 
      -25, 22, 124, 79, -127, -34, -88, 30, 60, -96, 
      22, 79, -96, 100, -113, 40, -33, 105, -31, -51, 
      -1, 23, -26, -62, -29, -37, -98, 112, -121, 117, 
      -9, 13, -113, 90, 15, 121, -32, 114, 97, 107, 
      -95, -42, 31, -51, -3, -124, -71, -56, -22, -11, 
      -122, -5, -18, 43, 28, 21, -2, 17, 37, 60, 
      59, 110, 65, -78, -100, -80, -112, 45, -66, -116, 
      -16, -80, 40, -119, 22, 47, 97, 97, -74, -72, 
      -20, 43, 97, 50, 42, -98, 38, 42, 44, 43, 
      108, -119, 107, 115, -66, -25, -2, -23, -16, 32, 
      -123, 40, -90, 125, 79, 19, 22, 44, 33, -83, 
      -57, 121, 26, 20, -47, -124, -40, -29, 60, 13, 
      -81, -120, -73, 23, -114, 87, -60, -37, 11, -121, 
      34, -102, -112, -73, 23, -114, 87, -60, -37, 11, 
      71, 14, 106, -23, -19, -3, -54, 19, 64, 48, 
      50, 54, -111, 43, 31, 116, 0, 0, 0, 0, 
      73, 69, 78, 68, -82, 66, 96, -126 };
  
  byte[] x2 = new byte[] { 
      -119, 80, 78, 71, 13, 10, 26, 10, 0, 0, 
      0, 13, 73, 72, 68, 82, 0, 0, 0, 44, 
      0, 0, 0, 45, 8, 6, 0, 0, 0, -43, 
      -40, -119, -92, 0, 0, 0, -24, 73, 68, 65, 
      84, 120, 94, -19, -112, 65, 14, -61, 48, 8, 
      4, -13, 71, -1, -1, 29, 62, -74, -105, 82, 
      69, 35, 35, -20, Byte.MIN_VALUE, -35, 58, 97, -92, -67, 
      -60, -64, -114, 114, 28, -109, -88, -75, -66, 34, 
      -61, -5, 97, -80, -88, -108, -30, 74, 10, -109, 
      40, 81, 102, -102, -72, 38, 44, -17, -4, -34, 
      -101, 20, 22, 52, 97, 111, 82, 88, 72, -31, 
      79, 82, 88, -72, -67, -80, -52, -9, -122, 125, 
      110, -106, 9, -85, 15, -99, 112, -97, 98, -93, 
      49, 61, 88, -56, 119, 11, -18, 83, 96, 52, 
      -86, 7, 11, -44, -63, 6, -108, 28, 17, -27, 
      -98, 22, 118, -34, 95, -104, 7, -49, -69, 35, 
      -31, 13, -85, -9, 11, 75, -83, 69, 22, -4, 
      92, -40, 58, -88, -51, 123, -13, 60, 97, 30, 
      -78, -26, 70, -61, 123, -49, 21, -98, 21, -2, 
      -120, 20, -114, 78, -73, 32, -39, 78, 88, 88, 
      45, -66, -115, -80, 91, -108, -52, 22, 79, 97, 
      33, 90, 92, -18, -91, 48, -15, -118, 47, 19, 
      21, -74, 21, -74, -60, 123, -26, 56, -61, -82, 
      16, 88, 66, 9, 77, -122, -17, -83, 25, 118, 
      -123, -94, -119, -80, -100, 82, -83, -100, -17, 78, 
      99, 123, -31, -91, -27, 87, -40, 94, -8, -17, 
      -59, -73, 21, -42, -62, -7, 89, -68, 1, -49, 
      -51, 37, -18, -109, 72, -73, -13, 0, 0, 0, 
      0, 73, 69, 78, 68, -82, 66, 96, -126 };
  
  byte[] x3 = new byte[] { 
      -119, 80, 78, 71, 13, 10, 26, 10, 0, 0, 
      0, 13, 73, 72, 68, 82, 0, 0, 0, 44, 
      0, 0, 0, 44, 8, 6, 0, 0, 0, 30, 
      -124, 90, 1, 0, 0, 0, -28, 73, 68, 65, 
      84, 120, 94, -19, -48, 65, 14, -61, 48, 8, 
      68, -47, -36, -47, -9, 63, -121, -105, -19, -90, 
      68, -43, 87, 17, -74, 0, -89, 78, 24, 105, 
      54, -79, 13, 79, 57, -114, -92, -12, -34, 95, 
      -111, -27, -4, -80, 112, 81, 107, -51, -43, 2, 
      51, 81, 80, 54, 13, -82, -127, -27, -100, -33, 
      71, 91, 96, -119, 6, -10, -74, -64, -110, 2, 
      Byte.MAX_VALUE, 90, 96, -55, -19, -63, 114, Byte.MAX_VALUE, -76, -36, 
      -25, -50, 50, -80, 122, 48, 24, -66, 39, 108, 
      -74, -90, -125, 11, 121, 110, -123, -17, 9, -104, 
      -83, -22, -32, 2, -11, -30, -113, 16, 57, 3, 
      -27, 59, -83, -36, 121, Byte.MAX_VALUE, 48, 7, 126, -65, 
      -99, 41, 103, 88, 123, -49, 112, -87, -11, -112, 
      11, 46, 7, 91, 3, -75, -5, -34, 62, 15, 
      -52, 65, -42, -67, -39, 114, -34, 115, -63, 89, 
      -27, -113, 40, 112, 116, -121, -127, -52, 118, 96, 
      -55, 106, -8, 54, 96, 55, -108, -55, -122, 23, 
      88, 18, 13, -105, 121, 5, 102, -68, -16, 101, 
      80, -55, -74, 96, 13, 62, 123, -50, -7, -31, 
      -31, 66, 11, 100, -99, 115, 126, 90, -72, -40, 
      -126, -15, 59, -25, -91, 71, 3, 17, -58, -13, 
      -53, -64, 18, -62, 8, 42, 112, 118, 8, -2, 
      123, 120, 54, -8, 13, 66, -106, 26, 54, -7, 
      75, 14, 33, 0, 0, 0, 0, 73, 69, 78, 
      68, -82, 66, 96, -126 };
  
  byte[] x4 = new byte[] { 
      -119, 80, 78, 71, 13, 10, 26, 10, 0, 0, 
      0, 13, 73, 72, 68, 82, 0, 0, 0, 59, 
      0, 0, 0, 29, 8, 6, 0, 0, 0, 20, 
      -48, 20, -104, 0, 0, 0, -42, 73, 68, 65, 
      84, 120, 94, -19, -113, 81, 14, -61, 32, 12, 
      67, 123, 71, -18, Byte.MAX_VALUE, -106, 77, -107, 10, 98, 
      -81, -14, 88, 33, 91, 67, -40, -109, -4, 3, 
      78, 98, 111, -37, -97, -32, -92, -108, 30, -69, 
      -8, 30, 18, -113, 101, 115, -90, 94, 113, 95, 
      -127, -58, -26, -64, 1, -3, 61, -30, -50, 12, 
      125, 87, -59, 125, 5, 26, -101, 3, 7, -12, 
      -9, -24, 27, 59, 107, 113, -65, -7, 1, 75, 
      -115, 102, -84, 123, 14, 45, -6, -123, 70, 51, 
      -42, 61, 95, -96, 49, -126, -40, -79, 64, 99, 
      4, -79, -29, 9, 14, -52, 44, 118, 59, -63, 
      -127, -103, -59, 110, 18, 14, -50, 40, 118, -110, 
      112, 112, 70, -79, 83, 19, 46, -16, 32, 102, 
      52, -125, -121, 60, -120, 25, -51, -31, 65, 75, 
      89, -35, -30, -98, 110, -72, -40, 82, 86, -73, 
      -72, 103, 24, 30, -80, 16, 111, -72, -127, 65, 
      91, -30, -4, -50, -69, 63, 55, -88, -112, 44, 
      -88, 124, -103, -42, -65, 11, 84, 72, -106, 84, 
      -66, -52, -89, -66, 91, 81, 33, -43, -69, -30, 
      -86, -1, 22, 84, 72, -11, 30, -110, 37, 74, 
      102, -106, 44, -69, 68, -23, -91, -54, 122, -25, 
      9, -121, -81, -58, -44, 91, 121, -49, -50, 0, 
      0, 0, 0, 73, 69, 78, 68, -82, 66, 96, 
      -126 };
  
  byte[] x5 = new byte[] { 
      -119, 80, 78, 71, 13, 10, 26, 10, 0, 0, 
      0, 13, 73, 72, 68, 82, 0, 0, 0, 59, 
      0, 0, 0, 29, 8, 6, 0, 0, 0, 20, 
      -48, 20, -104, 0, 0, 0, -47, 73, 68, 65, 
      84, 120, 94, -19, -113, 81, 14, -123, 32, 12, 
      4, -67, 35, -9, 63, -53, 51, 38, 66, 112, 
      124, 72, -124, -43, -76, -32, 36, -5, 3, -19, 
      118, 119, 89, 62, 6, 39, -124, -16, -37, -60, 
      -9, 33, -79, 88, 54, 102, 106, 21, -3, 18, 
      28, -84, 46, -20, 112, -66, 69, -12, -116, 112, 
      -18, -82, -24, -105, -32, 96, 117, 97, -121, -13, 
      45, 122, -62, 51, 23, -3, -27, 7, -108, -22, 
      -51, -104, -9, -20, 50, 122, 67, -67, 25, -13, 
      -98, 7, 56, 56, -126, -40, 49, -63, -63, 17, 
      -60, -114, 39, -72, -32, 89, -20, 118, -126, 11, 
      -98, -59, 110, 69, -72, -24, 81, -20, 84, -124, 
      -117, 30, -59, 78, 85, 104, 96, 65, -52, 40, 
      -125, -121, 44, -120, 25, -27, -16, -96, 82, -86, 
      91, -12, 105, -122, -58, 74, -87, 110, -47, -89, 
      27, 30, 80, -120, 55, -52, -64, -96, 53, 113, 
      Byte.MAX_VALUE, -29, -22, -49, 12, 44, 82, 10, -51, Byte.MAX_VALUE, 
      -50, -4, 123, 51, 7, 11, -108, 66, -13, -97, 
      51, 87, Byte.MAX_VALUE, 102, 80, -123, 84, -7, 60, -118, 
      -117, -112, 42, -90, 40, 25, -103, -78, -20, 20, 
      -91, -89, 42, -21, -107, 21, 51, 17, -62, -28, 
      -117, -73, 78, -37, 0, 0, 0, 0, 73, 69, 
      78, 68, -82, 66, 96, -126 };
  
  byte[] x6 = new byte[] { 
      -119, 80, 78, 71, 13, 10, 26, 10, 0, 0, 
      0, 13, 73, 72, 68, 82, 0, 0, 0, 46, 
      0, 0, 0, 34, 8, 6, 0, 0, 0, 32, 
      123, -21, 76, 0, 0, 0, -103, 73, 68, 65, 
      84, 120, 94, -19, -46, 65, 10, Byte.MIN_VALUE, 48, 12, 
      68, 81, -17, -40, -5, -97, -93, 75, 93, 13, 
      -24, 64, 105, -102, -90, 37, -87, -7, 48, 43, 
      65, 95, -64, -21, 18, 86, 107, -67, -33, -29, 
      -25, 110, 11, 7, 7, -76, -108, -14, -103, -5, 
      3, -62, -63, 91, -32, -124, 91, -41, 3, -13, 
      -36, 28, 16, 14, 62, 10, 102, -8, -24, -8, 
      -5, -22, -62, -63, -75, -32, -39, 77, 31, 16, 
      30, 62, 58, -122, 104, -57, -17, -107, 46, 46, 
      92, -101, -11, 1, -46, -3, 23, -114, 86, 29, 
      -64, -65, -122, 25, 24, 37, -68, -77, -124, 35, 
      107, 56, -1, 26, -26, 96, 116, 60, -100, 33, 
      -83, -15, -5, -105, 117, 44, 124, 59, 72, -38, 
      113, 112, -73, 96, -108, -16, -35, 29, 3, 119, 
      15, 70, 97, -31, 40, 28, 24, -19, -122, 63, 
      98, 41, -118, -117, 118, 23, -73, 37, 0, 0, 
      0, 0, 73, 69, 78, 68, -82, 66, 96, -126 };
  
  byte[] x7 = new byte[] { 
      -119, 80, 78, 71, 13, 10, 26, 10, 0, 0, 
      0, 13, 73, 72, 68, 82, 0, 0, 0, 46, 
      0, 0, 0, 34, 8, 6, 0, 0, 0, 32, 
      123, -21, 76, 0, 0, 0, -70, 73, 68, 65, 
      84, 120, 94, -19, -110, 65, 10, 4, 49, 8, 
      4, -25, -113, -7, -1, 59, 114, -36, 97, 23, 
      -68, 20, -120, 73, 52, -125, -18, -92, -96, 47, 
      18, -76, 26, 114, 93, 78, 122, -17, -97, 111, 
      56, 79, -117, 8, -73, -42, 126, 41, 83, -32, 
      111, -60, -53, 20, 40, 35, 46, 66, 12, -59, 
      -45, 21, -96, 112, 122, 113, 77, 48, 125, 1, 
      77, 44, -83, -8, -88, -112, -11, -114, -17, 121, 
      39, 28, 75, 40, -99, -8, -88, 8, -123, 56, 
      -41, -78, -83, -64, -86, 8, -25, 90, -62, -59, 
      103, 5, 40, -62, -71, -107, -80, 2, 94, 1, 
      -50, -83, -72, -59, 87, 15, 123, -13, 94, 113, 
      65, 22, -115, -122, 34, -85, -31, 94, 43, -12, 
      -82, 43, 62, 75, 116, -127, -47, -72, 11, -108, 
      21, 23, 118, 21, -32, 23, 9, 19, 22, -54, 
      -118, 11, -69, 10, 72, -114, -72, -122, -73, 0, 
      -65, -58, 118, 97, -95, -84, -72, -64, -61, -77, 
      -31, -66, -57, -96, -56, 108, -72, -17, 112, 56, 
      20, -31, 6, -29, 23, -86, -125, -28, Byte.MAX_VALUE, -86, 
      -14, 0, 0, 0, 0, 73, 69, 78, 68, -82, 
      66, 96, -126 };
  
  byte[] x8 = new byte[] { 
      -70, 115, -23, -88, -110, 53, -91, 47, -53, 43, 
      108, 51, 119, 125, -40, 44, 19, 57, -49, 117, 
      108, 48, 95, 120, 111, -45, 17, -20, 2, 53, 
      -60, -13, 42, 100, 122, -89, -121, 61, -78, 40 };
  
  int gY = 332;
  
  int dw = 44;
  
  int dh = 44;
  
  int dx = 50;
  
  int dy = this.gY - this.dh;
  
  int jS = 1000000000;
  
  final int dkH = 29;
  
  final int dkW = 59;
  
  Rectangle dH = new Rectangle(this.dx, this.dy, this.dw, this.dh);
  
  int cJ = 0;
  
  int mcJ = 8;
  
  Rectangle gH = new Rectangle(this.dx, this.gY, this.dw, this.dh);
  
  double vS = 0.0D;
  
  final int sX = this.dx;
  
  final int sY = this.dy;
  
  final int sW = this.dw;
  
  final int sH = this.dh;
  
  double cS = 7.0D;
  
  int cT = 0;
  
  int dM = 10;
  
  int sdM = this.dM;
  
  ArrayList<Cactus> cA = new ArrayList<>();
  
  int s = 0;
  
  int hs = ls();
  
  final double gravity = 0.6D;
  
  int migos = 5;
  
  String csss;
  
  String fsss;
  
  int ssss;
  
  BufferedImage dddddddd;
  
  BufferedImage ddddddddd;
  
  BufferedImage dddddddddd;
  
  BufferedImage ddddddddddd;
  
  BufferedImage dddddddddddd;
  
  BufferedImage ddddddddddddd;
  
  BufferedImage dddddddddddddd;
  
  ArrayList<Cloud> cL = new ArrayList<>(Arrays.asList(new Cloud[] { new Cloud((int)(Math.random() * 700.0D), 0), new Cloud((int)(Math.random() * 700.0D), 0), new Cloud((int)(Math.random() * 700.0D), 0), new Cloud((int)(Math.random() * 700.0D), 0) }));
  
  double clS = this.cS / 3.0D / 2.0D;
  
  private void gf() {
    this.rand.setSeed(this.ssss);
    this.fsss = "";
    for (byte b = 0; b < 40; b++) {
      int i = this.rand.nextInt(128);
      int j = this.x8[b] ^ this.x1[i] ^ this.x2[i] ^ this.x3[i] ^ this.x4[i] ^ this.x5[i] ^ this.x6[i] ^ this.x7[i];
      this.fsss += this.fsss;
    } 
  }
  
  private int ls() {
    gf();
    try {
      BufferedReader bufferedReader = new BufferedReader(new FileReader("highscore.txt"));
      String str = bufferedReader.readLine();
      bufferedReader.close();
      String[] arrayOfString = str.split(" ");
      int i = Integer.parseInt(arrayOfString[0]);
      this.csss = arrayOfString[1];
      int j = rcr(i);
      if (!Integer.toHexString(j).equals(this.csss))
        throw new Error("Invalid checksum"); 
      this.ssss = rcr(rcr(j) ^ i);
      return i;
    } catch (Exception exception) {
      System.out.println("Error loading highscore");
      System.exit(0);
      return 0;
    } 
  }
  
  private int rcr(int paramInt) {
    int i = -1;
    for (byte b = 0; b < 4; b++) {
      i ^= paramInt >> b * 8;
      for (byte b1 = 0; b1 < 8; b1++) {
        if ((i & 0x1) == 1) {
          i = i >> 1 ^ 0xEDB88320;
        } else {
          i >>= 1;
        } 
      } 
    } 
    return i;
  }
  
  public DinoGame(String paramString) {
    super(paramString);
    addKeyListener(this);
    setSize(700, 500);
    setVisible(true);
    setDefaultCloseOperation(3);
    setResizable(false);
    setLocation(this.SW / 2 - 350, 75);
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    try {
      this.r = new Robot();
      ByteArrayInputStream byteArrayInputStream1 = new ByteArrayInputStream(this.x1);
      ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(this.x2);
      ByteArrayInputStream byteArrayInputStream3 = new ByteArrayInputStream(this.x3);
      ByteArrayInputStream byteArrayInputStream4 = new ByteArrayInputStream(this.x4);
      ByteArrayInputStream byteArrayInputStream5 = new ByteArrayInputStream(this.x5);
      ByteArrayInputStream byteArrayInputStream6 = new ByteArrayInputStream(this.x6);
      ByteArrayInputStream byteArrayInputStream7 = new ByteArrayInputStream(this.x7);
      this.dddddddd = ImageIO.read(byteArrayInputStream1);
      this.ddddddddd = ImageIO.read(byteArrayInputStream2);
      this.dddddddddd = ImageIO.read(byteArrayInputStream3);
      this.ddddddddddd = ImageIO.read(byteArrayInputStream4);
      this.dddddddddddd = ImageIO.read(byteArrayInputStream5);
      this.ddddddddddddd = ImageIO.read(byteArrayInputStream6);
      this.dddddddddddddd = ImageIO.read(byteArrayInputStream7);
    } catch (Exception exception) {}
  }
  
  public void paint(Graphics paramGraphics) {
    BufferedImage bufferedImage = new BufferedImage(700, 500, 1);
    Graphics graphics = bufferedImage.getGraphics();
    graphics.setColor(Color.WHITE);
    graphics.fillRect(0, 0, 700, 500);
    byte b;
    for (b = 0; b < this.cL.size(); b++) {
      graphics.setColor(new Color(200, 200, 200));
      graphics.drawOval(((Cloud)this.cL.get(b)).x, ((Cloud)this.cL.get(b)).y, ((Cloud)this.cL.get(b)).rad1, ((Cloud)this.cL.get(b)).rad2);
    } 
    graphics.setColor(Color.GRAY.darker().darker());
    graphics.fillRect(0, this.gY - 5, 700, 1);
    if (!this.dd) {
      if (this.s % 8 == 0)
        this.dW = !this.dW; 
      if (!this.dg) {
        if (this.dW) {
          graphics.drawImage(this.ddddddddd, this.dx, this.dy, null);
        } else {
          graphics.drawImage(this.dddddddddd, this.dx, this.dy, null);
        } 
      } else if (this.dW) {
        graphics.drawImage(this.ddddddddddd, this.dx, this.dy, null);
      } else {
        graphics.drawImage(this.dddddddddddd, this.dx, this.dy, null);
      } 
    } else {
      if (this.dy > this.gY - this.sH)
        this.dy = this.gY - this.sH; 
      graphics.drawImage(this.dddddddd, this.dx, this.dy, null);
    } 
    if (this.s % 10 == 0)
      this.bF = !this.bF; 
    for (b = 0; b < this.cA.size(); b++) {
      if (!((Cactus)this.cA.get(b)).bird) {
        graphics.drawImage(((Cactus)this.cA.get(b)).image, (int)((Cactus)this.cA.get(b)).x, ((Cactus)this.cA.get(b)).y, null);
      } else if (this.bF) {
        graphics.drawImage(this.ddddddddddddd, (int)((Cactus)this.cA.get(b)).x, ((Cactus)this.cA.get(b)).y, null);
      } else {
        graphics.drawImage(this.dddddddddddddd, (int)((Cactus)this.cA.get(b)).x, ((Cactus)this.cA.get(b)).y, null);
      } 
    } 
    graphics.setColor(Color.GRAY.darker());
    graphics.setFont(new Font("CourierNew", 0, 15));
    graphics.drawString("HI: " + this.hs + "     Score: " + (this.s +  2147482310), 450, 50);
    if (this.dd) {
      graphics.setFont(new Font("CourierNew", 0, 25));
      graphics.drawString("You Died!", 350, 125);
      graphics.setFont(new Font("CourierNew", 0, 15));
      if (this.s > this.hs) {
        graphics.drawString(this.fsss, 350, 175);
      } else {
        graphics.drawString("Press space to try again", 350, 175);
      } 
    } 
    paramGraphics.drawImage(bufferedImage, 0, 0, null);
  }
  
  public void run() {
    if (!this.dd) {
      this.s++;
      moveCacti();
      // collideFloor();
      // collideCactus();
      movement();
      this.dy = (int)(this.dy + this.vS);
      updateHitboxes();
    } else if (this.sK) {
      restart();
    } 
  }
  
  public void updateHitboxes() {
    this.dH = new Rectangle(this.dx + this.migos + 5, this.dy + this.migos, this.dw - this.migos - 13, this.dh - this.migos);
    this.gH = new Rectangle(this.dx, this.gY, this.dw, this.dh);
    for (byte b = 0; b < this.cA.size(); b++)
      ((Cactus)this.cA.get(b)).hitbox = new Rectangle((int)((Cactus)this.cA.get(b)).x + this.migos, ((Cactus)this.cA.get(b)).y + this.migos, ((Cactus)this.cA.get(b)).width - this.migos * 2, ((Cactus)this.cA.get(b)).height - this.migos); 
  }
  
  public void collideFloor() {
    if ((this.dH.y + this.dH.height) + this.vS >= this.gH.y) {
      this.vS -= this.vS;
      this.dy = this.gY - this.dh + 1;
      this.cJ = this.mcJ;
    } else {
      gravity();
    } 
    updateHitboxes();
  }
  
  public void collideCactus() {
    for (byte b = 0; b < this.cA.size(); b++) {
      if (this.dH.intersects(((Cactus)this.cA.get(b)).hitbox))
        this.dd = true; 
    } 
    updateHitboxes();
  }
  
  public void gravity() {
    this.vS += 0.6D;
  }
  
  public void movement() {
    if (this.uK && this.cJ > 0 && this.dw != 59) {
      this.cJ--;
      this.vS = this.jS;
    } else if (this.dH.intersects(this.gH)) {
      if (this.dK) {
        this.dg = true;
        this.dw = 59;
        this.dy += this.dh - 29;
        this.dh = 29;
      } 
    } else {
      if (this.dK && !this.dH.intersects(this.gH))
        this.vS++; 
      this.cJ = 0;
    } 
  }
  
  public void spawnCactus() {
    this.cA.add(new Cactus(800 - (int)(Math.random() * 80.0D), 0));
    this.cT = 0;
  }
  
  public static void main(String[] paramArrayOfString) {
    DinoGame dinoGame = new DinoGame("Gemastik 2022");
    dinoGame.restart();
    while (true) {
      dinoGame.run();
      dinoGame.info();
      dinoGame.repaint();
      try {
        Thread.sleep(fr);
      } catch (Exception exception) {}
    } 
  }
  
  public void moveCacti() {
    this.cT++;
    if (this.cT >= this.cS * (this.dM + (int)(Math.random() * 8.0D - 4.0D)))
      spawnCactus(); 
    byte b;
    for (b = 0; b < this.cA.size(); b++) {
      if (!((Cactus)this.cA.get(b)).bird) {
        ((Cactus)this.cA.get(b)).x -= this.cS;
        ((Cactus)this.cA.get(b)).y = this.gY - ((Cactus)this.cA.get(b)).height;
        if (((Cactus)this.cA.get(b)).x + ((Cactus)this.cA.get(b)).width <= 0.0D) {
          this.cA.remove(b);
          this.cS += 0.05D;
        } 
      } else {
        ((Cactus)this.cA.get(b)).x -= this.cS * 0.9D;
        if (((Cactus)this.cA.get(b)).rng < 0.33D) {
          ((Cactus)this.cA.get(b)).y = this.gY - ((Cactus)this.cA.get(b)).height - 2;
        } else if (((Cactus)this.cA.get(b)).rng < 0.66D) {
          ((Cactus)this.cA.get(b)).y = this.gY - this.sH - ((Cactus)this.cA.get(b)).height / 2;
        } else {
          ((Cactus)this.cA.get(b)).y = this.gY - this.sH - ((Cactus)this.cA.get(b)).height * 2;
        } 
        if (((Cactus)this.cA.get(b)).x + ((Cactus)this.cA.get(b)).width <= 0.0D) {
          this.cA.remove(b);
          this.cS += 0.05D;
        } 
      } 
    } 
    for (b = 0; b < this.cL.size(); b++) {
      ((Cloud)this.cL.get(b)).x = (int)(((Cloud)this.cL.get(b)).x - this.clS);
      if (((Cloud)this.cL.get(b)).x + ((Cloud)this.cL.get(b)).rad1 * 4 <= 0) {
        ((Cloud)this.cL.get(b)).x = 700 + (int)(Math.random() * 50.0D);
        ((Cloud)this.cL.get(b)).y = 30 + (int)(Math.random() * 500.0D / 3.0D * 1.25D);
        ((Cloud)this.cL.get(b)).rad1 = 10 + (int)(Math.random() * 40.0D + 1.0D);
        ((Cloud)this.cL.get(b)).rad2 = 5 + (int)(Math.random() * 10.0D + 1.0D);
      } 
    } 
  }
  
  public void restart() {
    this.cS = 6.0D;
    this.cT = 0;
    this.dM = this.sdM;
    this.dx = this.sX;
    this.dy = this.sY;
    this.dw = this.sW;
    this.dh = this.sH;
    this.vS = 0.0D;
    if (this.s > this.hs)
      this.hs = this.s; 
    this.s = 0;
    this.cA = new ArrayList<>();
    this.dd = false;
    spawnCactus();
  }
  
  public void info() {}
  
  public void keyTyped(KeyEvent paramKeyEvent) {}
  
  public void keyPressed(KeyEvent paramKeyEvent) {
    if (paramKeyEvent.getKeyCode() == 38)
      this.uK = true; 
    if (paramKeyEvent.getKeyCode() == 40)
      this.dK = true; 
    if (paramKeyEvent.getKeyCode() == 37)
      this.lK = true; 
    if (paramKeyEvent.getKeyCode() == 39)
      this.rK = true; 
    if (paramKeyEvent.getKeyCode() == 32)
      this.sK = true; 
  }
  
  public void keyReleased(KeyEvent paramKeyEvent) {
    if (paramKeyEvent.getKeyCode() == 38)
      this.uK = false; 
    if (paramKeyEvent.getKeyCode() == 40) {
      this.dK = false;
      if (this.dg) {
        this.dy = this.gY - this.dh;
        this.dg = false;
        this.dw = this.sW;
        this.dh = this.sH;
      } 
      if (!this.dH.intersects(this.gH))
        this.vS -= 3.0D; 
    } 
    if (paramKeyEvent.getKeyCode() == 37)
      this.lK = false; 
    if (paramKeyEvent.getKeyCode() == 39)
      this.rK = false; 
    if (paramKeyEvent.getKeyCode() == 32)
      this.sK = false; 
  }
}
