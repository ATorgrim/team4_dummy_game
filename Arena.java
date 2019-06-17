import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.*;
import java.util.*;
import javax.swing.Timer;
import java.util.Random;

public class Arena extends JPanel{
	public class Object {
		int x,y ; // declare the x,y coordinate for the Player
	    int size; // declare the size for the player
	    Color color; // declare the color for my player
	    ITEM_TYPE type;
	    
	    // create a constructor for Object
	    Object(int x, int y, int size, Color color, ITEM_TYPE type){
	        this.x = x;
	        this.y = y;
	        this.size = size;
	        this.color = color;
	        this.type = type;
	    }
	}
	
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
	
	static int score;
	static int level;
	
	Arena() {
		myObjects = new Object[ARENA_WIDTH][ARENA_HEIGHT];
		createObject(0, 0, 20, ITEM_TYPE.PLAYER);
		player_x = player_y = 0;
		score = 0;	
		level = 0;
		
		addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent evt) {
                eventHandler(evt);
            }
        });
		
		refreshScreen();
	}
	
	public void eventHandler(KeyEvent evt) {
		int old_X = player_x;
		int old_Y = player_y;
		
		
	     switch (evt.getKeyCode()) {
	            case KeyEvent.VK_DOWN:
	            	player_x++;
	            	if (player_x >= ARENA_WIDTH)
	            		player_x = ARENA_WIDTH - 1;
	                break;
	            case KeyEvent.VK_UP:
	                player_x--;
	                if (player_x < 0)
	                	player_x = 0;
	                break;
	            case KeyEvent.VK_LEFT:
	            	player_y--;
	                if (player_y < 0)
	                	player_y = 0;
	                break;
	            case KeyEvent.VK_RIGHT:
	            	player_y++;
	            	if (player_y >= ARENA_HEIGHT)
	            		player_y = ARENA_HEIGHT - 1;
	                break;
	        }
	 
	     	moveObject(old_X, old_Y, player_x, player_y);
	        this.repaint();
	    }
    
	public void createObject(int x, int y, int size, ITEM_TYPE type) {
		if (type == ITEM_TYPE.PLAYER) {
			myObjects[x][y] = new Object(0, 0, size, Color.black, ITEM_TYPE.PLAYER);
			myObjects[x][y].x = y * (ITEM_SIZE + OFFSET) + OFFSET + (MAX_ITEM_SIZE - myObjects[x][y].size) / 2;
			myObjects[x][y].y = x * (ITEM_SIZE + OFFSET) + OFFSET + (MAX_ITEM_SIZE - myObjects[x][y].size) / 2;
		}
		else {
			switch (type) {
			case RED_FOOD:
				myObjects[x][y] = new Object(0, 0, INIT_FOOD_SIZE, Color.red, ITEM_TYPE.RED_FOOD);
				break;
			case BLUE_FOOD:
				myObjects[x][y] = new Object(0, 0, INIT_FOOD_SIZE, Color.blue, ITEM_TYPE.BLUE_FOOD);
				break;
			case YELLOW_FOOD:
				myObjects[x][y] = new Object(0, 0, INIT_FOOD_SIZE, Color.yellow, ITEM_TYPE.YELLOW_FOOD);
				break;
			}
			myObjects[x][y].x = y * (ITEM_SIZE + OFFSET) + OFFSET + (MAX_ITEM_SIZE - myObjects[x][y].size) / 2;
			myObjects[x][y].y = x * (ITEM_SIZE + OFFSET) + OFFSET + (MAX_ITEM_SIZE - myObjects[x][y].size) / 2;
		}
	}
    
	public void deleteObject(int x, int y) {
		myObjects[x][y] = null;
	}
	
	public void moveObject(int old_X, int old_Y, int new_X, int new_Y) {
		int old_score = score;
		// TODO: change score if new_X new_Y is food.
		if (myObjects[new_X][new_Y] != null && myObjects[new_X][new_Y].type != ITEM_TYPE.PLAYER) {
			switch (myObjects[new_X][new_Y].type) {
			case RED_FOOD: score += 1; break;
			case BLUE_FOOD: score += 2; break;
			case YELLOW_FOOD: score += 3; break;					
			}
						
			scoreDisplay.setText("Score: " + score);
			if ((old_score / 10) != (score / 10)) {
				level++;
				levelDisplay.setText("Level: " + level);	
				myObjects[old_X][old_Y].size += 10;
				if (myObjects[old_X][old_Y].size > MAX_ITEM_SIZE)
					myObjects[old_X][old_Y].size = MAX_ITEM_SIZE;
			}
			
			
		}
			
		
		if (myObjects[old_X][old_Y] != null) {			
			//System.out.println(myObjects[old_X][old_Y].size);
			createObject(new_X, new_Y, myObjects[old_X][old_Y].size, myObjects[old_X][old_Y].type);
			if (!(old_X == new_X && old_Y == new_Y))
				deleteObject(old_X, old_Y);
		}
		
	}
	
	@Override
    public void paint(Graphics g){ // draw myPlayer
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
    
    public static void displayJFrame() {
    	JFrame frame= new JFrame();    	    	
    	
		Arena arena = new Arena();
		arena.setLayout(null);
		arena.setFocusable(true);
		arena.requestFocusInWindow();
		
		scoreDisplay = new JLabel("Score: " + score);
    	levelDisplay = new JLabel("Level: " + level); 
    	scoreDisplay.setBounds(40, 600, 100, 50);
    	levelDisplay.setBounds(140, 600, 100, 50);
    	arena.add(scoreDisplay);
    	arena.add(levelDisplay);
    	
		
		frame.add(arena);
		frame.setTitle("Testing");
		frame.setSize(950, 700);
		frame.setVisible(true);
				
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
	    frame.setLocation(x, y);
    }
    
    public static void main(String[] args) {   
    	SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                displayJFrame();
            }
        });
    }
    
    public void refreshScreen() {
        timer = new Timer(0, new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
        	boolean collision = true;
        	
        	while (collision) {      
	        	Random rand = new Random();
	        	int x = rand.nextInt(ARENA_WIDTH);
	        	int y = rand.nextInt(ARENA_HEIGHT);
	        	
	        	if (myObjects[x][y] != null) continue;
	        	
	        	int type = rand.nextInt(3);
	        	
	        	switch (type) {
	        	case 0: createObject(x, y, INIT_FOOD_SIZE, ITEM_TYPE.RED_FOOD); break;
	        	case 1: createObject(x, y, INIT_FOOD_SIZE, ITEM_TYPE.BLUE_FOOD); break;
	        	case 2: createObject(x, y, INIT_FOOD_SIZE, ITEM_TYPE.YELLOW_FOOD); break;
	        	}
	        	
	        	break;
        	}
        	
            repaint();
          }
        });
        timer.setRepeats(true);
        timer.setDelay(2000);
        timer.start();
      }
}
