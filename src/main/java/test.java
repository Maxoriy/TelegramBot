public class test {
    public static void main(String[] args) {
        DataStorage InfaSeeker=new TestDataStorage();
        String race="Голиаф";
        String clss="Варвар";
        String backsrty="Беспризорник";
        CharInfo grog=new CharInfo(race,clss,backsrty);
        grog.Inventory=InfaSeeker.getItemList(grog.InputRace,grog.InputClass,grog.InputBackstory);
        grog.Abilities=InfaSeeker.getAbilityList(grog.InputRace,grog.InputClass,grog.InputBackstory,0);
        grog.SkillAndSaveProficiency=InfaSeeker.getProficiencies(grog.InputRace,grog.InputClass,grog.InputBackstory);
        System.out.println("program ended");

    }
}
