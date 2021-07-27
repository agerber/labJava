package edu.uchicago.gerber.labjava.lec04.glab.tetris;

import java.awt.*;

public class Block
{

   boolean oc; //occupied
   Color color;
   int row;
   int col;




  public Block (  boolean oc, Color color, int row, int col )
  {
    this.oc = oc;
    this.color = color;
    this.row = row;
    this.col = col;


  }

  public int points()
  {
    return 100;
  }

}
