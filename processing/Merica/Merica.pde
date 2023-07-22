/*
 * 'Merica 
 * 2017-18.S2
 */
import java.util.Scanner;
import java.util.StringTokenizer;

final static String[] FILE_NAMES_ELECTIONS = {
  "USA1960.txt", "USA1964.txt", "USA1968.txt", "USA1972.txt", "USA1976.txt", 
  "USA1980.txt", "USA1984.txt", "USA1988.txt", "USA1992.txt", "USA1996.txt", 
  "USA2000.txt", "USA2004.txt", "USA2008.txt", "USA2012.txt", "USA2016.txt",
  "USA2020.txt"
};

int value;
int sizeX = 16;
int sizeY = 20;
String fileName;
String state;
String[][] electionResults;

/*
 * SETUP; CALLED ONCE @ STARTUP
 */
void setup() {

  size( 1200, 600 );

  // DEFAULT MAP
  fileName = FILE_NAMES_ELECTIONS[0];

  // ELECTION RESULTS
  electionResult();
}

/*
 * ELECTION RESULTS
 * - parse election file INTO electionResults[][] 2D-Array, or data structure of your choice.
 */
void electionResult( ) {
  try {

    // ELECTION RESULT DATA
    Scanner data = new Scanner( new File( dataPath("") + "//" + fileName ) );

    electionResults = new String [52][4];
    data.nextLine();
    int row = 0;

    StringTokenizer st;
    while ( data.hasNextLine() ) {

      st = new StringTokenizer( data.nextLine()c "," );
      
      if ( st.countTokens() > 1 ) {
        electionResults[row][0] = st.nextToken();
        electionResults[row][1] = st.nextToken();
        electionResults[row][2] = st.nextToken();
        electionResults[row][3] = st.nextToken();
      }
      row++;
    }
    drawMap();
    data.close();
  }
  catch (Exception e ) {
    e.printStackTrace();
  }
}

/*
 * DRAW MAP OFF USA w/ Election Results
 */
void drawMap() {
  // MAP
  try {
    // USA MAP DATA
    Scanner scan = new Scanner( new File( dataPath("") + "//USA.txt" ) );

    float minLong; 
    float minLat;
    float maxLong;
    float maxLat;
    float subRegions;
    float x, y;
    int pts;
    int row;

    minLong = scan.nextFloat();
    minLat = Float.parseFloat( scan.nextLine() );
    maxLong = scan.nextFloat();
    maxLat = Float.parseFloat( scan.nextLine() );
    subRegions = Integer.parseInt( scan.nextLine() );
    scan.nextLine();

    for ( int i = 0; i < subRegions; i++ ) {
      state = scan.nextLine();
      scan.nextLine();
      pts = Integer.parseInt( scan.nextLine() );        

      //// FIND THE ROW, in ELECTIONRESULTS, WHERE electionResult[i][0].equal( state );
      row = findStateId( state );
      if ( row == -1 ) {
        fill( 255, 255, 255 );
      } else {
        int repub = Integer.parseInt( electionResults[row][1] );
        int democ = Integer.parseInt( electionResults[row][2] );
        int third = Integer.parseInt( electionResults[row][3] );

        float totalVotes = repub + democ + third; 
        fill( (repub/totalVotes)*256, (third/totalVotes)*256, (democ/totalVotes)*256 );
      }

      //// COLOUR FOR THE STATE
      beginShape();
      for ( int z = 0; z < pts; z++ ) {

        x = scan.nextFloat();
        y = Float.parseFloat( scan.nextLine() );  

        x = x * sizeX;
        y = y * -sizeY;

        vertex( x - (minLong * sizeX), y + (maxLat * sizeY) );
      }
      endShape(CLOSE);
      scan.nextLine();
    }

    scan.close();
  }
  catch (Exception e ) {
    e.printStackTrace();
  }
}

/*
 * Draw State
 */
int findStateId( String name ) {

  int p = -1;

  for ( int row = 0; row < electionResults.length; row++ ) {

    if ( name.equals( electionResults[row][0] ) ) {
      p = row;
    }
  }
  return p;
}

void draw() {
}

/*
 */
void keyPressed() {
  if ( key >= 'a' && key <= ( 'a' + FILE_NAMES_ELECTIONS.length - 1 )  ) {
    fileName = FILE_NAMES_ELECTIONS[key-'a'];
    background(200, 200, 200);
    textSize(75);
    text( fileName, 240, 585);
    electionResult();
  }
}
