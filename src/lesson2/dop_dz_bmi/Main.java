package lesson2.dop_dz_bmi;

import java.util.ArrayList;

enum BmiCategories {
    UNDERWEIGHT("under", 0, 18.5),
    NORMALWEIGHT("normal", 18.5, 25.0),
    OVERWEIGHT("over", 25.0, 30.0),
    OBESITY("obese", 30.0, 1000);

    private String category;
    private double from;
    private  double to;

    BmiCategories(String _category, double _from, double _to) {

        category = _category;
        from = _from;
        to = _to;
    }

    public Boolean inRange(double val) {
        return (val >= from) && (val < to);
    }

    public String toString() {
        return category;
    }
}

public class Main {

    // Input data
    static String[] metrics = {
            "118 2.05", "106 1.77", "87 1.83",  "45 1.12",
            "70 1.87",  "54 1.57",  "105 1.76", "50 1.96",
            "114 1.76", "72 2.45",  "53 2.10",  "66 2.25",
            "54 1.50",  "95 1.62",  "86 1.72",  "62 1.57",
            "65 2.24",  "72 1.43",  "93 2.01",  "109 3.01",
            "106 2.97", "77 1.69",  "114 2.09", "98 1.72",
            "85 2.46",  "113 1.94", "53 1.77",  "106 2.30"};

    // main method
    public static void main(String[] arg) {

        Body[] bodies = mapMetrics(metrics);

        for(Body b : bodies) {
            System.out.println(b.evalBmi(BmiCategories.values()));
        }
    }

    // Map String array to Body array
    static Body[] mapMetrics(String[] data) {
        ArrayList<Body> bodies = new ArrayList<Body>();

        for(String s : data) {
            try {
                String[] hw = s.split(" ");
                bodies.add(new Body(Double.parseDouble(hw[0]), Double.parseDouble(hw[1])));
            }
            catch (Exception e) {
                System.out.printf("Incorrect argument \"%s\"\n", s);
            }
        }
        return bodies.toArray(new Body[bodies.size()]);
    }
}
