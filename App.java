//Great!

public class App {

     static String[][][] Faces = new String[6][3][3];
    public static void main(String[] args){
        for (int i = 0; i < Faces.length; i++) {
            for (int j = 0; j < Faces[i].length; j++) {
                for (int k = 0; k < Faces[i][j].length; k++){
                    System.out.print(Faces[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
