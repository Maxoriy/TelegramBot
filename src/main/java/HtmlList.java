import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import interfaces.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HtmlList {
    public static void replacing(StringBuilder fileContent, Elements links, String skill, String skillValue) {
        for (Element link : links) {
            String stringLink = String.valueOf(link);
            if (stringLink.contains(skill)) {
                if (stringLink.contains("placeholder")) {
                    Elements needString = link.select("input");
                    needString.attr("value", skillValue);
                    String result = String.valueOf(needString);
                    fileContent.replace(fileContent.indexOf(stringLink), fileContent.indexOf(stringLink) + stringLink.length(), result);
                }
            }
        }

    }

    public static void iterReplacing(StringBuilder fileContent, Elements links, ToolIterator test, String word) {
        System.out.println(1);
        for (Element link : links) {
            String stringLink = String.valueOf(link);
            if (stringLink.contains(word)) {
                if (stringLink.contains("placeholder")) {

                    var curr_tul = test.GetCurrent();
                    Elements needString = link.select("textarea");
                    StringBuilder skillValue = new StringBuilder();
                    while (!test.IsOver()) {
                        skillValue.append(curr_tul.getName()).append(' ');
                        test.Next();
                    }
                    needString.attr("value", String.valueOf(skillValue));
                    test.RestartIteration();
                    String result = String.valueOf(needString);
                    fileContent.replace(fileContent.indexOf(stringLink), fileContent.indexOf(stringLink) + stringLink.length(), result);
                }
            }
        }
    }

    public static void testSomething(CharInfo setInfo) {
        try (FileReader reader = new FileReader("C:\\Users\\Максим\\Desktop\\TGBot\\src\\main\\java\\CharacterList.html")) {
            int c;
            StringBuilder fileContent = new StringBuilder();
            while ((c = reader.read()) != -1) {

                fileContent.append((char) c);
            }
            Document document = Jsoup.parse(fileContent.toString());
            Elements links = document.getElementsByAttribute("name");
            for (StatsEnum en : StatsEnum.values()) {
                String skill = String.valueOf(en);
                String skillValue = String.valueOf(setInfo.GetMajorStatVal(en));
                replacing(fileContent, links, skill, skillValue);
            }
            for (SkillsEnum en : SkillsEnum.values()) {
                String skill = String.valueOf(en);
                String skillValue = String.valueOf(setInfo.GetSkillVal(en));
                replacing(fileContent, links, skill, skillValue);
            }
            for (StatsEnum en : StatsEnum.values()) {
                String skill = String.valueOf(en) + "-save";
                String skillValue = String.valueOf(setInfo.GetSavingThrows(en));
                replacing(fileContent, links, skill, skillValue);
            }
            String cls = String.valueOf(setInfo.GetMajorCharacteristic(MajorCharacteristic.valueOf("ClassName")));
            StringBuilder sth = new StringBuilder("");
            for (MajorCharacteristics en : MajorCharacteristics.values()) {
                String skill = String.valueOf(en);
                if (skill.contains("Level")) {
                    sth.append(setInfo.GetMajorCharacteristics(en)).append("d");
                }
                String skillValue;
                if (skill.contains("HitDice")) {
                    skillValue = String.valueOf(sth.append(setInfo.GetMajorCharacteristics(en)));
                } else {
                    if (skill.contains("Level")) {
                        skillValue = cls + ' ' + String.valueOf(setInfo.GetMajorCharacteristics(en));
                    } else {
                        skillValue = String.valueOf(setInfo.GetMajorCharacteristics(en));
                    }
                }
                replacing(fileContent, links, skill, skillValue);
            }

            var test1 = setInfo.GetStringField(ToolField.OtherProfAndLanguages);
            iterReplacing(fileContent, links, test1, "OtherProfAndLanguages");
//            var test2 = setInfo.GetStringField(ToolField.Equipment);
//            iterReplacing(fileContent, links, test2, "Equipment");
//            var test3 = setInfo.GetStringField(ToolField.FeaturesAndTraits);
//            iterReplacing(fileContent, links, test3, "FeaturesAndTraits");

            //return String.valueOf(fileContent).getBytes(StandardCharsets.UTF_8);
            try (FileWriter writer = new FileWriter("test.html", false)) {
                writer.write(String.valueOf(fileContent));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {
        Test data = new Test();
        testSomething(data);
    }
}

