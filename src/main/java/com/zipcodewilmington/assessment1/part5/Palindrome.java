package com.zipcodewilmington.assessment1.part5;

import static com.zipcodewilmington.assessment1.part1.BasicStringUtils.reverse;

public class Palindrome {

    public Boolean isPalindrome(String s){
        if (s.equals(reverse(s))){
            return true;
        }
        else{
            return false;
        }
    }

    public Integer countPalindromes(String input){
        int substringLength = 2;
        Integer answer = input.length();
        while(substringLength <= input.length()){
            for (int i = 0; i < input.length(); i++){
                try {
                    if (isPalindrome(input.substring(i, i + substringLength))) {
                        answer++;
                    }
                } catch (StringIndexOutOfBoundsException e){}
            }
            substringLength++;
        }
        return answer;
    }
}
