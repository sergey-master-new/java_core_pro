package annotation;

import java.lang.annotation.*;

public class AnnotationTest2 {

    public static void main(String[] args) throws ClassNotFoundException {

        Class xiamiClass = Class.forName("java_oca_black.annotation.Xiaomi");
        Annotation annotation1 = xiamiClass.getAnnotation(SmartPhone.class);
        SmartPhone smPh1 = (SmartPhone) annotation1;
        System.out.println("Annotation from Xiaomi.class: " + smPh1.OS() + " , " + smPh1.yearOfCompanyCreation());

        Class iphoneClass = Class.forName("java_oca_black.annotation.Iphone");
        Annotation annotation2 = iphoneClass.getAnnotation(SmartPhone.class);
        SmartPhone smPh2 = (SmartPhone) annotation2;
        System.out.println("Annotation from Iphone.class: " + smPh2.OS() + " , " + smPh2.yearOfCompanyCreation());
    }
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface SmartPhone{

    String OS() default "Android";
    int yearOfCompanyCreation() default 2010;
}

//@SmartPhone(OS = "Android", yearOfCompanyCreation = 2010)
@SmartPhone
class Xiaomi{
    String model;
    double price;
}

@SmartPhone(OS = "IOS", yearOfCompanyCreation = 1976)
class Iphone{
    String model;
    double price;
}