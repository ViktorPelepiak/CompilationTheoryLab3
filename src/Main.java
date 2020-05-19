import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Main {
    private static List<String> text;


    public static void main(String[] args) {
        text = new LinkedList<>();

        int[][] table = new int[][]{
                {-6,  1, -6, -6, -6,  5, -6, -6},
                {-6, -6, -6, -6, -6,  2, -6, -6},
                {-1, -1, -1, -1, -1,  3, -1, -1},
                {-2, -2, -2, -2,  4, -2, -2, -2},
                {-3, -3, -3, -3, -3, -3, -3, -3},
                {-6, -6, -6, -6,  9, -6,  6, -6},
                { 7, -6, -6, -6, -6, -6, -6, -6},
                {-6, -6, -6, -6,  8, -6, -6, -6},
                {-4, -4, -4, -4, -4, -4, -4, -4},
                {-6, -6, -6, 10, -6, -6, -6, -6},
                {-6, -6, 11, -6, -6, -6, -6, -6},
                {-6, -6, -6, -6, 12, -6, -6, -6},
                {13, -6, -6, -6, -6, -6, -6, -6},
                {-5, -5, -5, -5, -5, -5, -5, -5}
        };

        try {
            File file = new File("D:\\MyLabs\\CompilationTheory\\Lab3\\CompilationTheoryLab3\\src\\input.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();

            while (line != null) {
                text.add(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        int i;
        int currentState;
        SymbolClass sc;

        try (FileWriter writer = new FileWriter("D:\\MyLabs\\CompilationTheory\\Lab3\\CompilationTheoryLab3\\src\\output.txt", false)) {

            for (String str : text) {
                i = 0;
                currentState = 0;

                while (i <= str.length()){
                    try {
                        sc = SymbolClass.getSymbolClass(str.charAt(i));
                    }catch (StringIndexOutOfBoundsException endOfLine){
                        sc = SymbolClass.OTHER;
                    }
                    int nextState = table[currentState][sc.getI()];
                    switch (nextState){
                        case (-1) : {
                            writer.write("< keyword, go >\n");
                            currentState = 0;
                            break;
                        }
                        case (-2) : {
                            writer.write("< keyword, go >\n");
                            currentState = 0;
                            i--;
                            break;
                        }
                        case (-3) : {
                            writer.write("< keyword, goon >\n");
                            currentState = 0;
                            break;
                        }
                        case (-4) : {
                            writer.write("< keyword, open >\n");
                            currentState = 0;
                            break;
                        }
                        case (-5) : {
                            writer.write("< keyword, online >\n");
                            currentState = 0;
                            break;
                        }
                        case (-6) : {
                            currentState = 0;
                            i++;
                            break;
                        }
                        default : {
                            i++;
                            currentState = nextState;
                        }
                    }
                }
            }

            writer.flush();
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }


    }
}

