package HomeWork.prog._1DONE;

public class ComputerGames implements Comparable<ComputerGames> {


    private int ageCategory;
    private float rating;
    private String name;


    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAgeCategory() {
        return ageCategory;
    }

    public void setAgeCategory(int ageCategory) {
        this.ageCategory = ageCategory;
    }

    @Override
    public int compareTo(ComputerGames o) {
        if(this.ageCategory == o.ageCategory && this.rating == o.rating && this.name.equals(o.name)) {
            return 0;
        }else {
            if (this.ageCategory == o.ageCategory){
                if (this.rating == o.rating){
                    return  this.name.compareTo(o.name);
                }else {
                    return (int) (this.rating - o.rating);
                }
            }else {
                return this.ageCategory - o.ageCategory;
            }
        }
    }
}
