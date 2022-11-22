public class Lab5 {
    public static void main(String[] args) {
        int[] cordinat = new int[4];
        System.out.println("Точка раздела-x");
        cordinat[0] = Integer.valueOf(System.console().readLine());
        System.out.println("Точка раздела-y");
        cordinat[1] = Integer.valueOf(System.console().readLine());
        System.out.println("Координата дома-x");
        cordinat[2] = Integer.valueOf(System.console().readLine());
        System.out.println("Координата дома-y");
        cordinat[3] = Integer.valueOf(System.console().readLine());
        if (cordinat[0] == cordinat[2] || cordinat[1] == cordinat[3]) {
            System.out.println("Border");
        }
        else if (cordinat[0] > cordinat[2]) { //Запад
            if (cordinat[3] > cordinat[1]) {
                System.out.println("NE"); //Север
            }
            else{System.out.println("SE");}
            
        }
        else if (cordinat[3] > cordinat[1]) {//Восток
             System.out.println("NW"); //Север
            }
            else{System.out.println("SW");}

        }

    }

