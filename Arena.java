import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.Timer;
import java.util.Random;

public class Arena extends JPanel{
	// create class object for player and food
	public class Object {
		int x,y ; // declare the x,y coordinate for the Player
	    int size; // declare the size for the player
	    Color color; // declare the color for my player
	    ITEM_TYPE type; //
	    
	    // create a constructor for Object
	    Object(int x, int y, int size, Color color, ITEM_TYPE type){
	        this.x = x;
	        this.y = y;
	        this.size = size;
	        this.color = color;
	        this.type = type;
	    }
	}
	
	// create a set type for player and food
	enum ITEM_TYPE {
		PLAYER, RED_FOOD, BLUE_FOOD, YELLOW_FOOD;
	}
	
	private static final int ITEM_SIZE = 40; 
	private static final int MAX_ITEM_SIZE = 40; 
	private static final int OFFSET = 20;
	private static final int ARENA_WIDTH = 10;
	private static final int ARENA_HEIGHT = 15;
	private static final int INIT_PLAYER_SIZE = 20;
	private static final int INIT_FOOD_SIZE = 40;
	
	Object[][] myObjects; // list of objects in the arena
	int player_x;  // x-coordinate of player
	int player_y;  // y-coordinate of player
	Timer timer;
	static JLabel scoreDisplay; //= new JLabel("Score: ");
	static JLabel levelDisplay; //= new JLabel("Level: ");
	
	static int score; // declare score attribute
	static int level; // declare level attribute
	
	
	// creating a constructor for the Game Arena
	Arena() {
		myObjects = new Object[ARENA_WIDTH][ARENA_HEIGHT];
		createObject(0, 0, 20, ITEM_TYPE.PLAYER);
		player_x = player_y = 0;
		score = 0;	
		level = 0;
	
	// create a sensor of movement when key is pressed on screen
		addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent evt) {
                eventHandler(evt);
            }
        });
		
		refreshScreen();
	}
	
	// create a movement method for player using keyboard
	public void eventHandler(KeyEvent evt) {
		int old_X = player_x;
		int old_Y = player_y;
		
		// four movement cases for player
	     switch (evt.getKeyCode()) {
	            case KeyEvent.VK_DOWN: // key down case
	            	player_x++;
	            	if (player_x >= ARENA_WIDTH)
	            		player_x = ARENA_WIDTH - 1; // this condition make the player not going out of bound
	                break;
	            case KeyEvent.VK_UP: // key up case
	                player_x--;
	                if (player_x < 0)
	                	player_x = 0;
	                break; 
	            case KeyEvent.VK_LEFT: // key left case
	            	player_y--;
	                if (player_y < 0)
	                	player_y = 0;
	                break;
	            case KeyEvent.VK_RIGHT: // key right case
	            	player_y++;
	            	if (player_y >= ARENA_HEIGHT)
	            		player_y = ARENA_HEIGHT - 1; // this condition make the player not going out of bound
	                break;
	        }
	 
	     	moveObject(old_X, old_Y, player_x, player_y);
	        this.repaint();
	    }
    
	
	// method to create player position and food position
	public void createObject(int x, int y, int size, ITEM_TYPE type) {
		if (type == ITEM_TYPE.PLAYER) {
			myObjects[x][y] = new Object(0, 0, size, Color.black, ITEM_TYPE.PLAYER);
			// x-coordinate for player
			myObjects[x][y].x = y * (ITEM_SIZE + OFFSET) + OFFSET + (MAX_ITEM_SIZE - myObjects[x][y].size) / 2;
			// -coordinate for player
			myObjects[x][y].y = x * (ITEM_SIZE + OFFSET) + OFFSET + (MAX_ITEM_SIZE - myObjects[x][y].size) / 2;
		}
		else { // food case
			switch (type) {
			case RED_FOOD: // case for red food item
				myObjects[x][y] = new Object(0, 0, INIT_FOOD_SIZE, Color.red, ITEM_TYPE.RED_FOOD);
				break;
			case BLUE_FOOD: // case for blue food item
				myObjects[x][y] = new Object(0, 0, INIT_FOOD_SIZE, Color.blue, ITEM_TYPE.BLUE_FOOD);
				break;
			case YELLOW_FOOD: // case for yellow food item
				myObjects[x][y] = new Object(0, 0, INIT_FOOD_SIZE, Color.yellow, ITEM_TYPE.YELLOW_FOOD);
				break;
			}
			myObjects[x][y].x = y * (ITEM_SIZE + OFFSET) + OFFSET + (MAX_ITEM_SIZE - myObjects[x][y].size) / 2;
			myObjects[x][y].y = x * (ITEM_SIZE + OFFSET) + OFFSET + (MAX_ITEM_SIZE - myObjects[x][y].size) / 2;
		}
	}
    
	public void deleteObject(int x, int y) { //delete food item as player eat it
		myObjects[x][y] = null;
	}
	
	// Khoi Dang's main method for level up
	/* This method will represent how adding point and level up work
	 * As player move across the screen, it will eat any item on its way
	 * Depend on the color of the food item, each will have specific point
	 * Red: 1pt, Blue: 2pts, Yellow: 3pts
	 * The size of object is also increasing as level up, but max size is only 40
	 */
	public void moveObject(int old_X, int old_Y, int new_X, int new_Y) { // create a method for level up
		int old_score = score; // intialize score for comparison
		
		// identify food item, and  represents score value for each item
		if (myObjects[new_X][new_Y] != null && myObjects[new_X][new_Y].type != ITEM_TYPE.PLAYER) {
			switch (myObjects[new_X][new_Y].type) {
			case RED_FOOD: score += 1; break; // red item case
			case BLUE_FOOD: score += 2; break; // blue item case
			case YELLOW_FOOD: score += 3; break; // yellow item case 				
			}
						
			scoreDisplay.setText("Score: " + score); //display score on Frame 
			if ((old_score / 10) != (score / 10)) { //Condition for not overlapping score
				level++; // level up as player eat at least 10 objects
				levelDisplay.setText("Level: " + level);	 //display level on Frame
				myObjects[old_X][old_Y].size += 10; // size increases as level up
				if (myObjects[old_X][old_Y].size > MAX_ITEM_SIZE)
					myObjects[old_X][old_Y].size = MAX_ITEM_SIZE; // Condition for player not over max 40
			}
			
		
		}
			
		// create new food item
		if (myObjects[old_X][old_Y] != null) {			
			createObject(new_X, new_Y, myObjects[old_X][old_Y].size, myObjects[old_X][old_Y].type);
			if (!(old_X == new_X && old_Y == new_Y))
				deleteObject(old_X, old_Y); // delete an overlap newly created food item
		}
		
	}
	
	@Override
	// method to draw player and food items on frame
    public void paint(Graphics g){ 
    	super.paint(g);
    	
    	for (Object[] row : myObjects) {
    		for (Object item : row) {
    			if (item != null) {
    				g.setColor(item.color);
        			g.fillOval(item.x, item.y, item.size, item.size);
    			}    			
    		}
    	}
    }
    
	// method to display frame for game
    public static void displayJFrame() {
    	JFrame frame= new JFrame();    // create a new Frame	    	
    	
		Arena arena = new Arena(); // create a new Arena for level up xp
		
		// set up to display the screen
		arena.setLayout(null);
		arena.setFocusable(true);
		arena.requestFocusInWindow();
		
		scoreDisplay = new JLabel("Score: " + score);
    	levelDisplay = new JLabel("Level: " + level); 
    	scoreDisplay.setBounds(40, 600, 100, 50); //position where score will display
    	levelDisplay.setBounds(140, 600, 100, 50); //position where level will display
    	arena.add(scoreDisplay); // display score
    	arena.add(levelDisplay); // display level
		frame.add(arena);
		frame.setTitle("Level up XP"); // name of the Game
		frame.setSize(950, 700);
		frame.setVisible(true);
		
		// set frame at the center of the screen
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
	    frame.setLocation(x, y);
    }
    
    
    // main method to test level up, and score method
    public static void main(String[] args) {   
    	SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                displayJFrame();
            }
        });
    }
    
    // method to spawn random food items at random location
    public void refreshScreen() {
        timer = new Timer(0, new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
        	boolean collision = true;
        	
        	// spawn random food item
        	while (collision) {      
	        	Random rand = new Random();
	        	int x = rand.nextInt(ARENA_WIDTH); // x-coordinate for new food item
	        	int y = rand.nextInt(ARENA_HEIGHT); // y- coordinate for new food item
	        	
	        	if (myObjects[x][y] != null) continue; // do not create if exist one
	        	
	        	int type = rand.nextInt(3); // declare random integer for food case spawn
	        	
	        	switch (type) { // 3 cases for food item
	        	case 0: createObject(x, y, INIT_FOOD_SIZE, ITEM_TYPE.RED_FOOD); break;
	        	case 1: createObject(x, y, INIT_FOOD_SIZE, ITEM_TYPE.BLUE_FOOD); break;
	        	case 2: createObject(x, y, INIT_FOOD_SIZE, ITEM_TYPE.YELLOW_FOOD); break;
	        	}
	        	
	        	break;
        	}
        	
            repaint(); // paint the new random food item
          }
        });
        
        // set time for food to be spawned
        timer.setRepeats(true);
        timer.setDelay(2000);
        timer.start();
      }
}
