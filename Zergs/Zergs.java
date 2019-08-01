class Zergs {
    public static void main(String[] args) {
        System.out.println("Game started");
        Larva littlePest = new Larva();
        Zerg hellokitty = littlePest.spawn(Larva.CORRUPTOR);
        System.out.println(hellokitty);
        Zerg brood = ((Corruptor)hellokitty).mutate();
        System.out.println(brood);
    }
}

class Terran {
    private int legs;
    // accessor
    int getLegs() {
        return legs;
    } 
    // setter
    void setLegs(int newLegs) {
        legs = newLegs;
    }
    public String toString() {
        return "I am a " + this.getClass().getName() + " with " + legs + " legs!";
    }
}

class Zerg {
    private int claws;
    // accessor
    int getClaws() {
        return claws;
    } 
    // setter
    void setClaws(int newClaws) {
        claws = newClaws;
    }
    public String toString() {
        return "I am a " + this.getClass().getName() + " with " + claws + " claws!";
    }
    Zerg(){
        claws = 2;
    }
}








class Hydralisk extends Zerg{
    Hydralisk() {
        setClaws(4);
    }
}

class Ultralisk extends Zerg{
    int tusks;
    Ultralisk() {
        tusks = 2;
        setClaws(2);
    }
}

class Mutalisk extends Zerg {
    int wings;
    Mutalisk() {
        wings = 2;
        setClaws(0); 
    }
    public String toString(){
        return super.toString() + " I can fly!";
    }
}

class Corruptor extends Zerg {
    int tentacles;
    Mutalisk() {
        tentacles = 8;
        setClaws(0); 
    }
    public String toString(){
        return super.toString() + " I can fly!";
    }

    Broodlord mutate(){
        return new Broodlord();
    }
}

class Broodlord extends Corruptor {
    int wings;
    Broodlord() {
        wings = 2;
        tentacles = 0;
        setClaws(0); 
    }
    public String toString(){
        return super.toString() + " GG to you!";
    }
}

class Larva {
    public final static int TERRAN = 34;
    public final static int HYDRALISK = 22;
    public final static int MUTALISK = 33;
    public final static int ULTRALISK = 99;
    public final static int CORRUPTOR = 44;

    Zerg spawn(int type){
        Zerg newZerg = null;
        switch(type) {
        // case Larva.TERRAN:
        //     newZerg = new Terran();
        //     break;
        case Larva.HYDRALISK:
            newZerg = new Hydralisk();
            break;
        case Larva.MUTALISK:
            newZerg = new Mutalisk();
            break;
        case Larva.ULTRALISK:
            newZerg =  new Ultralisk();
            break;
        case Larva.CORRUPTOR:
            newZerg =  new Corruptor();
            break;
        
        
        }
        return newZerg;
    }
}
