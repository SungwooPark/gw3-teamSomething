public class Jumper extends Actor{
    //From API provided by GridWorld Case Study
    package info.gridworld.actor;
    import info.gridworld.grid.Grid;
    import info.gridworld.grid.Location;
    import java.awt.Color;
    
    //Red is default color
    public Jumper(){
        setColor(Color.RED);
    }
    //When color is provided
    public Jumper(Color c){
        setColor(c);
    }

    public void act(){
        if (canMove())
            move;
        else
            turn();
    }

    public void turn(){
        setDirection(getDirection() + Location.HALF_RIGHT);
    }

    public void move(){
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection()).getAdjacentLocation(getDirection()); 
        if (gr.isValid(next)
            moveTo(next);
        else
            removeSelfFromGrid();
        Flower flower = new Flower(getColor());
        flower.putSelfInGrid(gr,loc);    
    }

    public boolean canMove(){
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return false;
        Location loc = getLocation():
        Location next = loc.getAdjacentLocation(getDirection()).getAdjacentLocation(getDirection()); 
        //getAdjacenetLocation is calle twice because this object "Jumps"
        if (!gr.isValid(next))
            return false;
        Actor neighbor = gr.get(next);
        return (neighbor == null) || (neighbor instanceof Flower);
    }
}
