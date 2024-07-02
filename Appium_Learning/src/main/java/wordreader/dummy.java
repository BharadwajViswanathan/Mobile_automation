package wordreader;

import org.testng.annotations.*;
public class dummy {

    @DataProvider(name = "TestData")
    public Object[][] getTestData() {
        return new Object[][]{
                {"Data1", 10},
                {"Data2", 20}
        };
    }

    @Test(dataProvider = "TestData", priority = 1)
    public void testWithData(String data, int value) {
        System.out.println("Test with data: " + data + ", Value: " + value);
    }

    @Test(dataProvider = "TestData", dependsOnMethods = "testWithData")
    public void secondTest(String data, int value) {
        System.out.println("Second test");
    }

    @Test(dataProvider = "TestData", dependsOnMethods = "secondTest")
    public void thirdTest(String data, int value) {
        System.out.println("Third test");
    }
}
