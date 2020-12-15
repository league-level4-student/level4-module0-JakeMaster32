package _04_Maze_Maker;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class MazeMaker {

	private static int width;
	private static int height;

	private static Maze maze;

	private static Random randGen = new Random();
	private static Stack<Cell> uncheckedCells = new Stack<Cell>();

	public static Maze generateMaze(int w, int h) {
		width = w;
		height = h;
		maze = new Maze(width, height);

		// 4. select a random cell to start

		Cell random = maze.getCell(randGen.nextInt((maze.getWidth())), randGen.nextInt(maze.getHeight()));

		// 5. call selectNextPath method with the randomly selected cell
		selectNextPath(random);

		return maze;
	}

	// 6. Complete the selectNextPathMethod
	private static void selectNextPath(Cell currentCell) {
		// A. mark cell as visited
		currentCell.setBeenVisited(true);
		// B. Get an ArrayList of unvisited neighbors using the current cell and the
		// method below
		ArrayList<Cell> unvisited = getUnvisitedNeighbors(currentCell);
		// C. if has unvisited neighbors,
		if (unvisited.size() > 0) {

			// C1. select one at random.
			Cell randomNeighbor = unvisited.get(randGen.nextInt(unvisited.size()));
			// C2. push it to the stack
			uncheckedCells.push(randomNeighbor);
			// C3. remove the wall between the two cells
			removeWalls(currentCell, randomNeighbor);
			// C4. make the new cell the current cell and mark it as visited
			currentCell = randomNeighbor;
			currentCell.setBeenVisited(true);
			// C5. call the selectNextPath method with the current cell
			selectNextPath(currentCell);
		}

		// D. if all neighbors are visited
		Boolean allVisited = false;
		if (unvisited.size() == 0) {
			allVisited = true;
		} else {
			allVisited = false;
		}

		// D1. if the stack is not empty
		if (allVisited == true && uncheckedCells.size() > 0) {
			// D1a. pop a cell from the stack
			currentCell = uncheckedCells.pop();
			// D1b. make that the current cell

			// D1c. call the selectNextPath method with the current cell
			selectNextPath(currentCell);
		}
	}

	// 7. Complete the remove walls method.
	// This method will check if c1 and c2 are adjacent.
	// If they are, the walls between them are removed.
	private static void removeWalls(Cell c1, Cell c2) {
		//if ((c1.getX() + 1 < maze.getWidth()) && c1.getX() + 1 == c2.getX() && c1.getY() == c2.getY()) {
		//	c1.setEastWall(false);
		//	c2.setWestWall(false);
		//}
		//if ((c1.getX() - 1 > 0) && c1.getX() - 1 == c2.getX() && c1.getY() == c2.getY()) {
		//	c1.setWestWall(false);
		//	c2.setEastWall(false);
		//}
		//if ((c1.getY() + 1 < maze.getHeight()) && c1.getY() + 1 == c2.getY() && c1.getX() == c2.getX()) {
		//	c1.setSouthWall(false);
		//	c2.setNorthWall(false);
		//}
		//if ((c1.getY() - 1 > 0) && c1.getY() - 1 == c2.getY() && c1.getX() == c2.getX()) {
		//	c1.setNorthWall(false);
		//	c2.setSouthWall(false);
		//}
		if (c1.getX() == c2.getX()) { if (c1.getY() > c2.getY()) { c1.setNorthWall(false); c2.setSouthWall(false); } else { c2.setNorthWall(false); c1.setSouthWall(false); } } else { if (c1.getX() > c2.getX()) { c1.setWestWall(false); c2.setEastWall(false); } else { c2.setWestWall(false); c1.setEastWall(false); } }
	}

	// 8. Complete the getUnvisitedNeighbors method
	// Any unvisited neighbor of the passed in cell gets added
	// to the ArrayList
	private static ArrayList<Cell> getUnvisitedNeighbors(Cell c) {
		//ArrayList<Cell> unvisitedCells = new <Cell>ArrayList();
		//if ((c.getX() + 1 < maze.getWidth()) && (maze.getCell(c.getX() + 1, c.getY()).hasBeenVisited() == false)) {
		//	unvisitedCells.add(maze.getCell(c.getX() + 1, c.getY()));
		//}
		//if ((c.getX() - 1 > 0) && (maze.getCell(c.getX() - 1, c.getY()).hasBeenVisited() == false)) {
		//	unvisitedCells.add(maze.getCell(c.getX() - 1, c.getY()));
		//}
	//	if ((c.getY() + 1 < maze.getHeight()) && (maze.getCell(c.getX(), c.getY() + 1).hasBeenVisited() == false)) {
	//		unvisitedCells.add(maze.getCell(c.getX(), c.getY() + 1));
	//	}
	//	if ((c.getY() - 1 > 0) && (maze.getCell(c.getX(), c.getY() -1).hasBeenVisited() == false)) {
	//		unvisitedCells.add(maze.getCell(c.getX(), c.getY() - 1));
	//	}
	//	return unvisitedCells;
		int x = c.getX(); int y = c.getY(); ArrayList<Cell> unvisitedNeighbors = new ArrayList<Cell>(); if (x > 0 && !maze.getCell(x - 1, y).hasBeenVisited()) { unvisitedNeighbors.add(maze.getCell(x - 1, y)); } if (y > 0 && !maze.getCell(x, y - 1).hasBeenVisited()) { unvisitedNeighbors.add(maze.getCell(x, y - 1)); } if (x < width - 1 && !maze.getCell(x + 1, y).hasBeenVisited()) { unvisitedNeighbors.add(maze.getCell(x + 1, y)); } if (y < height - 1 && !maze.getCell(x, y + 1).hasBeenVisited()) { unvisitedNeighbors.add(maze.getCell(x, y + 1)); } return unvisitedNeighbors;
	}
		
}
