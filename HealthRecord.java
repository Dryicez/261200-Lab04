public class HealthRecord {
    private int height;
    private static final int MIN_PERMITTED_HEIGHT = 50; // Minimum height in cm
    private static final int MAX_PERMITTED_HEIGHT = 175; // Maximum height in cm
    private static final int DEFAULT_HEIGHT = 100;       // Default height if invalid

    
    private static int tallestHeight = MIN_PERMITTED_HEIGHT;
    private static int shortestHeight = MAX_PERMITTED_HEIGHT;

    
    private static int counter = 0;
    private static double averageHeight = 0;

    
    public HealthRecord(int height) {
        setHeight(height);
    }

    // This gets the height for this record.
    public int getHeight() {
        return this.height;
    }

    // This sets the height for this record and updates the average and counter.
    public void setHeight(int height) {
        int validatedHeight;
        if (height >= MIN_PERMITTED_HEIGHT && height <= MAX_PERMITTED_HEIGHT) {
            validatedHeight = height;
        } else {
            validatedHeight = DEFAULT_HEIGHT;
        }

        // Update the average height
        averageHeight = (averageHeight * counter + validatedHeight) / (counter + 1);
        counter++;

        this.height = validatedHeight;

        if (this.height > tallestHeight) {
            tallestHeight = this.height;
        }
        if (this.height < shortestHeight) {
            shortestHeight = this.height;
        }
    }

    // This shows the details for this record.
    public void displayDetails() {
        System.out.println("Height: (cm) " + getHeight());
    }

    // This shows the tallest, shortest, average height, and number of records.
    public static void displayClassDetails() {
        System.out.println("Tallest Height: (cm) " + tallestHeight);
        System.out.println("Shortest Height: (cm) " + shortestHeight);
        System.out.printf("Average Height: (cm) %.2f\n", getAverageHeight());
        System.out.println("Number of Records: " + counter);
    }

    // This gets the average height of all records.
    public static double getAverageHeight() {
        return averageHeight;
    }

    // This prints the BMI category.
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

    // This calculates BMI using weight (kg) and height (cm).
    public static double calculateBMI(double weightKg, double heightCm) {
        double heightM = heightCm / 100.0;
        return weightKg / (heightM * heightM);
    }
}
