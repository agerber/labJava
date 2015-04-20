package lec04.glab.tetris;

import java.awt.*;
import java.util.*;

public class Grid
{

  static final int ROWS = 20;
  static final int COLS = 12;

  //I could use Game.DIM here but I decided to give Grid its own constant since
  //I use it alot
  static final int DIM = 4;

  //the 2-dimensional array of blocks
  Block[][] block;
  //an arrayList used to store accumulated blocks
  ArrayList arOccupied;
  //score object for keeping the score
  Score score;

  public Grid ()
  {
    //instantiate my members upon construction
    block = new Block[ROWS][COLS];
    initBlocks();
    arOccupied = new ArrayList();
    score = new Score();

  }


//used extensively
  synchronized public boolean requestLateral ( Widget w )
  {
    boolean[][] lt = new boolean[ROWS][COLS];
    lt = w.getLights( w.or );
    for ( int m = w.col; m < w.col + DIM; m++ )
    {
      for ( int k = w.row; k < w.row + DIM; k++ )
      {
        //if it tries to move beyond the bounds..no

        if ( lt[k - w.row][m - w.col] &&
             ( m < 0 || m >= Grid.COLS || k >= Grid.ROWS ) )
        {

          return false;
        }
        //if it tries to move into a block that's occupied...no

        if ( lt[k - w.row][m - w.col] && block[k][m].oc )
        {
          return false;
        }
      }
    }
    //ok
    return true;

  }


//used extensively
  synchronized public boolean requestDown ( Widget w )
  {

    boolean[][] lt = new boolean[ROWS][COLS];
    lt = w.getLights( w.or );
    for ( int m = w.col; m < w.col + DIM; m++ )
    {
      for ( int k = w.row; k < w.row + DIM; k++ )
      {

        //if it goes out of bounds..no
        if ( lt[k - w.row][m - w.col] &&
             k >= Grid.ROWS )
        {

          return false;
        }
        //if it tries to move into a block that's occupied...no

        if ( lt[k - w.row][m - w.col] && block[k][m].oc )
        {
          return false;
        }

      }
    }
    //is ok
    return true;

  }


  //this method sets blocks to the grid
  synchronized public void setBlocks ( Widget w )
  {

    boolean[][] lt = new boolean[ROWS][COLS];
    lt = w.getLights( w.or );
    Color c = w.color;

    //first set all the blocks to black and unoccupied

    for ( int k = 0; k < ROWS; k++ )
    {
      for ( int m = 0; m < COLS; m++ )
      {
        block[k][m] = new Block( false, Color.black, k, m );
      }

    }

    //then draw the widget beginning with it's upperLeft coord
    for ( int m = w.col; m < w.col + DIM; m++ )
    {
      for ( int k = w.row; k < w.row + DIM; k++ )
      {

        if ( lt[k - w.row][m - w.col] )
        {
          //occupied, color, row, column
          block[k][m] = new Block( false, c, k - w.row, m - w.col );

        }

      }
    }

    //then the arrayList of occupied blocks
    for ( int k = 0; k < arOccupied.size(); k++ )
    {
      //draw the array of blocks
      Block b = ( Block )arOccupied.get( k );
      block[b.row][b.col] = new Block( true, b.color, b.row, b.col );

    }

  }


  synchronized public void checkFullRow ()
  {

    //to check for full row
    LinkedList llRow = new LinkedList();
    //to reposition blocks down
    LinkedList llReposit = new LinkedList();

    //start at the bottom of the arrayList until the top row is reached
    //iterate from the back to the beginning...otherwise removing will
    //not work properly
    int m = Grid.ROWS - 1;
    while ( m >= 0 )
    {

      //iterate through the arrayList
      for ( int k = arOccupied.size() - 1; k >= 0; k-- )
      {

        Block b = ( Block )arOccupied.get( k );
        if ( b.row == m )
        {

          //the integer value is the key
          llRow.add( new Integer( k ) );

        }

      }

      //if the size of the queue is equal to Grid.COLS
      //then there is a complete row

      if ( llRow.size() == Grid.COLS )
      {

        //this picks off the values of llRow from the beginning... removeFirst returns an 0bj
        //uses that integer values stored in llRow to do it. Notice the FIFO or queue nature
        //of the linked-list
        while ( llRow.size() > 0 )
        {

          Block blk = ( Block )arOccupied.remove( ( ( Integer )llRow.
              removeFirst() ).intValue() );
          score.addScore( blk.points() );

        }

        //check for highScore
        if ( score.getScore() > score.getHighScore() )
        {
          score.setHighScore( score.getScore() );
        }

        //this would be an appropriate time to check to increase difficulty,
        //since I just increased the score.
        score.checkThresh();

        //ok, time to reposition the blocks
        //I've used a seperate data structure called llReposit
        for ( int p = arOccupied.size() - 1; p >= 0; p-- )
        {
          Block b = ( Block )arOccupied.get( p );

          //if its above the row that is being deleted
          if ( b.row < m )
          {

            arOccupied.remove( p ); //use the index number to delete it

            b.row++; //increment the row (move it down)
            llReposit.add( b ); //add this block to the temp linkedList

          }

        }

        //now put the blocks back where they belong
        //and clear llReposit
        while ( llReposit.size() > 0 )
        {
          arOccupied.add( llReposit.removeLast() ); //removeLast both removes the obj and returns a ref to it.

        }


        //clear both linkedLists
        llRow.clear();
        llReposit.clear();

        //no need to decrement the counter m, since we are going to check the next
        //highest row (which has just been moved down into the current row).  The only time the
        //counter moves up then is when there is an incomplete row




      }
      //stop this method if there are no blocks in a row
      else if ( llRow.size() == 0 )
      {
        return;

      }

      else  //there is an incomplete row (neither empty nor full)
      {

       //reset the linkedList that tests for row
        llRow.clear();
        //decrement the row (move up one)
        m--;

      }

    } //end while loop that tests iterates through rows

  } //end meth checkFullRow

//this method checks for game over condition
  synchronized public void topRow ()
  {

    for ( int k = 0; k < arOccupied.size(); k++ )
    {
      Block b = ( Block )arOccupied.get( k );
      if ( b.row <= Widget.DIM )
      {
        //setting this flag to false... ends the game.
        Game.bPlaying = false;
        purgeGrid();


      }

    }

  }//end meth topRow


  synchronized public void addOccupied ( Widget w )
  {
    boolean[][] lt = new boolean[ROWS][COLS];
    lt = w.getLights( w.or );
    Color c = w.color;
    // int row = w.row;
    //int col = w.col;

    for ( int m = w.col; m < w.col + DIM; m++ )
    {
      for ( int k = w.row; k < w.row + DIM; k++ )
      {
        if ( lt[k - w.row][m - w.col] )
        {
          arOccupied.add( new Block( true, c, k, m ) );
        }

      }
    }

  }


  synchronized private void purgeGrid ()
  {
    initBlocks();
    arOccupied.clear();

  }


  //just inits the blocks
  synchronized public void initBlocks ()
  {

    //first set all the blocks to black and not occupied

    for ( int k = 0; k < ROWS; k++ )
    {
      for ( int m = 0; m < COLS; m++ )
      {
        block[k][m] = new Block( false, Color.black, k, m );
      }

    }

  } //end initBlocks


  synchronized public Block[][] getBlocks ()
  {

    //return the grid blocks
    return block;

  }

} //end class
