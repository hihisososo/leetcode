package leetcode.year_2022.september;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateFileInSystem {
    public static void main(String[] args) {
        System.out.println(new FindDuplicateFileInSystem().findDuplicate(new String[]{"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"}));
        System.out.println(new FindDuplicateFileInSystem().findDuplicate(new String[]{"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)"}));
    }

    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> contentMap = new LinkedHashMap<>();
        for (int i = 0; i < paths.length; i++) {
            String[] pathSplit = paths[i].split(" ");
            String path = pathSplit[0];
            for (int j = 1; j < pathSplit.length; j++) {
                String fileNameAndCont = pathSplit[j];
                String fileName = fileNameAndCont.substring(0, fileNameAndCont.indexOf("("));
                String fileContent = fileNameAndCont.substring(fileNameAndCont.indexOf("("), fileNameAndCont.lastIndexOf(")"));
                contentMap.putIfAbsent(fileContent, new ArrayList<>());
                contentMap.get(fileContent).add(path + "/" + fileName);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, List<String>> map : contentMap.entrySet()) {
            if (map.getValue().size() > 1) {
                result.add(map.getValue());
            }
        }
        return result;
    }
}
