package java8;



import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Java8Assignment {

    //------------------------------------Method to print first ten numbers----------------------------//
    private static void firstTenNumbers(List<Integer> values) {
        values.stream()
                .limit(10)
                .forEach(System.out::println);
    }


    //-------------------------------Method to print first ten odd numbers------------------------------//
    private static void firstTenOddNumbers(List<Integer>values){
             values.stream()
                   .limit(10)
                   .filter(e->e%2!=0)
                   .forEach(System.out::println);

    }

    //----------------------------Method to print first ten even numbers---------------------------------//
    private static void firstTenEvenNumbers(List<Integer>values){
        values.stream()
                .limit(10)
                .filter(e->e%2==0)
                .forEach(System.out::println);

    }
    //----------------------------Method to print 1,2,3 -----------------------------------------------//
    private static void firstNumbers(List<Integer>values,Predicate<Integer>selector){
        values.stream()
                .limit(10)
                .filter(selector)
                .forEach(System.out::println);
    }

    //---------------------Sum of first ten numbers------------------------------------------------//
    private static int sumOfFirstTenNumbers(List<Integer>values){
        return values.stream()
                .limit(10)
                .reduce(0,(c,e)->c+e);
    }

    //---------------------------Sum of fisrt odd numbers---------------------------------------//
    private static int sumOfFirstOddNumbers(List<Integer>values){
        return values.stream()
                     .limit(10)
                     .filter(e->e%2!=0)
                     .reduce(0,(c,e)->c+e);
    }

    //------------------------------Sum of first even numbers-------------------------------------//
    private static int sumOfFirstEvenNumbers(List<Integer>values){
        return values.stream()
                .limit(10)
                .filter(e->e%2==0)
                .reduce(0,(c,e)->c+e);
    }
    //------------------------------------Sum of even numbers which contains 7--------------------//
    private static boolean sumContainsSeven(int value){
        final String valueOf=String.valueOf(value);
        return valueOf.contains("7");

    }


    //------------------calculate the sum of the double of even numbers----------------------------//
    private static int sumofDoubleEvenNumbers(List<Integer>values){
       return values.stream()
                .filter(e->e%2==0)
                .map(e->e*2)
                .reduce(0,(c,e)->c+e);
    }

    //----------------------------calculate the sum of the triple of odd numbers---------------------//
    private static int sumOfTRipleOddNumbers(List<Integer>values){
        return values.stream()
                     .filter(e->e%2!=0)
                     .map(e->e*3)
                     .reduce(0,(c,e)->c+e);

    }

    //---------------------calculate the sum of their half (1/2)----------------------------------//
    private static int sumofHalf(List<Integer>values){
              return  values.stream()
                      .map(e->e/2)
                      .reduce(0,(c,e)->c+e);

    }


    //-----------------------print a string with each UPPERCASED word separated by ', ' ------------//
    private static void printString(List<String>strings){
       String result= strings.stream()
                .map(String::toUpperCase)
                .collect(Collectors.joining(","));
        System.out.println(result);

    }

    //-------------------------create a List containing all words starting with a vowel--------------------//
//    private static void startinWithVowel(List<String>strings){
//        strings.stream()
//                .filter((s) -> s.startsWith("O"))
//                .forEach(System.out::println);
//
//    }

    //----------------------------create a List containing all words ending in 'teen'-------------------------//
    private static void endingInTeen(List<String>strings){
        strings.stream()
                .filter(s->s.endsWith("teen"))
                .forEach(System.out::println);
    }



    public static void main(String[] args) {
        /**
         * Given the following input data.
         */
        List<Integer> numbers = IntStream.range(0, 1_000)
                .boxed()
                .collect(Collectors.toList());

        List<String> words = Arrays.asList("One", "Two", "three", "four", "five", "six", "seven", "Eight", "nine",
                "ten", "eleven", "twelve", "thirteen", "Fourteen", "fifteen", "sixteen", "Nineteen", "twenty");

        // 1: using "numbers" as input, print first ten numbers
        //   example(numbers);
            firstTenNumbers(numbers);

        // 2: using "numbers" as input print first ten odd numbers
            firstTenOddNumbers(numbers);

        // 3: using "numbers" as input print first ten even numbers
           firstTenEvenNumbers(numbers);

        // 4: implement 1, 2, 3 using one method
          firstNumbers(numbers,e->true);
          firstNumbers(numbers,e->e%2==0);
          firstNumbers(numbers,e->e%2!=0);

        // 5. using "numbers" as input print their sum
         System.out.println(sumOfFirstTenNumbers(numbers));

        // 6. using "numbers" as input print the sum of the odd numbers
        System.out.println(sumOfFirstOddNumbers(numbers));

        // 7. using "numbers" as input print the sum of the even numbers
        System.out.println(sumOfFirstEvenNumbers(numbers));

        // 8. using "numbers" as input print the sum of the even numbers which contain '7'
        int suma=numbers.stream()
                        .filter(e->sumContainsSeven(e))
                        .mapToInt(Integer::intValue)
                        .sum();

        // 10. using "numbers" calculate the sum of the double of even numbers
        System.out.println(sumofDoubleEvenNumbers(numbers));

        // 11. using "numbers" calculate the sum of the triple of odd numbers
        System.out.println(sumOfTRipleOddNumbers(numbers));

        // 12. using "numbers" calculate the sum of their half (1/2)
        System.out.println(sumofHalf(numbers));


        // 14. using "words" as input print a string with each UPPERCASED word separated by ', '
            printString(words);

        // 15. using "words" as input create a List containing all words starting with a vowel
       // startinWithVowel(words);


        // 16. using "words" as input create a List containing all words ending in 'teen'
         endingInTeen(words);










    }



}
