import java.util.Random;
import java.util.Scanner;

public class hangman {

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        Random random=new Random();
        String[] words={"cilek","elma","kiraz","ejdermeyvesi","portakal","nar","vişne","kavun","karpuz"};
        String wordToGuess=words[random.nextInt(words.length)];
     /*    System.out.println(wordToGuess); */
        boolean[]guessLetters=new boolean[wordToGuess.length()];
        //java
        //[1,1,1,1]
        int yourPoint=70;
        System.out.println("you are welcome to hangman Game");
        System.out.println("please enter a letter ");
        while(yourPoint>0){
            for(int i=0;i<wordToGuess.length();i++){
                if(guessLetters[i]){
                    System.out.print(wordToGuess.charAt(i)+" ");
                }else{
                    System.out.print("-");
                }
            }
            System.out.println("");
            System.out.println("your points : "+yourPoint);
            System.out.println("please enter a letter :");
            char guess=scan.next().charAt(0);
            boolean isFound=false;

            for(int i=0;i<wordToGuess.length();i++){
                if(wordToGuess.charAt(i)==guess){
                    guessLetters[i]=true;
                    isFound=true;
                }
            }
            if(isFound){
                System.out.println("letter guessed correctly");
            }else{
                yourPoint-=10;
                System.out.println("letter wasn't find,wrong guessing");
            }
         boolean isFinish=true;
            for (boolean letter :guessLetters) {
                if(!letter){
                  isFinish=false;
                  break; 
                }
            }
           if(isFinish){
            System.out.println("your point is :"+yourPoint+" Congratulations corect guessing you must be super smart and the word "+wordToGuess);
            break;
           }
        }
        if(yourPoint==0){
            System.out.println("your point "+yourPoint+" You lost the game, bird brain, please read some books");
            System.out.println("correct word is "+wordToGuess);
        }
        scan.close();
    }
}