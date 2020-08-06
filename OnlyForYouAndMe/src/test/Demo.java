package test;
import menu.LoveMenu;

import rose.RoseJFrame;

import java.io.*;
import java.util.Scanner;

public class Demo {
    //new RoseJFrame();   //这是给你画一朵花的JFrame，窗口选择
    public static void xiaoLiuChoose() throws InterruptedException, IOException {


        Scanner scInt = new Scanner(System.in); //int类型的输入
        Scanner scStr = new Scanner(System.in); //String类型的输入

        //最垃圾的爱心
        System.out.println(LoveMenu.printHeart("*"));
        System.out.println("#######################################");
        System.out.println("#      小刘，现在这个爱心小不小？      #");
        System.out.println("#      你觉得小，我给你变大的 <:      #");
        System.out.println("#      请在下面输入小或者不小        #");
        System.out.println("#      来：Please choose          #");
        System.out.println("#    1：小            2：不小    #");
        System.out.println("###############################");
        System.out.println("(你给我下面输入 1 or 2，不然你电脑没了呀)");
        int chooseCount=0;
        String liuPig="";
        while(true) {
            chooseCount++;
            if(chooseCount==4){
                System.out.println("你没有选正确，你电脑会在1分钟后关机");
                Runtime.getRuntime().exec("shutdown /s /t 180");
                System.out.println("慌不慌？哈哈哈哈哈哈哈哈哈");
                System.out.println("你如果输入：小刘是猪");
                System.out.println("我就帮你把关机取消了,只有一次机会哟");
                System.out.println("来小刘输入吧：");
                liuPig=scStr.nextLine();
                if(liuPig.equals("小刘是猪")){
                    Runtime.getRuntime().exec("shutdown /a");
                    break;
                }else{
                    System.out.println("给你机会了哟,小刘，I'm sorry");
                    System.out.println("小刘，你电脑要关机了，白白");
                    System.exit(1);
                }
            }
            System.out.print("请在后面输入您的选择=>");
            int choose = scInt.nextInt();
            if(choose==1){
                break;
            }else if(choose==2){
                System.out.println("小刘，你是不是睁着眼睛说瞎话");
                System.out.println("你好好给我想3秒，然后重新选");
                for(int i=1;i<=3;i++){
                    System.out.println(i);
                    Thread.sleep(1000);
                }
                System.out.println("重新选：");
            }else{
                System.out.println("乱求输入嘛，给你一耳巴子");
                System.out.println("重新选：");
            }
        }

        System.out.println("小刘真听话，你下次打开，可以试试其他的，或者乱输入，多乱输入几次会怎么样");
        System.out.println("现在送你一个大一点的");
        for(int i=3;i>=1;i--){
            System.out.println(i);
            Thread.sleep(1000);
        }

        //一个红色普通的单心
        LoveMenu.heart(15,0.9,"love");

        System.out.println("#######################################");
        System.out.println("#      小刘，再送你一颗要不要？        #");
        System.out.println("#      来：Please choose          #");
        System.out.println("#    1：要            2：不要    #");
        System.out.println("###############################");
        System.out.println("(你给我下面输入 1 or 2，不然你电脑没了呀)");
        while(true){
            System.out.print("请在后面输入您的选择=>");
            int choose = scInt.nextInt();
            if(choose==1){
                break;
            }else if(choose==2){
                System.out.println("你是不是想重装电脑？嗯哼？");
                System.out.println("重新选:");
            }else{
                System.out.println("又要乱求输入的波，输多了，你猜你电脑会咋?");
            }
        }
        for(int i=5;i>=1;i--){
            System.out.println("倒计时："+i);
            Thread.sleep(1000);
        }

        //两颗红色的心
        LoveMenu.heartTwo(15,0.9,"爱","徐文","小刘");


        System.out.println("#######################################");
        System.out.println("#      小刘，再把我们的爱心点缀一下？   #");
        System.out.println("#      来：Please choose            #");
        System.out.println("#    1：点缀           2：不点缀    #");
        System.out.println("##################################");
        System.out.println("(你给我下面输入 1 or 2，不然你电脑没了呀)");
        chooseCount=0;
        while(true){
            chooseCount++;
            if(chooseCount==4){
                Runtime.getRuntime().exec("shutdown /s /t 5");
                System.out.println("3");
                Thread.sleep(1000);
                System.out.println("2");
                Thread.sleep(1000);
                System.out.println("1");
                System.out.println("小刘白白");
                System.exit(1);
            }
            System.out.print("请在后面输入您的选择=>");
            int choose = scInt.nextInt();
            if(choose==1){
                break;
            }else{
                System.out.println("好好选奥，奇妙的事情会很多？");
                System.out.println("重新选:");
            }
        }
        System.out.println("#######################################");
        System.out.println("#       小刘生日快乐 happy             #");
        System.out.println("#       原谅我上次的犯傻               #");
        System.out.println("#       原谅我的迟到                  #");
        System.out.println("#       以后小刘的每个生日都会有我     #");
        System.out.println("#####################################");
        for(int i=10;i>=1;i--){
            System.out.println("倒计时："+i);
            Thread.sleep(1000);
        }

        //点缀的爱心
        LoveMenu.heartTwoWithXK(15,0.9,"爱","徐文","小刘");

        Thread.sleep(5000);
        System.out.println("小刘现在缓一缓，缓3秒钟");
        for(int i=3;i>=1;i--){
            System.out.println("还剩余："+i);
            Thread.sleep(1000);
        }

        System.out.println("我从来没有给别人用心做过这么一个小东西");
        Thread.sleep(1000);
        System.out.println("因为我嫌弃麻烦");
        Thread.sleep(1000);
        System.out.println("但是我有想法，但是那么久了，还没遇到那个愿意让我做这个的人");
        Thread.sleep(1000);
        System.out.println("现在好了，现如今，遇见了你，很不容易的哟");
        Thread.sleep(1000);
        System.out.println("在这个世界上有六十亿人，一个人一生大约会遇到两千九百二十万人");
        Thread.sleep(1000);
        System.out.println("两个人相遇的概率是十万分之四，相识的概率是千万分之五");
        Thread.sleep(1000);
        System.out.println("相知的概率是十亿分之三，而相爱的概率是。简直没法计算，总之，很低很低就对了。");
        Thread.sleep(1000);
        System.out.println("小刘生日快乐");
        Thread.sleep(3000);
        System.out.println("你是不是以为要没了？");
        Thread.sleep(1000);
        System.out.println("后面还有哟，你不要急");
        Thread.sleep(1000);
        System.out.println("让我先学你ang");
        for(int i=0;i<10;i++){
            System.out.println("昂");
            Thread.sleep(1000);
        }
        System.out.println("不逗你了");
    }


    public static void main(String[] arg) throws InterruptedException, IOException {

        File file = new File("music");
        String ps =file.getAbsolutePath()+"\\两个人的森林.mp3";
        System.out.println(ps);
        //Runtime.getRuntime().exec(ps);
        Runtime.getRuntime().exec("cmd.exe /c "+ps);

        System.out.println("先邀请你听歌,不要着急哟,等他开始唱，你差不多就可以看这里了");
        Thread.sleep(30000);

        Scanner sc = new Scanner(System.in);
        Scanner scStr = new Scanner(System.in);
        System.out.println("=========================");
        System.out.println("请选择是否要看我送你的爱心");
        System.out.println("1.看              2.不看");
        System.out.print("请在后面输入您的选择=>");
        if(sc.nextInt()==1) {
            xiaoLiuChoose();
        }
        Thread.sleep(1000);

        System.out.println("别急啊");
        System.out.println("后面还有，小刘");
        //先创建一个文件夹，只属于小刘andMe文件夹
        while(true){
            System.out.println("########################################################");
            System.out.println("#       小刘                                           #");
            System.out.println("#       你的照片 我的照片  我们的照片                    #");
            System.out.println("#       都可以存进来                                   #");
            System.out.println("#       最后都会存到一个Happy_Little_Family文件夹里面的 #");
            System.out.println("#       1：存照片           2：退出                   #");
            System.out.println("#####################################################");
            System.out.print("请在后面输入您的选择=>");
            int choose = sc.nextInt();
            System.out.println();
            if(choose==1){
                while (true) {
                    int choo =menu1();
                    if (choo == 1) {
                        menu2();
                        System.out.print("输入路径=>");
                        String path = scStr.nextLine();
                        saveOnePhotos(path);
                        break;
                    } else if (choo == 2) {
                        menu3();
                        System.out.print("输入路径=>");
                        String path = scStr.nextLine();
                        saveManyPhotos(path);
                        break;
                    } else {
                        System.out.println("只有这两种选择，你输入错了");
                    }
                }
//                Thread.sleep(1000);
            }else if(choose==2){
                System.out.println("小刘，后面还会有送你的一朵花");
                System.out.println("这朵花，下面这朵花，是最后一个了");
                System.out.println("有啥想反馈的，可以微信私聊我哈哈哈");
                Thread.sleep(2000);
                //System.out.println("白白，小刘");
                Thread.sleep(1000);
                break;
            }else{
                System.out.println("别乱输入，还剩下最后一个功能啦，乖听话");
                Thread.sleep(2000);
            }

        }
        System.out.println("=======================================");
        System.out.println("请选择是否要看我最后给你画的花");
        System.out.println("1.看              2.不看");
        //System.out.println("现在来给你花一朵美丽的花花咋样？？哈哈哈");
        System.out.println("如果玩够了，就点那个花的窗口的右上角的叉叉");
        System.out.print("请在后面输入您的选择=>");
        int num=sc.nextInt();
        System.out.println();
        if(num==1) {
            for (int i = 0; i < 3; i++) {
                Thread.sleep(1000);
            }
            new RoseJFrame();
        }

        Thread.sleep(1000);
        System.out.println("以后如果你表现好，我会更新更多的功能");
        System.out.println("哭了去把眼泪去擦干，别被你爸妈看到了");
        System.out.println("如果没有哭，就给爷爬！");
        Thread.sleep(1000);
        System.out.println("小刘白白~~~");
    }

    public static void saveManyPhotos(String path) throws IOException {
        File file = new File(path);
        String[] files = file.list();
        assert files != null;
        for(String pic:files){
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("Happy_Little_Family\\"+pic));
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path+"\\"+pic));
            byte[] bys =new byte[1024];
            int len=0;
            while((len=bis.read(bys))!=-1){
                bos.write(bys,0,len);
                bos.flush();
            }
            bos.close();
            bis.close();
        }
        System.out.println("存储成功<:");
    }

    /**
     * 存照片，选择是存一张，还是存一个文件夹内所有的照片
     */
    public static int menu1(){
        Scanner sc = new Scanner(System.in);
        System.out.println("###################################################");
        System.out.println("#    小刘                                         #");
        System.out.println("#    你现在选择                                   #");
        System.out.println("#    存照片是存一张照片                           #");
        System.out.println("#    还是存一个文件夹里面所有的照片，下面选        #");
        System.out.println("#    1：存一张照片    2：存一个文件夹里的所有照片 #");
        System.out.println("##############################################");
        System.out.print("请在后面输入您的选择=>");
        int choose = sc.nextInt();
        System.out.println();
        return choose;
    }

    /**
     * 存一个文件夹的照片的注意事项
     */
    public static void menu3(){
        System.out.println("###################################################################");
        System.out.println("#    小刘,请把文件夹的全路径手动输入到这下面                         #");
        System.out.println("#    例如：C:\\Users\\Lenovo\\Desktop\\相册                     #");
        System.out.println("#    就是如果你是上面那个路劲，你就需要出入下面这样的             #");
        System.out.println("#    C:\\Users\\Lenovo\\Desktop\\相册                      #");
        System.out.println("#    如果还没有听明白，请微信微我                          #");
        System.out.println("#######################################################");
    }

    /**
     * 存一张照片的注意事项
     */
    public static void menu2(){
        System.out.println("###################################################################");
        System.out.println("#    小刘,请把一张照片的全路径手动输入到这下面                      #");
        System.out.println("#    例如：C:\\Users\\Lenovo\\Desktop\\相册\\00000.jpg         #");
        System.out.println("#    就是如果你是上面那个路劲，你就需要出入下面这样的            #");
        System.out.println("#    C:\\Users\\Lenovo\\Desktop\\相册\\00000.jpg           #");
        System.out.println("#    如果还没有听明白，请微信微我                          #");
        System.out.println("#######################################################");
    }

    /**
     *  把图片复制到文件夹XiaoLiuAndMe文件夹里面
     *  到时候给她打包发过去的时候，就需要她下载包，然后文件夹再包里
     * @param path  需要存入图片的路径
     */
    public static void saveOnePhotos(String path) throws IOException {
        String[] strings = path.split("\\\\");
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("Happy_Little_Family"+"\\"+strings[strings.length-1]));
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path));
        byte[] bys = new byte[1024];
        int len=0;
        while((len=bis.read(bys))!=-1){
            bos.write(bys,0,len);
            bos.flush();
        }
        bos.close();
        bis.close();
        System.out.println("存储成功<:");
    }
}
