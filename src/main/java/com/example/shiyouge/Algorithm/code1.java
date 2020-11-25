package com.example.shiyouge.Algorithm;

import java.util.*;

public class code1 {
    private final static int N=101;
    private static List<String> v=new ArrayList<>(N);
    private static int[] match =new int[N];
    private static int[] fn =new int[N];
    private static int n;

    //调用init vv传入每个人的标签信息，fnn传入每个人的匹配失败次数
    public static void init(List<String> vv, int[] fnn){
        n=vv.size();
        for(int i=0;i<n;i++){
            v.add(vv.get(i));
        }
        if (n >= 0) System.arraycopy(fnn, 0, fn, 0, n);
    }
    private static double cal(int x,int y){
        double MIN = -1e9;
        if(x==y) return MIN;
        String sx=v.get(x),sy=v.get(y);
        int sumx=0,sumy=0,sumx2=0,sumy2=0,sumxy=0,len=sx.length();
        for(int i=0;i<len;i++){
            sumx+=sx.charAt(i)-'0';
            sumx2+=(sx.charAt(i)-'0')*(sx.charAt(i)-'0');
            sumy+=sy.charAt(i)-'0';
            sumy2+=(sy.charAt(i)-'0')*(sy.charAt(i)-'0');
            sumxy+=(sx.charAt(i)-'0')*(sy.charAt(i)-'0');
        }
        double num=sumxy-1.0*sumx*sumy/len;
        double den=Math.sqrt((sumx2-1.0*sumx*sumx/len)*(sumy2-1.0*sumy*sumy/len));
        System.out.println(x+","+y+","+num/den);
        return num/den;
    }
    //init后调用solve即可
    public static int[] solve(){
        for(int i=0;i<n;i++){
            match[i]=-1;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                double limit = 0.5;
                if(match[j]==0&&cal(i,j)+Math.max(fn[i],fn[j])*0.1>= limit){
                    match[i]=j;
                    match[j]=i;
                }
            }
        }
        return match;
        //返回匹配数组，匹配失败为-1
    }
}