class HelloWorldAnswer {

    public static void main(String[] args) {
        if (args != null) {
            for (String arg : args) {
                System.out.print(arg);
                System.out.print(" ");
            }
        }

        System.out.println("Hello World.");
    }

}
