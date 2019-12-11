public class LabyrinthNodes {
    long position=0;
    boolean isVisited = false;
    Condition cond;
    boolean[] canGo = new boolean[4];
    int gScore=0,fScore=0,hScore=0;
    LabyrinthNodes parent;
    LabyrinthNodes(){}
    LabyrinthNodes(Long position, boolean isVisited, Condition cond, boolean[] canGo){
        this.position = position;
        this.isVisited = isVisited;
        this.cond = cond;
        this.canGo = canGo;
        this.gScore=0;
        this.fScore=0;
        this.hScore=0;
        this.parent=null;
    }
    public Long getPosition(){
        return position;
    }
    public void setPosition(Long position){
        this.position=position;
    }
    public boolean getIsVisited(){
        return isVisited;
    }
    public Condition getCond(){
        return cond;
    }
    public boolean getCanGo(String way){
        if (way.equals("up")){
            return canGo[0];
        }
        else if(way.equals("down")){
            return canGo[1];
        }
        else if(way.equals("right")){
            return canGo[2];
        }
        else {
            return canGo[3];
        }
    }
    public void setCanGo(boolean[] canGo) {
        this.canGo = canGo;
    }
    public void setIsVisited(boolean isVisited){
        this.isVisited = isVisited;
    }

    public String toString(){

        return "Row: "+(position/8+1)+" Column: "+(position%8+1)+" "+"State: "+cond.toString();
    }
    enum Condition {
        Trap,
        Normal,
        Goal
    }
}
