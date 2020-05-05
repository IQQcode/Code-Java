package com.jzoffer.test;

import com.jzoffer.SolutionI;
import com.jzoffer.SolutionII;
import com.jzoffer.SolutionIII;
import com.jzoffer.SolutionIV;
import org.junit.Test;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-04 10:56
 * @Description:
 */
public class SolutionTest {
    @Test
    public void testI() {
        int n = 9;
        System.out.println(SolutionI.hammingWeight(n));
    }

    @Test
    public void testII() {
        int n = 00000000000000000000000000001011;
        System.out.println(SolutionII.hammingWeight(n));
    }

    @Test
    public void testIII() {
        int n = 00000000000000000000000000001011;
        System.out.println(SolutionIII.hammingWeight(n));
    }

    @Test
    public void testIV() {
        int n = 00000000000000000000000000001011;
        System.out.println(SolutionIV.hammingWeight(n));
    }

    @Test
    public void testV() {
        int n = 00000000000000000000000000001011;
        String str = n + "";
        System.out.println("str: " + str);
    }

    @Test
    public void testVI() {
        System.out.println(12 & 1);
    }
}
