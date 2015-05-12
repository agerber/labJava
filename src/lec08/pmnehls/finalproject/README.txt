
                                     ,2Ah5si3BMr             .3HA
                         r::       ,H@G:     .;&M;           s@#@@.        .3As
           .:rS22r.     ;@@@B     .#@,    ...    @i          s#. @@:     .3@#@@       :A&r
     :sXB#@@#Hh22XX#@:  h# :@@    X@   .....  .S@@2 S5XX2A:  iB   #@r  .2@#: @9      i@MM@:     ,:
     i@A;:,         2@r:#s  .@@:  @2 ..,,,.,iB@@S.  @@SS52@2 SH    G@2s@@;  .@r    ,A@i  @M     h@@A    2i:.
      @S      ri   ,sX@XA     A@i #2 ..,,,.r@@2     s@..,.A@i5G     s@@r    ;@,   r@M,   2@.   .#h3@S  ;@##@@#
      X#  ....@@.  ;Xr@@: .    r@5.M ......:ii29Xi;  .@@@@#Ai92 ..   .   .. i@  .9@5      @G   r@, M@: A#  .;2@
      ;@r .,.   ,:s5:M@A ..@@. rs#A5S  ....    s#;@;        :Bs ...    .. G,X@ ,##:  ,s.  h@   &A   @@;#;    ;@:
       #A ... 2hS23h@9M  . sS   3;9@AS:       ;5S@@.        i@,      .... @.HB;@X  . &@2 ..@S ;#r   .@@M  .. @@
       5@. .. 9X;@2::Xi ..    .:,#:;@Xr22srrriM##i           #3irr;:,.:XSsG @#9,  ..  .  3;3@ SM  .  ,@r .. ;@S
       ,@i .   #.@  iA     .,:sAG3hS@@5 .:sX9S;               X@@@@@@@@@@#hX@@: ..     ,..A.@93i ...  ;. ., M@
        M# :;;;& #9 M@SH@@@@@@BXir;,                                   .,;riS&M@@@@@AXsXXr& 2@H  ...     rH,@i
        r@i9HHBAH@@  2hi;,                                                       .:s3B@@@#HXh@A      ,.  @:9@
          sMH2r:.                                                                         :r5G@@@@AS;2Xsi& @S
                                                                                                :SH@@@@#H:9@
                                                                                                      ,;s5hr

___________________________________________________________________________________________________________________

LINK TO DEMO VIDEO- https://www.youtube.com/watch?v=WXvOjMfTUmk

CONTROLS- Use the arrow keys to control pac man, he will automatically move in whatever direction he is
facing, provided there is not a wall in front of him. Do not hold them down, as the arrow keys do not respond as well to
being held down versus letter keys.

Press 'S' to start the game

KEY FEATURES- The game plays very true to the original Pac-Man, most notably in the ghost logic. The board consists of a
28 x 36 grid, which contains the playable space as well as life and score display. All 4 ghosts use the same logic to determine
their directions as they do in the original game, all code for ghost logic is original, based on several publications and websites
discussing the way they decide to move.

Ghosts have 3 modes: Scatter, Chase, and Frightened. They start the game in scatter mode for 7 seconds, then chase mode for 20, then
back to scatter for 7. This pattern continues for 3 cycles until they stay in perpetual chase mode.

When a PacMan eats an Energizer, one of the big dots, the ghosts enter Frightened mode and turn blue. As the levels progress,
the time that the ghosts stay frightened. When the ghosts are in frightened mode, they turn randomly.

When the ghosts are in Scatter mode, they each try to move as close to a pre-determined square as possible. When they are in chase mode
they each try to get as close to a certain target square as possible, more details on each ghosts logic are available on each ghost's
class file.

Ghosts make their decision one turn in advance. When they reach a square, they immediately look to the next square and decide
which way they will turn, if it all. Ghosts ONLY reverse direction when a mode change occurs, provided they have not just completed
a turn and are still in the same square.


BONUS LIFE- As in the original, the player is awarded a bonus life when their score reaches 10,000

FRUIT- After 70 dots, a cherry pops up and awards pac-man 100 bonus points if eaten.


In addition to these features, there are a couple of extra features:

Press 'O' for Ouija mode, this will summon an extra ghost for each time it's pressed. Avoid holding it down as ghosts spawned
    at exactly the same time will essentially act as one ghost, more on that later.

Press 'G' for Ghostbuster mode, this will give pac-man a 3 second proton-pack which will allow him to suck up ghosts and
    get him out of a jam. You only get 3 of these per game.

