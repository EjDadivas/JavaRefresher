package classes;

class SampleClass {
    public int x;
}

SampleClass object1 = new SampleClass();
object1.x=100;

SampleClass object2 = new SampleClass();
object1.x=200;

System.out.println("Object 1 X: " + object1.x);
System.out.println("Object 2 X: " + object2.x);
