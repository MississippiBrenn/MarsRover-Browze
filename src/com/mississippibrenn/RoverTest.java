package com.mississippibrenn;

import static org.junit.jupiter.api.Assertions.*;

class RoverTest {
    Rover roverTester = new Rover();

    @org.junit.jupiter.api.Test
    void roverNewLocation() {
        fail("This test not implemented");
    }

    @org.junit.jupiter.api.Test
    void roveTheRover() {
        fail("This test not implemented");
    }

    @org.junit.jupiter.api.Test
    void rotateRover() {
        int rotatedRover = roverTester.rotateRover(0, 'R');
        assertEquals(rotatedRover, 1);

    }

    @org.junit.jupiter.api.Test
    void nextMove() {
        int[] currLocation = roverTester.nextMove(2, 4, 2);
        assertEquals(currLocation[0], 2);
        assertEquals(currLocation[1], 5);
        assertEquals(currLocation[2], 2);


    }

    @org.junit.jupiter.api.Test
    void landingLocation() {
        int[] landing = roverTester.landingLocation("Rover2 Landing:3 3 E");
        assertEquals(landing[0], 3);
        assertEquals(landing[1], 3);
        assertEquals(landing[2], 1);

    }

    @org.junit.jupiter.api.Test
    void parseDirection() {
        int north = roverTester.parseDirection("N");
        assertEquals(north, 0);
    }

    @org.junit.jupiter.api.Test
    void matrixGrid() {

       int[][] matrix = roverTester.matrixGrid("Plateau:5 5");
        assertEquals(matrix[0].length, 5);
        assertEquals(matrix.length, 5);

    }
}