package com.example.shiyouge.Algorithm;

import java.io.*;
import java.util.*;
import java.lang.Math.*;

public class code2 {
    final static int N=101;
    private static List<String> v=new ArrayList<>(N);
    private static int fn[]=new int[N];
    private static double MAX=1e9,MIN=-1e9,limit=0.5;
    private static int n,left[]=new int[N],pre[]=new int[N],used[]=new int[N];
    private static double G[][]=new double[N][N],lx[]=new double[N],ly[]=new double[N],slack[]=new double[N];

    //调用init vv传入每组的标签信息，fnn传入每组的匹配失败次数 一组两个人
    public static void init(List<String> vv,int fnn[]){
        n=vv.size();
        for(int i=0;i<n;i++){
            v.add(vv.get(i));
        }
        for(int i=0;i<n;i++){
            fn[i]=fnn[i];
        }
        return;
    }
    private static double cal(int x,int y){
        if(x==y) return 0;
        String sx=v.get(x),sy=v.get(y);
        int sumx=0,sumy=0,sumx2=0,sumy2=0,sumxy=0;
        int len=sx.length();
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
    private static void go(int now,int n){
        for(int i=0;i<n;i++) {
            used[i]=0;
            slack[i]=MAX;
        }
        left[n]=now;
        int u=0,v=0;
        for(u=n;left[u]!=-1;u=v){
            used[u]=1;
            double d=MAX;
            for(int i=0;i<n;i++){
                if(used[i]==0){
                    double tmp=lx[left[u]]+=ly[i]-G[left[u]][i];
                    if(tmp<slack[i]){
                        slack[i]=tmp;
                        pre[i]=u;
                    }
                    if(slack[i]<d){
                        d=slack[v=i];
                    }
                }
            }
            for(int i=0;i<n;i++) {
                if (used[i]>0) {
                    lx[left[i]] -= d;
                    ly[i] += d;
                } else {
                    slack[i] -= d;
                }
            }
        }
        for(;u!=n;left[u]=left[pre[u]],u=pre[u]);
    }
    //init后调用solve即可
    public static int[] solve(){
        for(int i=0;i<n/2;i++){
            lx[i]=ly[i]=0;
            left[i]=-1;
        }
        for(int i=0,cnt1=0;i<n;i+=2,cnt1++){
            for(int j=0,cnt2=0;j<n;j+=2,cnt2++){
                G[cnt1][cnt2]=(cal(i,j)+cal(i+1,j+1)+cal(i+1,j)+cal(i,j+1))/4+Math.max(fn[i],fn[j])*0.1;
            }
        }
        for(int i=0;i<n/2;i++){
            go(i,n/2);
        }
        for(int i=0;i<n/2;i++){
            if(G[i][left[i]]<N){
                left[i]=-1;
            }
        }
        return left;
        //返回匹配数组 匹配失败为-1
    }
}
