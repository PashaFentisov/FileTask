import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        DAOStatistic daoStatistic = new DAOStatisticJDBC();
        File file = new File("D:\\idea project\\Task1\\src\\main\\resources\\file1.txt");
        String line;
        List<String> listOfWords;
        List<Statistic> listOfStat = new ArrayList<>();
        double averageWordLength;
        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            while(reader.ready()){
                line = reader.readLine();
                listOfWords = Arrays.stream(line.split(" ")).sorted((s, s2)->s2.length()-s.length()).collect(Collectors.toList());
                averageWordLength = listOfWords.stream().mapToInt(String::length).average().getAsDouble();
                listOfStat.add(new Statistic(listOfWords.get(0), listOfWords.get(listOfWords.size()-1), line.length(), averageWordLength));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        daoStatistic.insertList(listOfStat);
    }
}
