import java.util.ArrayList;
import java.util.List;

public class BMIAnalyser{
    private int nrecords;
    private BMIRecord[] data;
    
    public BMIAnalyser(){
        loadFromTables();
        sortById();
    }
    
    public BMIRecord find(String sid){
        for(BMIRecord obj : data){
            if(sid.equalsIgnoreCase(obj.getSubjectId()))return obj;
        }
        return null;
    }
    
    public ArrayList<BMIRecord> find(double bmi1, double bmi2){
        ArrayList<BMIRecord> records = new ArrayList();
        for(BMIRecord obj : data){
            if(inRange(obj.getBMIValue(), bmi1, bmi2))records.add(obj);
        }
        return records;
    }
    
    public int getNrecords(){
        return nrecords;
    }
    
    public double lowestBMI(){
        double lowest = data[0].getBMIValue();
        for(BMIRecord obj : data){
            double bmi = obj.getBMIValue();
            if(bmi<lowest)lowest=bmi;
        }
        return lowest;
    }
    
    public double highestBMI(){
        double highest = data[0].getBMIValue();
        for(BMIRecord obj : data){
            double bmi = obj.getBMIValue();
            if(bmi>highest)highest=bmi;
        }
        return highest;
    }
    
    public double averageBMI(){
        double total = 0;
        for(BMIRecord obj : data){
            total+=obj.getBMIValue();
        }
        return total/nrecords;
    }
    
    public BMIRecord[] getData(){
        return data;
    }
    
    private void sortById() {
        int len = data.length;
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                if(data[i].getSubjectId().compareTo(data[j].getSubjectId())>0){
                    BMIRecord temp = data[i];
                    data[i]=data[j];
                    data[j]=temp;
                }
            }
        }
    }
    
    private void loadFromTables(){
        String[] subjects = {"Person1","Person2","Person3"};
        double[] height = {5,5.5,6};
        double[] weight = {35,40,70};
        nrecords = subjects.length;
        data = new BMIRecord[nrecords];
        
        for(int i=0;i<nrecords;i++){
            double v = weight[i]/(height[i]*height[i]);
            String c = classify(v);
            BMIRecord r = new BMIRecord(subjects[i], height[i], weight[i], v, c);
            data[i]=r;
        }
    }
    
    private String classify(double bmi){
        if(bmi<0)return "Invalid";
        if(inRange(bmi, 0, 15))return "Very severly underweight";
        if(inRange(bmi, 15, 16))return "Severly underweight";
        if(inRange(bmi, 16, 18.5))return "Underweight";
        if(inRange(bmi, 18.5, 25))return "Normal (healthy weight)";
        if(inRange(bmi, 25, 30))return "Overweight";
        if(inRange(bmi, 30, 35))return "Obese Class I (Moderately obese)";
        if(inRange(bmi, 35, 40))return "Obese Class II (Severly obese)";
        return "Obese Class III (Very severly obese)";
    }
    
    private boolean inRange(double number, double lower, double upper){
        return number>=lower&&number<upper;
    }
}
