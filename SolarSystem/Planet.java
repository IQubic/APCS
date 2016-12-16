import java.util.ArrayList;

// All units are SI units unless otherwise specified
public class Planet {
    private String name;
    private double mass;
    private double radius;
    private double orbitalRadius;
    private double density;
    private ArrayList<Moon> moons;

    public Planet(String name) {
        this.name = name;
    }
    public Planet(String name, double mass, double radius, double orbitalRadius, ArrayList<Moon> moons) {
        this.name = name;
        this.mass = mass;
        this.radius = radius;
        // Density = Mass / Volume
        this.density = mass / this.getVolume();
        this.orbitalRadius = orbitalRadius;
        this.moons = moons;
    }
    public Planet(String name, double mass, double radius, double orbitalRadius) {
        this.name = name;
        this.mass = mass;
        this.radius = radius;
        // Density = Mass / Volume
        this.density = mass / this.getVolume();
        this.orbitalRadius = orbitalRadius;
    }


    // 4/3 * Pi * r^3
    public double getVolume() {
        return 4.0/3.0 * Math.PI * Math.pow(radius, 3);
    }


    // Getters and setters
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }
    public double getMass() {
        return mass;
    }

}
