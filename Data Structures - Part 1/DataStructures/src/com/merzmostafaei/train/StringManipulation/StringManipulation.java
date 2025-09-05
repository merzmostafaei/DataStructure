package com.merzmostafaei.train.StringManipulation;

import java.util.*;

public class StringManipulation {


    public static int FindTheNumberOfVowels(String string){
        if (string == null) return -1;

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
        if(string == null) return "";

        Stack<Character> stack = new Stack<>();
        var stringNew = new StringBuilder();

        for (var item : string.toCharArray())
            stack.push(item);

        while (!stack.isEmpty())
            stringNew.append(stack.pop());

        return stringNew.toString();
    }

    public static String ReverseTheOrderOfWords(String string){
//        Stack<String> stack = new Stack<>();
//        var stringNew = new StringBuilder();
//
//        for (var item : string.split("\\s+"))
//            stack.push(item);
//
//        while (!stack.isEmpty()) {
//            stringNew.append(stack.pop());
//            if (!stack.isEmpty())
//                stringNew.append(" "); // add space between words
//        }
//
//        return stringNew.toString();
        if (string == null) return " ";
        String[] words = string.trim().split(" ");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ",words);

    }

    public static boolean  stringIsARotation(String input1, String input2){
        if(input1 == null || input2 == null) return false;

            if (input1.length() != input2.length()) return false;
            return (input1 + input1).contains(input2);
    }

    public static String RemoveDuplicateCharacters(String string){
        if(string == null) return "";

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
//        HashMap<Character,Integer> map = new HashMap<>();
//
//        for(char ch : string.toCharArray()) {
//            map.put(ch, map.getOrDefault(ch,0) + 1);
//
//        }
//        var max = 0;
//        String mostRepeated = ""; // null Char as placeHolder
//
//        for (var entry : map.entrySet()){
//            if (entry.getValue()> max) {
//                max = entry.getValue();
//                mostRepeated = entry.getKey().toString();
//            }
//        }
//        return mostRepeated;
        // If we don't have HASHMAP
        if(string.isEmpty() || string == null) throw new IllegalArgumentException();

        final int ASCII_SIZE = 256;
        int[] ferequencies = new int[ASCII_SIZE];
        for(var ch : string.toCharArray())
            ferequencies[ch]++;

        int max = 0;
        char result = ' ';
        for(var i = 0 ; i < ferequencies.length ; i++)
            if (ferequencies[i] > max){
                max = ferequencies[i];
                result = (char) i;
            }
        return String.valueOf(result);


    }

    public static String CapitalizeTheFirstLetterInASentence(String sentence){
        if(  sentence == null || sentence.trim().isEmpty()) return "";

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

    // O(n log n)
//        if(input1 == null || input2 == null ||
//        input1.length() != input2.length()) return false;
//
//
//        char [] char1 = input1.toLowerCase().toCharArray();
//        char [] char2 = input2.toLowerCase().toCharArray();
//
//        Arrays.sort(char1);
//        Arrays.sort(char2);
//
//        return Arrays.equals(char1,char2);

     // 0(n)
        if(input1 == null || input2 == null) return false;

        final int ENGLISH_ALPHABET = 26;
        int[] frequencies = new int[ENGLISH_ALPHABET];

        input1 = input1.toLowerCase();
        for(var i = 0 ; i < input1.length(); i++)
            frequencies[input1.charAt(i)-'a']++;

        input2 = input2.toLowerCase();
        for (var i = 0; i < input2.length(); i ++) {
            int index = input2.charAt(i) - 'a';
            if(frequencies[index] == 0)
                return false;

            frequencies[index]-- ;
        }
        return true;
    }




    public static boolean  StringIsPalindrome(String string){
       int start = 0;
       int end = string.length()-1;

       while (start < end ){
           if(string.toLowerCase().charAt(start++) != string.toLowerCase().charAt(end--))
               return false;

       }

       return true;
    }





}
