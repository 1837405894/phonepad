package com.antra.phonepad.combination.controller;

import com.antra.phonepad.combination.service.Convertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class WordController {
    @Autowired
    Convertor convertor;

    @RequestMapping(value = "/numbers/{getInput}", method = RequestMethod.GET)
    public String toNumbers(@PathVariable("getInput")String str) {
        if (str.length() != 10) {
            throw new ArithmeticException("Need 10 digits");
        } else {
            return convertor.findNumbers(str);
        }

    }

    @RequestMapping(value = "/getwords/{getInput}", method = RequestMethod.GET)
    public List<String> toWord(@PathVariable("getInput")String num) {
        if (num.length() != 10) {
            throw new ArithmeticException("Need 10 digits");
        } else {
            return convertor.findCombinations(num);
        }

    }


}
