package Microsoft.Day1;

 class IntegerToRoman {

     public String IntegerToRomanConvertion(int nums){

         final String[] M={"","M","MM","MMM"};
         final String[] C={"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
         final String[] X={"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
         final String[] I={"","I","II","III","IV","V","VI","VII","VIII","IX"};
         return M[nums/1000]+ C[nums%1000/100]+X[nums%100/10]+I[nums%10];

     }

     public static void main(String[] args) {
         IntegerToRoman intToRoman=new IntegerToRoman();
         int number=3540;
       String roman=  intToRoman.IntegerToRomanConvertion(number);
         System.out.println("The Roman numeral for " + number + " is " + roman);
     }
}
