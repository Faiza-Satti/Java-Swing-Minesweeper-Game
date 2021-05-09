/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfirstgui.MinesweeperGame;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
/**
 *
 * @author Faiza Satt
 */

public class Minesweeper implements ActionListener {
    boolean won=false;
    ArrayList<Mines> myMines; //array to store mines coordinates
    JFrame frame;
    JPanel upperPanel,lowerPanel, mainPanel;
    static final int WIDTH=20,HEIGHT=20;                    //for each cell
    static final int ROWS=20,COLUMNS=20;                    //grid rows and columns
    JButton[][] gameButtons=new JButton[20][20];            //buttons for making the grid
    JButton reset;                                          //to reset the count 
    int totalMines=10,leftMines=0;                          //mines count
    
    
    public Minesweeper() {
        myMines=new ArrayList<Mines>();
        frame=new JFrame("Game");
        mainPanel=new JPanel();
        reset=new JButton();
        reset.setBounds(0, 0, 100, 100);
        reset.setBackground(Color.red);
        reset.setText("Show All the Mines");
        reset.addMouseListener(new MyMouseListener());
        
        mainPanel.setBackground(Color.black);
        frame.setSize(200+WIDTH*ROWS,200+HEIGHT*COLUMNS);
        frame.setLayout(new BorderLayout(0,10));
        
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        
        frame.add(reset,BorderLayout.PAGE_START);
        mainPanel.setBounds(0, 530,100+WIDTH*ROWS, 100+HEIGHT*COLUMNS);
        mainPanel.setLayout(new GridLayout(20,20));
        frame.add(mainPanel,BorderLayout.CENTER);
        int y=0;
        int counter=0;
        while(counter<20){   
            for(int x=0;x<20;x++){
                gameButtons[x][y]=new JButton();
                gameButtons[x][y].setBackground(Color.black);
                mainPanel.add(gameButtons[x][y]);
                //gameButtons[x][y].addMouseListener(this);
            }
            y++;
            counter++;
        }
        for(int i=0;i<20;i++){
            for(int j=0;j<20;j++){
                gameButtons[i][j].addMouseListener(new MyMouseListener(i,j));
            }
            }
        frame.setVisible(true);
        
    }
        
    public static void main(String[] args){
        Minesweeper game=new Minesweeper();
        game.generateRandomMines();
        //game.generateMines();
    }
    
    public void checkWinStatus(){
        if(won==true){
            System.out.println("You won the game");
        }
        else{
            System.out.println("You failed the game");
        }
            
    }
    
    public void generateRandomMines(){
        
        Integer yyy=0,xxx=0;
        ArrayList<Integer> numbersX = new ArrayList<>();
        ArrayList<Integer> numbersY = new ArrayList<>();
        //ArrayList numbersX = new ArrayList();
        //ArrayList numbersY = new ArrayList();
        for(int i = 0; i < 10; i++)
        {
            numbersX.add(i+1);
            numbersY.add(i+1);
            
        }
        //shuffling numbers to generate random
            Collections.shuffle(numbersX);
            System.out.println(numbersX);
            Collections.shuffle(numbersY);
            System.out.println(numbersY);
            
        for(int i = 0; i < 10; i++)
        {
           xxx=numbersX.get(i);
           yyy=numbersY.get(i);
           //make an object
           Mines mine=new Mines(xxx,yyy);
           myMines.add(mine);
        }

        //int start=0,end=19;
//        int j=0;
//        int randomX=0,randomY=0;
//        Random objGenerator = new Random();
//        
//        for (int iCount = 0; iCount< 10; iCount++){
//              randomX = objGenerator.nextInt(19);
//              System.out.println("Random No X : " + randomX); 
//              randomY = objGenerator.nextInt(19);
//              System.out.println("Random No Y: " + randomY); 
//              Mines mine=new Mines(randomX,randomY);
//              if(j==0 && iCount==0){
//                  myMines.add(mine);
//                  j++;
//              }
//              if(iCount>=1 && j!=0){
//                    if(myMines.get(iCount-1).getX()==myMines.get(iCount).getX())
//                            iCount--;
//                    else if(j!=0)
//                        myMines.add(mine);
//              }
//        }
              
//              for(int i=0;i<myMines.size();i++){
//                  if(myMines.get(i).x!=randomX || myMines.get(i).y!=randomY )
//                        myMines.add(mine);
//                  else
//                      iCount--;
//              }
              
             
            for(int i=0;i<myMines.size();i++){
                  System.out.print(myMines.get(i).getX());
                  System.out.println("  "+myMines.get(i).getY());
                  System.out.println("next");
              }
            System.out.println(myMines.size());
        System.out.println("byr");
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
    }
    
   //making class within main class
    //to implement mouse control methods
    
   class MyMouseListener implements MouseListener {

       int x,y;
       
       MyMouseListener(){
           
       }
        MyMouseListener(int x, int y) {
            this.x=x;
            this.y=y;
        }

    public void mouseExited(MouseEvent arg0){
    }
    public void mouseEntered(MouseEvent arg0){
    }
    public void mousePressed(MouseEvent arg0){
    }
    public void mouseClicked(MouseEvent e){
        
         if(e.getSource()==reset){
            for(int k=0;k<10;k++){
            
                int x=myMines.get(k).getX();
                int y=myMines.get(k).getY();
                        gameButtons[x][y].setBackground(Color.red);

                }
            
        }
        else{
        
        int neighbour=0;
        Color color1=new Color(254,67,90);
        Object eventSource = e.getSource();
        System.out.println(eventSource);
        
        //neighboursme jahan bhi mine he udhr filhaal color pink krdo
        //bad me value update krni he
        
        for(int k=0;k<10;k++){
//           if(myMines.get(k).getX()==x && myMines.get(k).getY()==y){
//               gameButtons[x][y].setBackground(color1);
//               neighbour++;
//           }
//           else {
//               gameButtons[x][y].setBackground(Color.YELLOW);
//               gameButtons[x][y].setText(String.valueOf(neighbour));
//           }
           
        if(myMines.get(k).getX()==x-2 && myMines.get(k).getY()==y){
              gameButtons[x-1][y].setBackground(color1);
              neighbour++;
              gameButtons[x-1][y].setText(String.valueOf(neighbour));
           }
           else {
               gameButtons[x-1][y].setBackground(Color.YELLOW);
               
        }
        
        if(myMines.get(k).getX()==x && myMines.get(k).getY()==y-2){
              gameButtons[x][y-1].setBackground(color1);
              neighbour++;
              gameButtons[x][y-1].setText(String.valueOf(neighbour));
           }
           else {
               gameButtons[x][y-1].setBackground(Color.YELLOW);
               
        }
        
        if(myMines.get(k).getX()==x+2 && myMines.get(k).getY()==y){
              gameButtons[x+1][y].setBackground(color1);
              neighbour++;
              gameButtons[x+1][y].setText(String.valueOf(neighbour));
           }
           else {
               gameButtons[x+1][y].setBackground(Color.YELLOW);
               
        }
        
        if(myMines.get(k).getX()==x && myMines.get(k).getY()==y+2){
              gameButtons[x][y+1].setBackground(color1);
              neighbour++;
              gameButtons[x][y+1].setText(String.valueOf(neighbour));
           }
           else {
               gameButtons[x][y+1].setBackground(Color.YELLOW);
        }
        
        if(myMines.get(k).getX()==x-2 && myMines.get(k).getY()==y-2){
              gameButtons[x-1][y-1].setBackground(color1);
              neighbour++;
              gameButtons[x-1][y-1].setText(String.valueOf(neighbour));
           }
           else {
               gameButtons[x-1][y-1].setBackground(Color.YELLOW);
        }
        
        if(myMines.get(k).getX()==x+2 && myMines.get(k).getY()==y+2){
              gameButtons[x+1][y+1].setBackground(color1);
              neighbour++;
              gameButtons[x+1][y+1].setText(String.valueOf(neighbour));
           }
           else {
               gameButtons[x+1][y+1].setBackground(Color.YELLOW);
               
        }
        
        if(myMines.get(k).getX()==x-2 && myMines.get(k).getY()==y+2){
              gameButtons[x-1][y+1].setBackground(color1);
              neighbour++;
              gameButtons[x-1][y+1].setText(String.valueOf(neighbour));
           }
           else {
               gameButtons[x-1][y+1].setBackground(Color.YELLOW);
               
        }
       if(myMines.get(k).getX()==x+2 && myMines.get(k).getY()==y-2){
              gameButtons[x+1][y-1].setBackground(color1);
              neighbour++;
              gameButtons[x+1][y-1].setText(String.valueOf(neighbour));
           }
           else {
               gameButtons[x+1][y-1].setBackground(Color.YELLOW);
               
            }
       
        }
        //add numbers to buttons according to number of mines present in surroundings
        //updateNeighbourNodes();
        
        for(int k=0;k<10;k++){
        for(int i=0;i<20;i++){
            for(int j=0;j<20;j++){
                if(gameButtons[x][y].isEnabled()){
                    if(myMines.get(k).getX()==x && myMines.get(k).getY()==y){
                        won=false;
                        gameButtons[x][y].setBackground(Color.red);
                        //checkWinStatus();
                    }
                    else
                    {
                        gameButtons[x][y].setBackground(Color.yellow);
                        won=true;
                        //checkWinStatus();
                    }
                    
                }
            }
        }
        }
        checkWinStatus();
        
         }
       
        
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }
   
}

}


