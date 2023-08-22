package ExercisesOf05.PriorityQueue;

public class Patient implements Comparable<Patient> {
    private String name;
    private int gravity;

    public Patient(String name, int gravity) {
        this.name = name;
        this.gravity = gravity;
    }

    public String getName() {
        return name;
    }

    public int getGravity() {
        return gravity;
    }

    @Override
    public int compareTo(Patient anotherPatient) {
        return Integer.compare(anotherPatient.getGravity(), this.gravity);
    }
}