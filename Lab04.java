public class Lab04 {
    public static void main(String[] args) {
        HealthRecord student1 = new HealthRecord(120);
        HealthRecord student2 = new HealthRecord(55);
        HealthRecord student3 = new HealthRecord(180);

        student1.displayDetails();
        student2.displayDetails();
        student3.displayDetails();

        double bmi = HealthRecord.calculateBMI(60, 160);
        System.out.printf("BMI: %.2f\n", bmi);
        HealthRecord.printBMICategory(bmi);

        HealthRecord.displayClassDetails();
    }
}
