public class Cloud {
  public int x;
  
  public int y;
  
  public int rad1;
  
  public int rad2;
  
  public Cloud(int paramInt1, int paramInt2) {
    this.x = paramInt1;
    this.y = paramInt2;
    this.rad1 = 10 + (int)(Math.random() * 40.0D + 1.0D);
    this.rad2 = 5 + (int)(Math.random() * 10.0D + 1.0D);
  }
}
