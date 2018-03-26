
public class DemoGrids {
	
	public static GridState getStartDemoSize3(){
		GridState g = new GridState(3);
		
		g.setSquare(2, 0, 4);
		g.setSquare(2, 1, 2);
		g.setSquare(2, 2, 5);
		
		g.setSquare(1, 0, 3);
		g.setSquare(1, 1, 0);
		g.setSquare(1, 2, 1);
		
		g.setSquare(0, 0, 6);
		g.setSquare(0, 1, 7);
		g.setSquare(0, 2, 8);

		
		
		
//		g.setSquare(2, 0, 7);
//		g.setSquare(2, 1, 2);
//		g.setSquare(2, 2, 4);
//		
//		g.setSquare(1, 0, 5);
//		g.setSquare(1, 1, 0);
//		g.setSquare(1, 2, 6);
//		
//		g.setSquare(0, 0, 8);
//		g.setSquare(0, 1, 3);
//		g.setSquare(0, 2, 1);
		
		
		//samlpe1
//		g.setSquare(2, 0, 1);
//		g.setSquare(2, 1, 3);
//		g.setSquare(2, 2, 4);
//		                  
//		g.setSquare(1, 0, 8);
//		g.setSquare(1, 1, 0);
//		g.setSquare(1, 2, 5);
//		                  
//		g.setSquare(0, 0, 7);
//		g.setSquare(0, 1, 2);
//		g.setSquare(0, 2, 6);
		
		

		//sample3
		g.setSquare(2, 0, 3);
		g.setSquare(2, 1, 6);
		g.setSquare(2, 2, 4);
		
		g.setSquare(1, 0, 0);
		g.setSquare(1, 1, 1);
		g.setSquare(1, 2, 2);
		
		g.setSquare(0, 0, 8);
		g.setSquare(0, 1, 7);
		g.setSquare(0, 2, 5);
		
		//worst
		g.setSquare(2, 0, 8);
		g.setSquare(2, 1, 0);
		g.setSquare(2, 2, 6);
		
		g.setSquare(1, 0, 5);
		g.setSquare(1, 1, 4);
		g.setSquare(1, 2, 7);
		
		g.setSquare(0, 0, 2);
		g.setSquare(0, 1, 3);
		g.setSquare(0, 2, 1);
		
		
		return g;
	}
	
	public static GridState getGoalDemoSize3(){
		GridState g = new GridState(3);
		
		g.setSquare(2, 0, 0);
		g.setSquare(2, 1, 1);
		g.setSquare(2, 2, 2);
		
		g.setSquare(1, 0, 3);
		g.setSquare(1, 1, 4);
		g.setSquare(1, 2, 5);
		
		g.setSquare(0, 0, 6);
		g.setSquare(0, 1, 7);
		g.setSquare(0, 2, 8);
		
		
		
//		//sample1
//		g.setSquare(2, 0, 1);
//		g.setSquare(2, 1, 2);
//		g.setSquare(2, 2, 3);
//		                  
//		g.setSquare(1, 0, 8);
//		g.setSquare(1, 1, 0);
//		g.setSquare(1, 2, 4);
//		                  
//		g.setSquare(0, 0, 7);
//		g.setSquare(0, 1, 6);
//		g.setSquare(0, 2, 5);
		
		return g;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static GridState getStartDemoSize5(){
		GridState g = new GridState(5);
		
		g.setSquare(4, 0, 0);
		g.setSquare(4, 1, 1);
		g.setSquare(4, 2, 2);
		g.setSquare(4, 3, 3);
		g.setSquare(4, 4, 4);
		
		g.setSquare(3, 0, 5);
		g.setSquare(3, 1, 6);
		g.setSquare(3, 2, 7);
		g.setSquare(3, 3, 8);
		g.setSquare(3, 4, 9);
		
		g.setSquare(2, 0, 10);
		g.setSquare(2, 1, 11);
		g.setSquare(2, 2, 12);
		g.setSquare(2, 3, 13);
		g.setSquare(2, 4, 14);
		
		g.setSquare(1, 0, 15);
		g.setSquare(1, 1, 16);
		g.setSquare(1, 2, 17);
		g.setSquare(1, 3, 18);
		g.setSquare(1, 4, 19);
		
		g.setSquare(0, 0, 20);
		g.setSquare(0, 1, 21);
		g.setSquare(0, 2, 22);
		g.setSquare(0, 3, 23);
		g.setSquare(0, 4, 24);
		
		return g;
	}
	
	
	public static GridState getGoalDemoSize5(){
		GridState g = new GridState(5);
		
		g.setSquare(4, 0, 1);
		g.setSquare(4, 1, 2);
		g.setSquare(4, 2, 3);
		g.setSquare(4, 3, 4);
		g.setSquare(4, 4, 9);
		
		g.setSquare(3, 0, 5);
		g.setSquare(3, 1, 6);
		g.setSquare(3, 2, 7);
		g.setSquare(3, 3, 8);
		g.setSquare(3, 4, 0);
		
		g.setSquare(2, 0, 10);
		g.setSquare(2, 1, 11);
		g.setSquare(2, 2, 12);
		g.setSquare(2, 3, 13);
		g.setSquare(2, 4, 14);
		
		g.setSquare(1, 0, 15);
		g.setSquare(1, 1, 16);
		g.setSquare(1, 2, 17);
		g.setSquare(1, 3, 18);
		g.setSquare(1, 4, 19);
		
		g.setSquare(0, 0, 20);
		g.setSquare(0, 1, 21);
		g.setSquare(0, 2, 22);
		g.setSquare(0, 3, 23);
		g.setSquare(0, 4, 24);
		
		return g;
	}
	
	
}
