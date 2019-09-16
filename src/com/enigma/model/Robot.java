package com.enigma.model;

import java.util.Arrays;

    public class Robot {
        private Integer postX;
        private Integer postY;

        Directions directions;

        private char [] commands;
        private final String FORWARD = "F";
        private final String LEFT = "L";
        private final String RIGHT = "R";

        public Robot(Integer x, Integer y, Directions directions) {
            this.postX = x;
            this.postY = y;
            this.directions= directions;
        }

        public void setCommands(String commands){
            this.commands = commands.toCharArray();
        }

        public void turnLeft(){
            this.directions = this.directions.getLeft();
        }

        public void turnRight(){
            this.directions = this.directions.getRight();
        }

        public void forward(){
            if (directions.equals(Directions.NORTH)){
                this.postY++;
                this.directions=Directions.NORTH;
            }else if (directions.equals(Directions.EAST)){
                this.postX++;
                this.directions=Directions.EAST;
            }else if (directions.equals(Directions.WEST)){
                this.postY--;
                this.directions=Directions.WEST;
            }else if (directions.equals(Directions.SOUTH)){
                this.postX--;
                this.directions=Directions.SOUTH;
            }else {
                System.out.println("Invalid move");
            }
        }

        public void move(String movement, Directions directions) {
            if (movement.equals(RIGHT)){
                turnRight();
            }else if (movement.equals(LEFT)){
                turnLeft();
            }else if (movement.equals(FORWARD)){
                forward();
            }else {
                System.out.println(movement + ", Bukan Merupakan Perintah");
            }
        }

        public String getPost(){
            return "(" + postX + "," + postY +")" + "(" + directions + ")";
        }

        public void run(){
            for (int i=0; i < this.commands.length; i++) {
                move(String.valueOf(this.commands[i]), this.directions);
                System.out.println(this.commands[i] + getPost() + this.directions);
            }
        }

        public String print() {
            return "Robot {" +
                    "postX=" + postX +
                    ", postY=" + postY +
                    ", commands=" + Arrays.toString(commands) +
                    ", Direction=" + directions +
                    '}';
        }
    }
