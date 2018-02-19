package model;

public class TestJunit {



    public String verticalWin(){

        Grid grid = new Grid();
        Coordinates coor = new Coordinates(0,2);
        grid.setCellStatus(coor,1);

        Coordinates coor1 = new Coordinates(1,2);
        grid.setCellStatus(coor1,1);

        Coordinates coor2 = new Coordinates(2,2);
        grid.setCellStatus(coor2,1);

        if(grid.isFree(coor)==false){
            if(grid.isFree(coor1) ==false){
                if(grid.isFree(coor2)==false){
                    return "true";
                }
            }
        }
        return "false";
    }

    public String horizontalWin(){
        Grid grid = new Grid();
        Coordinates coor = new Coordinates(2,1);
        grid.setCellStatus(coor,1);

        Coordinates coor1 = new Coordinates(2,2);
        grid.setCellStatus(coor1,1);

        Coordinates coor2 = new Coordinates(2,3);
        grid.setCellStatus(coor2,1);

        if(grid.isFree(coor)==false){
            if(grid.isFree(coor1) ==false){
                if(grid.isFree(coor2)==false){
                    return "true";
                }
            }
        }
        return "false";
    }



}
