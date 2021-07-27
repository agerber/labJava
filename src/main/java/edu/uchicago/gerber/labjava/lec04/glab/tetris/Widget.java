package edu.uchicago.gerber.labjava.lec04.glab.tetris;

import java.awt.*;

public class Widget
{


  final static int ORN = 4; //number of orientations
  final static int DIM = 4; //dimension of bounding box
  //all nonstatic members set to protected
  int row;
  int col;
  int or; //orientation
  Color color;
  boolean[][][] lights; //every 4x4 widget has 4 orientations


  public Widget ()
  {
    //set the col to random int upon instantiation
    col = Game.r.nextInt(Grid.COLS - DIM);
    //set the orientation to random int upon instantiation
    or = Game.r.nextInt(ORN);
    //row will be automatically set to zero (top)
    lights = new boolean[ORN][DIM][DIM];

  }//end constructor




  public void moveDown ()
  {
    row++;

  } //end moveDown


  public void moveLeft ()
  {
    col--;

  }//end moveLeft


  public void moveRight ()
  {
    col++;
  }//end moveRight


  public void rotateMe ()
  {

    if ( or < 3 )
    {
      or++;
    }
    else
    {
      or = 0;

    }

  }//end rotateMe

 //get the lights, given a particular orientation
  public boolean[][] getLights ( int nOrientation )
  {
    boolean[][] b = new boolean[DIM][DIM];
    for ( int j = 0; j < DIM; j++ )
    {
      for ( int k = 0; k < DIM; k++ )
      {
        b[j][k] = lights[nOrientation][j][k];

      }
    }
    return b;

  }//end getLights

  //this mehtod does what it says.
 public Widget duplicateWidget ()
 {
   Widget w = new Widget();
   w.row = this.row;
   w.col = this.col;
   w.or = this.or;
   w.color = this.color;
   w.lights = this.lights;

   return w;

 }//end dup


}//end class
