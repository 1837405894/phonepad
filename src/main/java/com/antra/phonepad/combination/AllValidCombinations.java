package com.antra.phonepad.combination;

import com.antra.phonepad.combination.service.Convertor;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Service("ToLetterMapperService")

public class AllValidCombinations implements Convertor {
    private Set<String> wordsSet;

    public AllValidCombinations() throws IOException {
        Path path = Paths.get("src/main/resources/words.txt");
        byte[] readBytes = Files.readAllBytes(path);
        String wordListContents = new String(readBytes, "UTF-8");
        String[] words = wordListContents.trim().split("\\s");
        wordsSet = new HashSet<>();
        Collections.addAll(wordsSet, words);
    }

    public boolean isValidWord(String word) {
        return wordsSet.contains(word);
    }

    public List<String> findCombinations(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        HashMap<Character, String> map = new HashMap<>();
        map.put('1', "1");
        map.put('0', "0");
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        result.add("");
        for (int i = 0; i < s.length(); i++) {
            ArrayList<String> temp = new ArrayList<>();
            String element = map.get(s.charAt(i));
            for (int j = 0; j < result.size(); j++) {
                for (int p = 0; p < element.length(); p++) {
                    temp.add(new StringBuilder(result.get(j)).append(element.charAt(p)).toString()
                            .replaceAll("[\\s\\p{Z}]+", " ").trim());
                }
            }
            result.clear();
            result.addAll(temp);

        }

        List<String> validResult = new ArrayList<>();
        for(int i = 0; i < result.size(); i++) {
            String[] check = new String[]{result.get(i).substring(0, 3), result.get(i).substring(3,6),
                    result.get(i).substring(6, 10)};

            if(isValidWord(check[0]) && isValidWord(check[1]) && isValidWord(check[2])) {
                    validResult.add(check[0] + "-" + check[1] + "-" + check[2]);
            }
        }



        return validResult;
    }

    @Override
    public String findNumbers(String str) {
        String result = "";
        for(int i  = 0; i < str.length(); i++) {
            if(str.charAt(i) == 'a' || str.charAt(i) == 'b' || str.charAt(i) == 'c') {
                result += "2";
            } else if (str.charAt(i) == 'd' || str.charAt(i) == 'e' || str.charAt(i) == 'f') {
                result += "3";
            } else if (str.charAt(i) == 'g' || str.charAt(i) == 'h' || str.charAt(i) == 'i') {
                result += "4";
            } else if (str.charAt(i) == 'j' || str.charAt(i) == 'k' || str.charAt(i) == 'l') {
                result += "5";
            } else if (str.charAt(i) == 'm' || str.charAt(i) == 'n' || str.charAt(i) == 'o') {
                result += "6";
            } else if (str.charAt(i) == 'p' || str.charAt(i) == 'q' || str.charAt(i) == 'r' || str.charAt(i) == 's') {
                result += "7";
            } else if (str.charAt(i) == 't' || str.charAt(i) == 'u' || str.charAt(i) == 'v') {
                result += "8";
            } else if (str.charAt(i) == 'w' || str.charAt(i) == 'x' || str.charAt(i) == 'y' || str.charAt(i) == 'z') {
                result += "3";
            }

        }
        return result;
    }


}
