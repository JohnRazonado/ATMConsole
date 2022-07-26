public class Account {
    private double saving, checking;

    public Account(double savings,double checking){
        this.saving = savings;
        this.checking = checking;
    }
    public void setSaving(double saving){
        this.saving = saving;
    }
    public void setChecking(double checking){
        this.checking = checking;
    }
    public double getSaving(){
        return saving;
    }
    public double getChecking(){
        return checking;
    }
}
