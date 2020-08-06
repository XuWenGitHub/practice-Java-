package menu;

public class LoveMenu {


    public static void heart(int r,double size,String req) throws InterruptedException {

        size=1/(1.5*r*size);

        StringBuilder sb=new StringBuilder();

        for (int y = r; y > -r; y--,sb.append("\n")) {

            for (int x = -2 * r; x < 2 * r; x++) {

                char msg = (req + req).charAt((x - y) % req.length() + req.length());
                System.out.print((inHeart(size, x, y) ? msg + " " : " "));
                //sb.append((inHeart(size, x, y) ? msg + " " : " "));

            }
            Thread.sleep(100);
            System.out.println();
        }
        //System.err.println(sb.toString());

    }

    public static void heartTwo(int r,double size,String center,String left,String right) throws InterruptedException {

        size=1/(1.5*r*size);

        StringBuilder sb=new StringBuilder();

        for (int y = r; y > -r; y--,sb.append("\n")) {

            for (int x = -2 * r; x < 4 * r; x++) {

                boolean isLeft = inHeart(size, x, y);

                boolean isRight = inHeart(size, x - 25, y - 3);

                //双空格

                String req = null;

                if (isLeft && isRight) req = center;

                else if (isLeft) req = left;

                else if (isRight) req = right;

                //if (req != null) sb.append((req + req).charAt((x - y) % req.length() + req.length()));
                //else sb.append(" ");//双空格

                if (req != null) System.out.print((req + req).charAt((x - y) % req.length() + req.length()));
                else System.out.print(" ");//双空格

            }
            Thread.sleep(100);
            System.out.println();
        }
        //System.err.println(sb.toString());

    }

    public static void heartTwoWithXK(int r,double size,String center,String left,String right){

        size=1/(1.5*r*size);

        StringBuilder sb=new StringBuilder();

        for (int y = r; y >=-r; y--,sb.append("\n"))

            for (int x = -2*r; x <= 4*r; x++ ) {

                boolean isLeft=inHeart(size,x,y+3);

                boolean isRight=inHeart(size,x-25,y);

    //双空格

                String req=null;

                String w="";

                if(isLeft && isRight) req=center;

                else if(isLeft) req=left;

                else if (isRight) req=right;

                else if((y==-r || y==r)) {

                    if (x < 3 * r - 7) {

                        req = "♥";

                        w= " ";

                    }

                }

                else if(x==4*r || x==-2*r || line(x,y+3)) req="♥";

                if(req!=null) sb.append((req + req).charAt((x - y) % req.length() + req.length()) + w);

                else sb.append(" ");//双空格

            }

        System.err.println(sb.toString());
//        System.out.println("请选择小刘爱不爱徐文？");
//        System.out.println("1爱           2：不爱");
    }

    private static boolean inHeart(double size,int x,int y){

        return Math.pow(Math.pow(x * size, 2) + Math.pow(y * 2*size, 2) - 1, 3) - Math.pow(x * size, 2) * Math.pow(y * 2*size, 3) <= 0;

    }

    private static boolean line(int x,int y){

        return 4*y-x == 0;

    }

    public static String printHeart(String input){

        int[] array = {0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 4, 5, 2, 3, 4, 1, 0, 1,0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < array.length; i++) {

            if(i % 7 == 0)

                sb.append("\n");

            if(array[i] == 0)

                sb.append("   ");

            else if(array[i] == 4)

                sb.append("  ");

            else if(array[i] == 5)

                sb.append(" I ");

            else if(array[i] == 2)

                sb.append("Lvoe ");

            else if(array[i] == 3)

                sb.append("You");

            else

                sb.append("  "+input);

        }

        return sb.toString();

    }
}


