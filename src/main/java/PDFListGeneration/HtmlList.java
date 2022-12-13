package PDFListGeneration;

import java.io.*;

import Enums.*;
import Tools.ToolField;
import Tools.ToolIterator;
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
                    if (stringLink.contains("mod")) {
                        var value = (Integer.parseInt(skillValue) - 10) / 2;
                        needString.attr("value", String.valueOf(value));
                    } else {
                        needString.attr("value", skillValue);
                    }
                    String result = String.valueOf(needString);
                    fileContent.replace(fileContent.indexOf(stringLink), fileContent.indexOf(stringLink) + stringLink.length(), result);
                }
            }
        }

    }

    public static void iterReplacing(StringBuilder fileContent, Elements links, ToolIterator tool, String word) {
        for (Element link : links) {
            String stringLink = String.valueOf(link);
            if (stringLink.contains(word)) {
                var needString = link.select("textarea").first();
                StringBuilder skillValue = new StringBuilder();
                while (!tool.IsOver()) {
                    skillValue.append(tool.GetCurrent().getName()).append('\n');
                    tool.Next();
                }
                tool.RestartIteration();
                needString.text(String.valueOf(skillValue));
                fileContent.replace(fileContent.indexOf(stringLink), fileContent.indexOf(stringLink) + stringLink.length(), String.valueOf(needString));

            }
        }
    }

    public static byte[] listGeneration(CharInfo setInfo) {
        try (FileReader reader = new FileReader("src/main/java/PDFListGeneration/CharacterList.html")) {
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
            for (Names en : Names.values()) {
                String skill = String.valueOf(en);
                String skillValue = String.valueOf(setInfo.GetNames(en));
                replacing(fileContent, links, skill, skillValue);
            }
            String cls = String.valueOf(setInfo.GetNames(Names.valueOf("ClassName")));

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

            for (ToolField en : ToolField.values()) {
                iterReplacing(fileContent, links, setInfo.GetStringField(en), String.valueOf(en));
            }

            return String.valueOf(fileContent).getBytes();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

