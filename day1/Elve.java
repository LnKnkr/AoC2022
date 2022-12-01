import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class Elve {

    ArrayList<Integer> foods;

    int totalCalories;

    public Elve(String input){
        foods = new ArrayList<>();
        if(input.length() > 0) {
            String[] foods = input.split("\r\n");

            for (String food : foods) {
                this.foods.add(Integer.parseInt(food));
            }

            totalCal();
        }else{
            totalCalories = 0;
        }
    }

    private void totalCal(){
        if(foods.size() > 0) {
            for (Integer food : foods) {
                totalCalories += food;
            }
        }else {
            totalCalories = 0;
        }
    }

    public static int totalOfTopThree(ArrayList<Elve> input){
        input.sort(new Comparator<Elve>() {
            @Override
            public int compare(Elve o1, Elve o2) {
                if (o1.totalCalories == o2.totalCalories)
                    return 0;
                return o1.totalCalories < o2.totalCalories ? 1 : -1;
            }
        });

        return input.get(0).totalCalories + input.get(1).totalCalories + input.get(2).totalCalories;
    }
}
