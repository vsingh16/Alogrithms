package com.macquarie.shiner.batch.gcs.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.geeksforgeeks.org/find-the-smallest-window-in-a-string-containing-all-characters-of-another-string/
 *
 * Approach: Traverse String, if any character of string is there in pattern, remove that character from pattern
 * and keep matching others. if pattren becomes empty, means all character has been found.
 *
 */
public class SmallestWindowInAStringContainingOther {

    public static String findSmallestWindow(String str, String pattern) {

        Integer minLengeth = Integer.MAX_VALUE;
        int minStart = -1, minEnd = -1;
        for (int i = 0; i < str.length(); i++) {
            String testPattern = pattern;
            if (testPattern.contains(String.valueOf(str.charAt(i)))) {
                int j;
                for (j = i; j < str.length(); j++) {
                    if (testPattern.contains(String.valueOf(str.charAt(j)))) {
                        testPattern = testPattern.replaceFirst(String.valueOf(str.charAt(j)), "");
                    }

                    if (testPattern.isEmpty()) {
                        break;
                    }
                }

                if (testPattern.isEmpty()) {
                    int len = j - i + 1;
                    if (len < minLengeth) {
                        minLengeth = len;
                        minStart = i;
                        minEnd = j;
                    }
                }

            }
        }

        return minStart == -1 ? "-1" : str.substring(minStart, minEnd + 1);
    }

    static class Input {

        String str;
        String ptr;

        Input(String str, String ptr) {
            this.str = str;
            this.ptr = ptr;
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Integer n = Integer.valueOf(scanner.nextLine());
        List<Input> inputList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            inputList.add(new Input(scanner.nextLine(), scanner.nextLine()));
        }

        inputList.stream().forEach(input -> {
            System.out.println(findSmallestWindow(input.str, input.ptr));
        });

        // System.out.println(findSmallestWindow("qzjaxcvyecpsclbsywopynbjbqfsgvulkfpwfieckuxdywlyxvvxqgdgktjkkqnpznqzxwasaisatrsaoeptuaguafwuaeierjesqzqvvrcemkycxecvneirznikdebvazjayynyvdfqecppqrntywrugsxjjswsjbbsnvvwghzzmdybdeqmvjyyokuacekbflonjgwolmcisxjwjxvdasalfzrhswscrusraxappdokqaoougruatvzaroanuiknexpyyitcnbtpvcmikmpittwycinpxcrfffkkkmhfcbmqwgpwhivkqeelmxqrltqzxwhlrstgruqwkmcjtisfoiuohpoepjlnutbcbdhgxgspheahyupesuwcunpdxmnvezkrvokeacfzkizbahvyurzjzpyyosvyfafzrrlkxxcuvwlumlfpidbpkablykwfccoiccsrixyssgnwfqmdqkwnraijftbrgwwfbioydefhuabvdxpmclbyyfevkzbifurhqxjisbmhscycdgbmbcvrtamanczrqaaaidsvgohuogvwxogldvqewzmrxezrhoivhctfpfeizwrgrrtyfhaheisywswumzsmyhbfomqaxfxdtzsqheqofczrbshsxgjephzijcitgyzphfpuehmkwsfbymdicdxysmvwtcgignqgypfsaoflkvhxdnvhusvqnqakmsapbkmxijlarhaldoglcakvjrytshqhoefkfouvsgzlxxytjwtwjbzzmfvudkgbcoxaerwvucjyvyqcbczijytqoxtfubudpxryifjfbluwbixeqfhemopflnbpmklcverkubudboonakedcwavbfngnlcljagqpabjoxpzyryj", "j"));


    }

}
