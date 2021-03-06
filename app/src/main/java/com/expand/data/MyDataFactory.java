package com.expand.data;

import com.expand.models.Child;
import com.expand.models.Parent;

import java.util.Arrays;
import java.util.List;

/**
 * Helper class to create and return data needed for the app.
 */

public class MyDataFactory {

    public static List<Parent> makeData() {
        return Arrays.asList(
                makeParentOne(),
                makeParentTwo(),
                makeParentThree(),
                makeParentFourth());
    }

    private static Parent makeParentOne() {
        return new Parent(1, "Parent One", makeFirstChildren(), false);
    }

    private static Parent makeParentTwo() {
        return new Parent(2, "Parent Two", makeSecondChildren(), false);
    }

    private static Parent makeParentThree() {
        return new Parent(3, "Parent Three", makeThirdChildren(), false);
    }

    private static Parent makeParentFourth() {
        return new Parent(4, "Parent Fourth", makeFourthChildren(), false);
    }

    private static List<Child> makeFirstChildren() {
        Child child1 = new Child("One", false);
        Child child2 = new Child("Two", false);
        Child child3 = new Child("Three", false);
        Child child4 = new Child("False", false);

        return Arrays.asList(child1, child2, child3, child4);
    }

    private static List<Child> makeSecondChildren() {
        Child child1 = new Child("One", false);
        Child child2 = new Child("Two", false);
        Child child3 = new Child("Three", false);
        Child child4 = new Child("False", false);

        return Arrays.asList(child1, child2, child3, child4);
    }

    private static List<Child> makeThirdChildren() {
        Child child1 = new Child("One", false);
        Child child2 = new Child("Two", false);
        Child child3 = new Child("Three", false);
        Child child4 = new Child("False", false);

        return Arrays.asList(child1, child2, child3, child4);
    }

    private static List<Child> makeFourthChildren() {
        Child child1 = new Child("One", false);
        Child child2 = new Child("Two", false);
        Child child3 = new Child("Three", false);
        Child child4 = new Child("False", false);

        return Arrays.asList(child1, child2, child3, child4);
    }

}
