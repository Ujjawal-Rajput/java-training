public class Access {
    public static void main(String[] args) {
        Gym g1 = new Gym();
        // g1._name = "Shubham";
        // g1._membership = "GOLD";

        g1.setName("Shubham");
        g1.setMembership("GOLD");
        Gym g2 = new Gym();
        g2.setName("Shubham");
        g2.setMembership("GOLD");
        // System.out.println(g1.getName()==g2.getName());

        System.out.println(g1);
    }
}
