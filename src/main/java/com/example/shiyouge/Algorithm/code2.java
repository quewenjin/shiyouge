package com.example.shiyouge.Algorithm;

import java.util.*;

public class code2 {
    private final static int N=101;
    private static List<String> v=new ArrayList<>(N);
    private static int[] fn =new int[N];
    private static double MIN=-1e9;
    private static double limit=0.5;
    private static int n;
    private static int[] left =new int[N];
    private static int[] pre =new int[N];
    private static int[] used =new int[N];
    private static double[][] G =new double[N][N];
    private static double[] lx =new double[N];
    private static double[] ly =new double[N];
    private static double[] slack =new double[N];

    //调用init vv传入每组的标签信息，fnn传入每组的匹配失败次数 一组两个人

    /**
     * init
     * @param vv 每个人的标签，有选的 1 没选的 0 --> List<01000000101.....>
     * @param fnn 传进来的这些人的匹配失败的次数的数组
     */
    public static void init(List<String> vv, int[] fnn){
        n=vv.size();
        for(int i=0;i<n;i++){
            v.add(vv.get(i));
        }
        if (n >= 0) System.arraycopy(fnn, 0, fn, 0, n);
    }

    /**
     * 手写算法
     */
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

    /**
     * 手写算法
     */
    private static void go(int now,int n){
        double MAX = 1e9;
        for(int i = 0; i<n; i++) {
            used[i]=0;
            slack[i]= MAX;
        }
        left[n]=now;
        int u,v=0;
        for(u=n;left[u]!=-1;u=v){
            used[u]=1;
            double d= MAX;
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
        for(;u!=n;){
            left[u]=left[pre[u]];
            u=pre[u];
        }
    }

    /**
     * init后调用solve即可
     * 返回匹配数组，匹配失败为-1
     * @return 数组match，match[0]=1 意思为传进去的第0个和第1个匹配，以此类推；若match[]=1 为第i个人匹配失败
     */
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
    }
}

