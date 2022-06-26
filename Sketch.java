import processing.core.PApplet;

public class Sketch extends PApplet {

  // Declare Variables

  //Cell width and height
  
  int WIDTH = 45;
  int HEIGHT = 45;
  int MARGIN = 5;

  //Row and column count
  int ROW_COUNT = 10;
  int COLUMN_COUNT = 10;

  //Grid
  int[][] intGrid;

  //rows and column variables
  int intRows = 0;
  int intColumn = 0;

  //other variables
  int intCellCounter = 0;

  int intRowCellCount = 0;
  int intColCount = 0;

  int intRowCont = 0;

  
  public void settings() {
    size(500, 500);
  }

  
  public void setup() {
    background(0);
    
    intGrid = new int[ROW_COUNT][COLUMN_COUNT];
    for(int x = 0; x < ROW_COUNT; x++){
      for(int y = 0; y < COLUMN_COUNT; y++){
        intGrid[x][y] = 0;
      }
    }

  }
  
 
  public void draw() {
    //Draw grid 
    for(intRows = 0; intRows < ROW_COUNT; intRows++){
      for(intColumn = 0; intColumn < COLUMN_COUNT; intColumn++){
        int boxX = (MARGIN + WIDTH) * intColumn + MARGIN + HEIGHT/2 -25;
        int boxY = (MARGIN + HEIGHT) * intRows + MARGIN + HEIGHT/2 -25;

        //Decide Colour
        if(intGrid[intColumn][intRows] == 1){
          //Green
          fill(0,255,0);
          rect(boxX,boxY,WIDTH, HEIGHT);
        }
        if(intGrid[intColumn][intRows] == 0){
          //White
          fill(255);
          rect(boxX,boxY,WIDTH, HEIGHT);
        }
      }  

      }
    }
    //Check if mouse pressed
  
  public void mousePressed(){
    int intColCheck = mouseX/50;
    int intRowCheck = mouseY/50;
    
    //Checks selected Cells
  if(intGrid [mouseX/50][mouseY/50] == 1){
    intGrid [mouseX/50][mouseY/50] = 0;
    intCellCounter -=1;
      
    }
  else{
    if(intGrid [mouseX/50][mouseY/50] == 0){
  
      intGrid [mouseX/50][mouseY/50] = 1;
      intCellCounter +=1;
        
    }
  }
    //Makes Cells go in shape of +
  if(intColCheck < 9 && intGrid [mouseX/50+1][mouseY/50] == 1 ){
    intGrid [mouseX/50+1][mouseY/50] = 0;
    intCellCounter -=1;
      }
  else{
    if(intColCheck < 9 && intGrid [mouseX/50+1][mouseY/50] == 0 ){  
      intGrid [mouseX/50+1][mouseY/50] = 1;
      intCellCounter +=1;       
    }
  }
    if(intColCheck > 0 && intGrid [mouseX/50-1][mouseY/50] == 1){ 
      intGrid [mouseX/50-1][mouseY/50] = 0;
      intCellCounter -=1;
    }
  else{
    if(intColCheck > 0 && intGrid [mouseX/50-1][mouseY/50] == 0){          
      intGrid [mouseX/50-1][mouseY/50] = 1;
      intCellCounter +=1;
      }
    }
    if(intRowCheck < 9 && intGrid [mouseX/50][mouseY/50+1] == 1){
      intGrid [mouseX/50][mouseY/50+1] = 0;
      intCellCounter -=1;
    }
  else{
    if(intRowCheck < 9 && intGrid [mouseX/50][mouseY/50+1] == 0){
      intGrid [mouseX/50][mouseY/50+1] = 1;
      intCellCounter +=1;
      }
    }
    if(intRowCheck > 0 && intGrid [mouseX/50][mouseY/50-1] == 1){
      intGrid [mouseX/50][mouseY/50-1] = 0;
      intCellCounter -=1;
    }  
  else{
    if(intRowCheck > 0 && intGrid [mouseX/50][mouseY/50-1] == 0){
      intGrid [mouseX/50][mouseY/50-1] = 1;
      intCellCounter +=1;    
      }
    }
    //Prints cells collected and mouse clicks
    System.out.println("");
    System.out.println("Click " + "Mouse Coords: " + mouseX + " " + mouseY + " Grid Coords: (intRows: " + mouseY/50 + " Column: " + mouseX/50 + ")");
    System.out.println("Total of " + intCellCounter + " cells are selected");
    System.out.println("");
    

    for(int i = 0; i < ROW_COUNT; i++){
      for (int j = 0; j < COLUMN_COUNT; j++){
      
    //Checks amount of cells collected
        if(intGrid[j][i] == 1){
          intRowCellCount++;
        }
    //Checks consecutive selections

        if(i > 0 && i < 9){
          if(intGrid[j][i] == 1 && intGrid[j][i+1] == 1){
            intRowCont+=1;
          } 
          if(intGrid[j][i] == 1 && intGrid[j][i-1] == 1 && i==9){
            intRowCont+=1;
          }
          if(intGrid[j][i] == 1 && intGrid[j][i-1] == 1 && intGrid[j][i+1] == 1 && i < 9){
            intRowCont+=1;
           }
          }
        }
        //Prints amount of cells and amount of consecutive cells
        if (intRowCont > 0 && intRowCellCount > 2){ 
          System.out.println("There are " + intRowCont + " consecutive cells selected on Row " + i);
          intRowCont = 0;
          }
          System.out.println("There are " + intRowCellCount + " cells selected on Row " + i);
          intRowCellCount = 0;

        }

      System.out.println("");
      
       //Checks the amount of cells selected per column
      for (int l = 0; l < COLUMN_COUNT; l++){
        for(int k = 0; k < ROW_COUNT; k++){
          if(intGrid[l][k] == 1){
           intColCount++;
         }
       }
       System.out.println("There are " + intColCount + " cells selected on Column " + l);
        intColCount = 0;

      }
    }
  }