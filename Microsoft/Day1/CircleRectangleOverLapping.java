package Microsoft.Day1;

public class CircleRectangleOverLapping {

public boolean checkOverlap(int radius,int xCenter,int yCenter,int x1,int y1,int x2,int y2){
  int nearest_x=Math.max(x1,Math.min(x2,xCenter));
  int nearest_y=Math.max(y1,Math.min(y2,yCenter));

  int dist_x=nearest_x-xCenter;
  int dist_y=nearest_y-yCenter;

  return  Math.pow(dist_x,2)+Math.pow(dist_y,2)<=Math.pow(radius,2);

}

 public static void main(String[] args) {
  CircleRectangleOverLapping circle=new CircleRectangleOverLapping();

  int x1=1,y1=-1,x2=3,y2=1;

  int xCenter=0,yCenter=0, radius=1;

  boolean result=circle.checkOverlap(x1,x2,y1,y2,xCenter,yCenter,radius);

  System.out.println("Does the circle intersect the rectangle? " + result);
 }

}
