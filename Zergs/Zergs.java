class Zergs {
    public static void main(String[] args) {
        System.out.println("Game started");
        Larva l = new Larva();
        Zerg z = l.spawn(Larva.ULTRALISK);
        System.out.println(z);
    }
}

class Zerg {
    private int claws;
    int getClaws() {
        return claws;
    } 
    void setClaws(int newClaws) {
        claws = newClaws;
    }
    public String toString() {
        return "I am a " + this.getClass().getName() + " with " + claws + " claws!";
    }
}

class Hydralisk extends Zerg{
    Hydralisk() {
        setClaws(4);
    }
}

class Ultralisk extends Zerg{
    Hydralisk() {
        setClaws(2);
    }
}

class Larva {
    public final static int HYDRALISK = 22;
    public final static int MUTALISK = 33;
    public final static int ULTRALISK = 99;

    Zerg spawn(int type){
        Zerg newZerg = null;
        switch(type) {
            case Larva.HYDRALISK:
                newZerg = new Hydralisk();
                break;
            case Larva.MUTALISK:
                newZerg = new Zerg();
                break;
            case Larva.ULTRALISK:
                newZerg =  new Ultralisk();
                break;
        }
        return newZerg;
    }
}
