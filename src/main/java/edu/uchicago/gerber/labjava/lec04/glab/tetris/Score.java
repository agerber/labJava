package edu.uchicago.gerber.labjava.lec04.glab.tetris;

public class Score
{
  //score data
  private int nScore;
  private int nHighScore;
  private int nThresh;

//constructor
  public Score ()
  {
    nThresh = 2400;
    nScore = 0;
    nHighScore = 0;
  }


  public void checkThresh ()
  {

    if ( nScore > nThresh && Game.nAutoDelay > 30)
    {
      nThresh += Game.PNT; //add another 2400 to the threshold amount
      Game.nAutoDelay -= 15; //make the game more difficult
    }

  }


  //methods for access to scoring data
  public int getScore ()
  {
    return nScore;
  }


  public void addScore ( int aNScore )
  {
    nScore += aNScore;
  }


  public void setScore ( int aNScore )
  {
    nScore = aNScore;
  }


  public int getHighScore ()
  {
    return nHighScore;
  }


  public void setHighScore ( int aNHighScore )
  {
    nHighScore = aNHighScore;
  }


  public int getThresh ()
  {
    return nThresh;
  }


  public void setThresh ( int aNThresh )
  {
    nThresh = aNThresh;
  }

}
