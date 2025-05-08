package utils;

import org.testng.Assert;

public class Validation {

    private Validation() {
    }
    public static void validateTrue(boolean condition,String msg){
        Assert.assertTrue(condition,msg);
    }
    public static void validateFalse(boolean condition,String msg){
        Assert.assertFalse(condition,msg);
    }
    public static void validateEquals(String actualResult,String expectedResult){
        Assert.assertEquals(actualResult,expectedResult);
    }
    public static void validateNotEquals(String expectedResult,String actualResult,String msg){
        Assert.assertEquals(expectedResult,actualResult,msg);
    }

}
