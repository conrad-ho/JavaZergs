class MutationException extends Exception {
    static final long serialVersionUID = 1L;
    public MutationException(String message) {
        super(message);
    }
}

class Zergs {
    public static void main(String[] args) {
        System.out.println("Game started");
        Larva littlePest = new Larva();
        try {
            //int x = 5/0;
            Object hellokitty = littlePest.spawn(56);
            System.out.println(hellokitty);
            //Zerg brood = hellokitty.mutate();
            Zerg brood = ((Corruptor)hellokitty).mutate();
            System.out.println(brood);    
        } catch (MutationException ex) {
            System.out.println(ex.getMessage());
            return;
        } finally {
            System.out.println("I give up!");
        }
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

class Infestor extends Zerg{
    Infestor() {
        setClaws(1);
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
    Corruptor() {
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
    public final static int INFESTOR = 89;

    Zerg spawn(int type) throws MutationException {
        Zerg newZerg = null;
        switch(type) {
        case Larva.TERRAN:
            throw new MutationException("Cannot spawn Terran units!");
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
        case Larva.INFESTOR:
            newZerg =  new Infestor();
            break;
        default:
            throw new MutationException("Cannot spawn invalid zerg type!");
        }
        return newZerg;
    }
}
