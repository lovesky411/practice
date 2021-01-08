package com.ksh.java200.N144;

public class Apartment {
    private char[] pass = {'0','1','2','3','4','5','6','7','8','9'};
    private int d = 0;
    public Apartment(int d ){
        this.d = d;
    }

    public int findApart(char region[][], int x, int y, char step, int depth){
        int count = 0;
        int right = region.length;
        int bottom = region[0].length;
        if(x < 0 || x >= bottom || y < 0 || y >= right || region[y][x] != '*' ){
            return 0;
        }
        region[y][x] = pass[depth % 10];
        count = 1 + findApart(region , x, y -1 , step , depth+1)
                + findApart(region, x+1, y, step, depth+1)
                + findApart(region, x-1, y, step, depth+1);
        if(d>0){
            count += findApart(region, x+1, y-1, step, depth+1)
                    + findApart(region, x-1,  y+1, step, depth+1)
                    + findApart(region, x-1, y-1, step, depth +1);
        }
        region[y][x] = step;
        print(region);
        return count;
    }

    public static void print(char c[][]){
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[i].length; j++) {
                System.out.printf("%c", c[i][j]);

            }
            System.out.println();
        }
        System.out.println("--------------------------------------");
    }


    public static void main(String[] args){
        int d = 0;
        Apartment apt = new Apartment(d);
        char region[][] = {
                {'0','0','0','0','0','0','0','0'},
                {'0','0','*','0','*','0','0','0'},
                {'0','0','0','*','0','0','*','0'},
                {'0','0','0','0','0','*','*','0'},
                {'0','0','0','*','*','0','0','0'},
                {'0','0','*','0','0','0','0','0'},
                {'0','*','0','0','0','0','0','0'},
                {'*','0','0','0','0','0','0','0'},
                {'0','0','0','0','*','0','0','0'},
                {'0','0','0','0','*','0','0','0'},
                {'0','0','*','*','0','0','0','0'},
                {'0','0','0','*','0','0','0','*'}
        };
        int right = region.length;
        int bottom = region[0].length;
        int count = 0;
        char steps[] = new char[26];
        for (int i = 0; i < steps.length; i++) {
            steps[i] = (char)('A'+i);

        }
        int []sizes = new int[bottom*right];
        int blocknums = 0;
        for (int i = 0; i < right; i++) {
            for (int j = 0; j < bottom; j++) {
                count = apt.findApart(region,i,j,steps[blocknums],0);
                if(count>0){
                    sizes[blocknums++] = count;
                }
            }
        }
        System.out.printf("아파트 단지 = %d개\n", blocknums);
        for (int i = 0; i < blocknums; i++) {
            System.out.printf("%c단지 = 아파트%d개\n", steps[i], sizes[i]);
        }
    }


}