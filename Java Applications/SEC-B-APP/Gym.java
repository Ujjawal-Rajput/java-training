public class Gym {
    private String _name;
    private String _membership;


    Gym(){

    }

    Gym(String name){

    }

    void setName(String name) {
        name = _name;
    }

    // public String toString() {
    //         return "RDEC";
    //     }

    void setMembership(String membership) {
        membership = _membership;
    }

    String getName() {
        return _name;
    }

    String getMembership() {
        return _membership;
    }
}
