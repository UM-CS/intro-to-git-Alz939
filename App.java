//Great!

public class App {

    static String[][][] Faces = {
        {
            {"w","w","w"},
            {"w","w","w"},
            {"w","w","w"},
        },
        {
            {"r","r","r"},
            {"r","r","r"},
            {"r","r","r"},
        },
        {
            {"b","b","b"},
            {"b","b","b"},
            {"b","b","b"},
        },
        {
            {"o","o","o"},
            {"o","o","o"},
            {"o","o","o"},
        },
        {
            {"g","g","g"},
            {"g","g","g"},
            {"g","g","g"},
        },
        {
            {"y","y","y"},
            {"y","y","y"},
            {"y","y","y"},
        },
    };
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
