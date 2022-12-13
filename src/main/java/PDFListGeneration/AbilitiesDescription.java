package PDFListGeneration;

import Enums.CharInfo;
import Tools.ToolField;


public class AbilitiesDescription {
    public static byte[] addDescription(CharInfo setInfo) {
        var name = ToolField.FeaturesAndTraits;
        StringBuilder description = new StringBuilder();
        var tool = setInfo.GetStringField(name);
        while (!tool.IsOver()) {
            description.append(tool.GetCurrent().getName().toUpperCase()).append(":").append("\n");
            description.append(tool.GetCurrent().getDescription()).append("\n");
            tool.Next();
        }
        return String.valueOf(description).getBytes();
    }
}
