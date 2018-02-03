public class IntToString {
    public String IntToString(int args[], int sizeOfMassive){
        String s = null;
        for(int i=0;i<sizeOfMassive;i++){
            s+=args[i]+48;
        }
        return s;
    }
}
