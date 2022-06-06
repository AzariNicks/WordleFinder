import java.util.List;

public class Sorters {
    public static boolean DoesntHaveThis(String Word, List LettersInWrongList) {
        Boolean WordHasWrongLetter = true;
        for (int i = 0; i < LettersInWrongList.size(); i++) {
            if (Word.contains(LettersInWrongList.get(i).toString())) {
                WordHasWrongLetter = false;
            }
        }
        return WordHasWrongLetter;

    }

    public static boolean DoesHaveThis(String Word, List LettersInGoodList) {
        int NumberOfGoodLetters = LettersInGoodList.size();
        int HowManyGoodLetters = 0;
        Boolean HasEnoughGoodLetters = false;
        for (int Number = 0; Number < Word.length(); Number++) {
            {
                for (int i = 0; i < LettersInGoodList.size(); i++) {


                    if ((LettersInGoodList.get(i).toString().charAt(0)) == Word.charAt(Number)) {
                       /* System.out.println("We got a GoodLetter match at "
                                + i + " which is " + LettersInGoodList.get(i) + " This IS the same " +
                                "as "
                                + Word.charAt(Number)
                                + " from number "
                                + Number
                        ); */
                        HowManyGoodLetters++;
                    }
                }
            }
        }

        return (HowManyGoodLetters >= NumberOfGoodLetters);

    }


}



