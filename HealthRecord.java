public class HealthRecord {
    private int height;
    private static final int MIN_PERMITTED_HEIGHT = 50; // constant
    private static final int MAX_PERMITTED_HEIGHT = 175; // constant
    private static final int DEFAULT_HEIGHT = 100;

    // Tallest and shortest tracking
    private static int tallestHeight = MIN_PERMITTED_HEIGHT;
    private static int shortestHieght = MAX_PERMITTED_HEIGHT;

    // New fields for average and count
    private static int counter = 0;           
    private static double averageHeight = 0;  

    public HealthRecord(int height) { // constructor
        setHeight(height);
    }

    public int getHeight() { // getter
        return this.height;
    }

    public void setHeight(int height) { // setter
        int validatedHeight;
        if (height >= MIN_PERMITTED_HEIGHT && height <= MAX_PERMITTED_HEIGHT) {
            validatedHeight = height;
        } else {
            validatedHeight = DEFAULT_HEIGHT;
        }

        averageHeight = (averageHeight * counter + validatedHeight) / (counter + 1);
        counter++;

        this.height = validatedHeight;

        if (this.height > tallestHeight) {
            tallestHeight = this.height;
        }
        if (this.height < shortestHieght) {
            shortestHieght = this.height;
        }
    }

    public void displayDetails() {
        System.out.println("Height: (cm) " + getHeight());
    }

    public static void displayClassDetails() {
        System.out.println("Tallest Height: (cm) " + tallestHeight);
        System.out.println("Shortest Height: (cm) " + shortestHieght);
        System.out.printf("Average Height: (cm) %.2f\n", getAverageHeight());
        System.out.println("Number of Records: " + counter);
    }

    // Getter for average height
    public static double getAverageHeight() {
        return averageHeight;
    }

    public static void printBMICategory(double bmi) {
        if (bmi < 18.5) {
            System.out.println("Underweight (BMI < 18.5)");
        } else if (bmi < 23.0) {
            System.out.println("Normal weight (BMI 18.5–22.9)");
        } else if (bmi < 25.0) {
            System.out.println("Overweight at risk (BMI 23.0–24.9)");
        } else if (bmi < 30.0) {
            System.out.println("Obese Class I (BMI 25.0–29.9)");
        } else {
            System.out.println("Obese Class II (BMI ≥ 30)");
        }
    }

    public static double calculateBMI(double weightKg, double heightCm) {
        double heightM = heightCm / 100.0;
        return weightKg / (heightM * heightM);
    }

}
