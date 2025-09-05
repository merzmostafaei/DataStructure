package com.merzmostafaei.train.StringManipulation;

import java.util.*;

public class StringManipulation {


    public static int FindTheNumberOfVowels(String string){
        Character[] array = {'A', 'E', 'O', 'U', 'I'};
        int count = 0;

        for(char i : string.toUpperCase().toCharArray()){
            for(var item : array)
                if(i == item)
                    count++;
        }
        return count;
    }

    public static String ReverseAString(String string){
        Stack<Character> stack = new Stack<>();
        var stringNew = new StringBuilder();

        for (var item : string.toCharArray())
            stack.push(item);

        while (!stack.isEmpty())
            stringNew.append(stack.pop());

        return stringNew.toString();
    }

    public static String ReverseTheOrderOfWords(String string){
        Stack<String> stack = new Stack<>();
        var stringNew = new StringBuilder();

        for (var item : string.split("\\s+"))
            stack.push(item);

        while (!stack.isEmpty()) {
            stringNew.append(stack.pop());
            if (!stack.isEmpty())
                stringNew.append(" "); // add space between words
        }

        return stringNew.toString();
    }

    public static boolean  stringIsARotation(String input1, String input2){
            if (input1.length() != input2.length()) return false;
            return (input1 + input1).contains(input2);
    }

    public static String RemoveDuplicateCharacters(String string){
        Set<Character> set = new  LinkedHashSet<>();
        var stringBuilder = new StringBuilder();

        for(char item : string.toCharArray()){
            set.add(item);
        }
        for (char s : set){
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }
    public static String FindTheMostRepeatedCharacter(String string){
        HashMap<Character,Integer> map = new HashMap<>();

        for(char ch : string.toCharArray()) {
            map.put(ch, map.getOrDefault(ch,0) + 1);

        }
        var max = 0;
        String mostRepeated = ""; // null Char as placeHolder

        for (var entry : map.entrySet()){
            if (entry.getValue()> max) {
                max = entry.getValue();
                mostRepeated = entry.getKey().toString();
            }
        }
        return mostRepeated;
    }

    public static String CapitalizeTheFirstLetterInASentence(String sentence){
        sentence = sentence.trim().replaceAll("\\s+"," ");
        var result = new StringBuilder();

        for(var word : sentence.split(" ")){
            if(word.length() > 0){
                result.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1).toLowerCase())
                        .append(" ");
            }
        }
        return result.toString().trim();

    }

    public static boolean DetectIfTwoStringsAreAnagram(String input1, String input2){
        char [] char1 = input1.toCharArray();
        char [] char2 = input2.toCharArray();

        Arrays.sort(char1);
        Arrays.sort(char2);

        return Arrays.equals(char1,char2);
    }

    public static boolean  StringIsPalindrome(String string){
       int start = 0;
       int end = string.length()-1;

       while (start < end ){
           if(string.charAt(start) != string.charAt(end))
               return false;

           start++;
           end--;
       }

       return true;
    }





}
