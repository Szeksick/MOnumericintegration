package sample.methods;

import javafx.scene.control.Alert;

import java.util.ArrayList;

import static java.lang.Math.abs;

public class Simpson {
    private ArrayList<Double> tabx, taby, templist;
    private Double h, result, sum;
    int n;

    public Simpson(ArrayList<Double> tabx, ArrayList<Double> taby) {
        this.tabx = tabx;
        this.taby = taby;
        init();
    }
    private void init(){
        try{
            this.h = this.tabx.get(1)- this.tabx.get(0);
            this.n = this.tabx.size();
            this.sum = 0.0;
        }catch(Exception e){
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Błąd metody prostokatów z niedomiarem");
            alert.setHeaderText(null);
            alert.setContentText("Mniej niż 2 punkty pomiarowe");
            alert.showAndWait();
        }
    }
    public double calculate(){
        init();
        sum = taby.get(0);
        for(int i = 1; i < n-1 ; i++){
            if(i%2==0) {
                sum = sum + (2*taby.get(i));
            }else{
                sum = sum + (4*taby.get(i));
            }
        }
        sum = sum+taby.get(n-1);
        result = (h/3)*sum;
        return result;
    }
}
