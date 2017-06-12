package courierpd.map;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Collection;

import courierpd.core.DeliveryTicket;
import courierpd.enums.Direction;

/**
 * The Route is the path the courier will take throughout 
 * the course of a delivery. This will be the shortest 
 * path to complete the job.
 */
public class Route {

    /**
     * Represents the current delivery ticket being serviced. 
     * This will be used with the static path finder algorithm.
     */
    private DeliveryTicket currentOrder;
    /**
     * The current state of the City Center. 
     * This is used with the static path finder algorithm 
     * to populate the route with the path the courier should 
     * actually take.
     */
    private CityMap currentMap;
    /**
     * Represents all of the intersections that will be crossed 
     * during the courier's trip. The values in the used intersections 
     * may not be unique. The return journey may include the same 
     * streets made on the outset. Intersections function as nodes 
     * in the shortest path algorithm.
     */
    private ArrayList<Intersection> usedIntersections = new ArrayList<Intersection>();
    /**
     * The directions are the enumerators associated with the 
     * turns made at intersections. These are used for printing out 
     * the directions for a courier. At each intersection, the 
     * courier needs to know which direction must be in order to 
     * make it to the next intersection.
     */
    private ArrayList<Direction> directions = new ArrayList<Direction>();
    /**
     * The lengths that each street must be traveled to the next turn 
     * intersection. This is a parallel structure with the directions 
     * and the usedIntersections.
     */
    private int streetTravelLengths;
    /**
     * The used streets for the shortest path. Streets function as edges 
     * in the graph algorithm.
     */
    private Collection<Street> usedStreets;

    /**
     * The default no argument constructor.
     */
    private ArrayList<Intersection> officeToPickupPath;
    private ArrayList<Intersection> pickupToDeliveryPath;
    private ArrayList<Intersection> deliveryToOfficePath;
    
    public Route() {
      setOfficeToPickupPath(new ArrayList<Intersection>());
      setPickupToDeliveryPath(new ArrayList<Intersection>());
      setDeliveryToOfficePath(new ArrayList<Intersection>());
    }

    /**
     * Once the path is determined, it can be used to estimate the delivery 
     * time based on the average speed a courier travels, which is one 
     * of the business parameters adjustable by the Owner. The estimated 
     * delivery time amounts to the estimated number of blocks to travel, 
     * converting that to miles then dividing that by the courier's average speed.
     */
    public Time estimateDeliveryTime() {
        // TODO - implement Route.estimateDeliveryTime
        throw new UnsupportedOperationException();
    }

    /**
     * Calculates the number of blocks that should be traveled 
     * throughout the deliver. This is determined with the used 
     * intersections and calculated based on the difference between 
     * the numerical values associated with the names of said intersections. 
     * For example, if the two intersections A St. & 1st Ave. and A St. & 2nd Ave. 
     * were used, then the difference between the two would be 1, which is the 
     * absolute value of the difference between 1 and 2.
     */
    public int estimateBlocks() {
        // TODO - implement Route.estimateBlocks
        throw new UnsupportedOperationException();
    }

    /**
     * The estimated price for the delivery based on the estimated number 
     * of blocks times the business parameters for billing base and rate.
     */
    public float estimatePrice() {
        // TODO - implement Route.estimatePrice
        throw new UnsupportedOperationException();
    }

    /**
     * Within this method, the static call to the shortest path algorithm 
     * utility class is made. After this function has executed, the 
     * usedIntersections represent the shortest path within the Route class.
     */
    public void findUsedIntersections() {
        // TODO - implement Route.findUsedIntersections
        throw new UnsupportedOperationException();
    }

    /**
     * This method examines the intersections found among those that are 
     * used in the shortest path and determines which direction the courier 
     * will have to turn to stay on the path.
     */
    public void findTurnDirection() {
        // TODO - implement Route.findTurnDirection
        throw new UnsupportedOperationException();
    }

    /**
     * Determines the length, in blocks, of the edge between two intersections 
     * used for turning to stay on the shortest path.
     */
    public void findLengths() {
        // TODO - implement Route.findLengths
        throw new UnsupportedOperationException();
    }

    /**
     * Finds the block length between two intersections used on the shortest path. 
     * This is a helper method for the findLengths() operation.
     */
    public void findSingleLength() {
        // TODO - implement Route.findSingleLength
        throw new UnsupportedOperationException();
    }

    /**
     * Returns the delivery ticket this route is associated with.
     */
    public DeliveryTicket getCurrentOrder() {
        return this.currentOrder;
    }

    /**
     * Sets the order ticket this route will be associated with.
     * @param currentOrder The current delivery ticket to be used with this route.
     */
    public void setCurrentOrder(DeliveryTicket currentOrder) {
        this.currentOrder = currentOrder;
    }

    /**
     * Returns the directions collection. This would normally be used for 
     * generating the directions for a courier.
     */
    public Collection<Direction> getDirections() {
        return this.directions;
    }

    /**
     * Sets the directions collection associated with this Route.
     * @param directions The directions to be associated with the Route.
     */
    public void setDirections(ArrayList<Direction> directions) {
        this.directions = directions;
    }

    /**
     * Returns the collection of travel lengths between intersections in the Route.
     */
    public int getStreetTravelLengths() {
        return this.streetTravelLengths;
    }

    /**
     * Sets the street travel lengths collection for a given Route.
     * @param streetTravelLengths The travel lengths for a given Route.
     */
    public void setStreetTravelLengths(int streetTravelLengths) {
        this.streetTravelLengths = streetTravelLengths;
    }

	public ArrayList<Intersection> getOfficeToPickupPath() {
		return officeToPickupPath;
	}

	public void setOfficeToPickupPath(ArrayList<Intersection> officeToPickupPath) {
		this.officeToPickupPath = officeToPickupPath;
        for(Intersection intersection:this.officeToPickupPath){
        	this.usedIntersections.add(intersection);
        }
	}

	public ArrayList<Intersection> getPickupToDeliveryPath() {
		return pickupToDeliveryPath;
	}

	public void setPickupToDeliveryPath(ArrayList<Intersection> pickupToDeliveryPath) {
		this.pickupToDeliveryPath = pickupToDeliveryPath;
		for(Intersection intersection:this.pickupToDeliveryPath){
        	this.usedIntersections.add(intersection);
        }
	}

	public ArrayList<Intersection> getDeliveryToOfficePath() {
		return deliveryToOfficePath;
	}

	public void setDeliveryToOfficePath(ArrayList<Intersection> deliveryToOfficePath) {
		this.deliveryToOfficePath = deliveryToOfficePath;
		for(Intersection intersection:this.deliveryToOfficePath){
        	this.usedIntersections.add(intersection);
        }
	}
	
	public String getTranslatedDirections(){
		String directions = "";
		directions+=" From "+this.getOfficeToPickupPath().get(0).getName()+" (office) to the pickup location: \n";
		directions+=translatePath(this.officeToPickupPath);
		directions+=" From "+this.getPickupToDeliveryPath().get(0).getName()+" (the pickup location) to the delivery location: \n";
		directions+=translatePath(this.pickupToDeliveryPath);
		directions+=" From "+this.getDeliveryToOfficePath().get(0).getName()+" (the delivery location) back to office: \n";
		directions+=translatePath(this.deliveryToOfficePath);
		
		return directions;
	}
	public String translatePath(ArrayList<Intersection> path){
		
		/*
		 * A string variable, translatedPath holds the English 
		 * version of the delivery instructions and initially has the value of ��
		 */
		String translatedPath = "";
		String tab = "\t";
		int counter=0;
		Intersection currentIntersection = path.get(0);
		while(counter<path.size()-1){
			Intersection nextIntersection = path.get(counter+1);
			Street street = new Street();
			street.setFrom(currentIntersection);
			street.setTo(nextIntersection);
			String direction ="";
			
			/*
			 * Compare the x coordinates
			 *	of the current intersection with the next intersection.
			*/
			int XsDifference = nextIntersection.getXCoord()-currentIntersection.getXCoord();
			
			/*
			 * Compare the y coordinate value of the current intersection
			 *	with the y coordinate value of the next intersection on the list.
			 */
			int YsDifference = nextIntersection.getYCoord()-currentIntersection.getYCoord(); 
			
			/*
			 * If the x values are equal, Subtract the �from� intersection y value
			 *	from the �to� intersection y value.
			 */
			if(XsDifference==0){
				
				/*
				 * If the difference is greater than 0, the courier will go North,
				 * street.length miles.
				 */
				if(YsDifference>0){
					directions.add(Direction.South);
					direction = tab+"Go " + Direction.South + " to "+nextIntersection.getName();
				}
			
				/*
				 * Otherwise (difference is less than 0), the courier will go South to the
				 * to intersection, street.length miles
				 */
				if(YsDifference<0){
					directions.add(Direction.North);
					direction = tab+"Go " + Direction.North + " to "+nextIntersection.getName();
				}
			}
				
			/*
			 * If the y values are equal, subtract the �from� intersection x value 
			 * from the �to� intersection x value.
			 */
			if(YsDifference==0){
				/*
				 * If the difference is greater than 0, the courier will go East, 
				 * street.length miles.
				 */
				if(XsDifference>0){
					directions.add(Direction.East);
					direction = tab+"Go " + Direction.East + " to "+nextIntersection.getName();
				}
			
				/*
				 * Otherwise (difference is less than 0), the courier will go West 
				 * to the �to� intersection, street.length miles.
				 */
				if(XsDifference<0){
					directions.add(Direction.West);
					direction = tab+"Go " + Direction.West + " to "+nextIntersection.getName();
				}
			}
				
			// Append the new direction to the list of existing directions (translatedPath).
			translatedPath+=direction+"\n";
			
			//update current intersection and the counter
			currentIntersection = nextIntersection;
			counter++;
		}
		
		return translatedPath;
	}

}