package edu.uchicago.gerber.labjava.lec04.glab.tetris;

import java.awt.*;

public class LongOne extends Widget
{

  public LongOne ()
  {
    super();
    initMe();
    color = Color.red;

  }


  //initialize the boolean lights
  public void initMe ()
  {
    for ( int k = 0; k < DIM; k++ ) //the lenght of the orientations
    {
      if ( k == 0 )
      {
        lights[k][0][0] = true;
        lights[k][0][1] = true;
        lights[k][0][2] = false;
        lights[k][0][3] = false;

        lights[k][1][0] = true;
        lights[k][1][1] = true;
        lights[k][1][2] = true;
        lights[k][1][3] = false;

        lights[k][2][0] = false;
        lights[k][2][1] = false;
        lights[k][2][2] = true;
        lights[k][2][3] = true;

        lights[k][3][0] = false;
        lights[k][3][1] = false;
        lights[k][3][2] = false;
        lights[k][3][3] = false;

      }
      else if ( k == 1 )
      {
        lights[k][0][0] = false;
        lights[k][0][1] = true;
        lights[k][0][2] = false;
        lights[k][0][3] = false;

        lights[k][1][0] = true;
        lights[k][1][1] = true;
        lights[k][1][2] = false;
        lights[k][1][3] = false;

        lights[k][2][0] = false;
        lights[k][2][1] = false;
        lights[k][2][2] = false;
        lights[k][2][3] = false;

        lights[k][3][0] = false;
        lights[k][3][1] = false;
        lights[k][3][2] = false;
        lights[k][3][3] = false;

      }
      else if ( k == 2 )
      {
        lights[k][0][0] = false;
        lights[k][0][1] = false;
        lights[k][0][2] = true;
        lights[k][0][3] = false;

        lights[k][1][0] = true;
        lights[k][1][1] = true;
        lights[k][1][2] = false;
        lights[k][1][3] = false;

        lights[k][2][0] = false;
        lights[k][2][1] = false;
        lights[k][2][2] = false;
        lights[k][2][3] = false;

        lights[k][3][0] = false;
        lights[k][3][1] = false;
        lights[k][3][2] = false;
        lights[k][3][3] = false;

      }
      else
      {
        lights[k][0][0] = false;
        lights[k][0][1] = false;
        lights[k][0][2] = false;
        lights[k][0][3] = false;

        lights[k][1][0] = true;
        lights[k][1][1] = true;
        lights[k][1][2] = false;
        lights[k][1][3] = false;

        lights[k][2][0] = false;
        lights[k][2][1] = false;
        lights[k][2][2] = false;
        lights[k][2][3] = false;

        lights[k][3][0] = false;
        lights[k][3][1] = false;
        lights[k][3][2] = false;
        lights[k][3][3] = false;

      }

    }
  }

}
