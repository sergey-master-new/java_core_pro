package nested_classes.n40_anonymous_class;

public class AnonymousClass {

    private int x = 50;

    public static void main(String[] args) {

        Math math = new Math() {

            int y = 100;
            void doSomething(){
            }

            @Override
            public int doOperation(int a, int b){

                AnonymousClass anonymousClass = new AnonymousClass();

                return a + b + anonymousClass.x + y;
            }
        };

        Math math2 = new Math() {

            @Override
            public int doOperation(int a, int b){
                return a * b;
            }
        };

        System.out.println(math.doOperation(3, 5));
        System.out.println(math2.doOperation(3, 5));
    }
}

//class Math {
//
//    int doOperation(int a, int b){
//        return a / b;
//    }
//}

interface Math {

    int doOperation(int a, int b);
}