import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


public class Rainfall {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String args[]) throws IOException {

	        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
	        String s = br.readLine();
	        int dim = Integer.parseInt(s);
	        int [][] map = new int [dim][dim];
	        int [][] basinMap = new int [dim][dim];
	        for (int i=0; i<dim;i++){
	        	s = br.readLine();
	        	String [] row = s.split("\\s+");
	        	for (int j=0; j<row.length;j++){
	        		map[i][j] = Integer.parseInt(row[j]);
	        		basinMap [i][j]=0;

	        	}

	        }
	        
	        List<Integer> basinCount = new ArrayList<Integer>();
	        for (int i=0; i<dim;i++){

	        	for (int j=0; j<dim;j++){
	        		
	        		Stack<Point> points = new Stack<Point>();
	        		
	        		points.push(new Point(i,j));
	        		
	        		while(!points.isEmpty()){
	        			

	        	            Point point = points.pop();


	        	            if (basinMap[point.x][point.y] > 0)
	        	                continue;


	        	            Point lowestNeighbor = getLowestNeighbor(map, point);


	        	            if (lowestNeighbor.x == point.x && lowestNeighbor.y == point.y){
	        	                basinMap[point.x][point.y] = basinCount.size() + 1;
	        	                basinCount.add(1);
	        	                continue;
	        	            }

	        	            if (basinMap[lowestNeighbor.x][lowestNeighbor.y] > 0){

	        	            	basinMap[point.x][point.y] = basinMap[lowestNeighbor.x][lowestNeighbor.y];
	        	            	basinCount.set(basinCount.get(basinMap[lowestNeighbor.x][lowestNeighbor.y] - 1),  basinCount.get(basinMap[lowestNeighbor.x][lowestNeighbor.y] - 1)+ 1);
	        	                continue;
	        	            }

	        	            points.push(point);
	        	            points.push(lowestNeighbor);

	        		}

	        	}

	        }
	        
	        int [] results=new int [basinCount.size()];
	        int i=0;
	        for (Integer j:basinCount){
	        	results[i]=j;
	        	i++;

	        }
	        
	        int j;
	        boolean flag = true;   
	        int temp;  

	        while ( flag )
	        {
	               flag= false;    
	               for( j=0;  j < results.length -1;  j++ )
	               {
	                      if ( results[ j ] < results[j+1] )  
	                      {
	                              temp = results[ j ];                
	                              results[ j ] = results[ j+1 ];
	                              results[ j+1 ] = temp;
	                             flag = true;             
	                     } 
	               } 
	         } 
	        
	        
	        for (int x=0;x<results.length;x++){
	        	System.out.print(results[x]);
	        	System.out.print(" ");
	        }
	        
	        
	        
	        
	        System.out.print("\n");

	}
	
	static Point getLowestNeighbor(int [][] map, Point point){

	    int dim = map.length;
	    int x =point.x;
	    int y = point.y;
	    List<Point> potentialPoints = new LinkedList<Point>();
	    potentialPoints.add(new Point (x + 1, y));
	    potentialPoints.add(new Point (x - 1, y));
	    potentialPoints.add(new Point (x, y + 1));
	    potentialPoints.add(new Point (x, y - 1));
	    Point lowestPoint = point;
	    
	    for (Point p : potentialPoints){
	        if (p.x >= 0 && p.x < dim &&  p.y >= 0 && p.y < dim && map[p.x][p.y] < map[lowestPoint.x][lowestPoint.y])
	            lowestPoint = p;
	    }
	    return lowestPoint;
	

	}
}
