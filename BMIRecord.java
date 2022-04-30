public class BMIRecord{
    private final String subjectid, category;
    private final double height, weight, bmiValue;
    
    @Override
    public String toString(){
        return "Name: "+subjectid+"\nheight: "+height+"\nweight: "+weight+"\nBMI: "+bmiValue+"\ncategory: "+category;
    }
    
    BMIRecord(String sid, double h, double w, double bmi, String c){
        subjectid=sid;
        height=h;
        weight=w;
        bmiValue=bmi;
        category=c;
    }
    
    String getSubjectId(){
        return subjectid;
    }
    
    String getCategory(){
        return category;
    }
    
    double getHeight(){
        return height;
    }
    
    double getWeight(){
        return weight;
    }
    
    double getBMIValue(){
        return bmiValue;
    }
}