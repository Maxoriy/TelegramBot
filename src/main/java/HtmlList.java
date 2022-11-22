import java.io.*;

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
        for (Element link : links) {
            String stringLink = String.valueOf(link);
            if (stringLink.contains(word)) {
                var needString = link.select("textarea").first();
                StringBuilder skillValue = new StringBuilder();
                while (!test.IsOver()) {
                    skillValue.append(test.GetCurrent().getName()).append(' ');
                    test.Next();
                }
                needString.text(String.valueOf(skillValue));
                fileContent.replace(fileContent.indexOf(stringLink), fileContent.indexOf(stringLink) + stringLink.length(), String.valueOf(needString));

            }
        }
    }

    public static byte[] listGeneration(CharInfo setInfo) {
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
            for (MajorCharacteristic en : MajorCharacteristic.values()) {
                String skill = String.valueOf(en);
                String skillValue = String.valueOf(setInfo.GetMajorCharacteristic(en));
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
            var test2 = setInfo.GetStringField(ToolField.Equipment);
            iterReplacing(fileContent, links, test2, "Equipment");
            var test3 = setInfo.GetStringField(ToolField.FeaturesAndTraits);
            iterReplacing(fileContent, links, test3, "FeaturesAndTraits");

            return String.valueOf(fileContent).getBytes();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

