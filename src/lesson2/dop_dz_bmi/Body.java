package lesson2.dop_dz_bmi;

public class Body {
    private double height;
    private double weight;
    private double bmi;

    public Body(double _w, double _h) {
        weight = _w;
        height = _h;
        bmi = weight / (height * height);
    }

    // Get BMI category
    public String evalBmi(BmiCategories[] categories){
        String result = String.format("height: %.2f, weight: %.2f, bmi (%.2f): ", height, weight, bmi);

        for (BmiCategories bc : categories) {
            if(bc.inRange(bmi)) {
                return result + bc;
            }
        }
        return result + "unknown";
    }
}
