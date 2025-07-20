public class HealthRecord {
    private int height;
    private static final int MIN_PERMITTED_HEIGHT = 50; // constant
    private static final int MAX_PERMITTED_HEIGHT = 175; // constant
    private static final int DEFAULT_HEIGHT = 100;

    // Tallest and shortest tracking
    private static int tallestHeight = MIN_PERMITTED_HEIGHT;
    private static int shortestHieght = MAX_PERMITTED_HEIGHT;

    // New fields for average and count
    private static int counter = 0;           // Number of HealthRecord objects
    private static double averageHeight = 0;  // Average height of all objects

    public HealthRecord(int height) { // constructor
        setHeight(height); // calls the setter method
        // Counter and average are updated in setHeight
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
}
