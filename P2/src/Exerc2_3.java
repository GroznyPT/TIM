public class Exerc2_3 {

    static int horas2s(int horas, int mins, int seg ){
        int h = horas*3600;
        int m = mins*60;
        int total = h+m+seg;
        return total;
    }


    static int dif2seg(int hora1, int min1, int seg1, int hora2, int min2, int seg2){

        int difhora = hora1-hora2;
        int difmin = min1-min2;
        int difseg = seg1-seg2;
        /*
        if(difhora<0){
            difhora = difhora * -1;
        }
        */
       return Math.abs(horas2s(difhora,difmin, difseg));
    }


    public static void main(String[] args) {
      //  System.out.println(horas2s(2,30,20));
        System.out.println(dif2seg(2,30,20,3,30,20));
        System.out.println(dif2seg(2,30,20,0,30,20));
        System.out.println(dif2seg(2,30,20,2,30,20));
   }

}
