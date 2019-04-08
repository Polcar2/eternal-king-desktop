package gamefx.models;

import gamefx.Controller;

public class Names {

    private static String[] NAMES_KING = new String[] {
            "Карл Великий",
            "Рудольф Бесстрашный",
            "Николай Свирепый",
            "Иван Грозный",
            "Джордж Линдерг",
            "Эван Конинберг",
            "Мария Искусительница",
            "Анастасия Превосходящая",
            "Роберт Патрик Граймс",
            "Повелитель семи стезей",
            "Король грозной ночи",
            "Царь семи колец",
            "Пелин"
    };

    private static String[] NAMES_KINGDOM = new String[] {
            "Царьград",
            "Неополис",
            "Новгород",
            "Фьючеполис",
            "Королевство Линдерг",
            "Княжество Державское",
            "Королевство Вирмантия",
            "Полкария",
            "Княжество Палтия",
            "Тотенхейм",
            "Ибрамиэль",
            "Царство Лимиэля",
            "Мизантия",
            "Меттинское герцогство",
            "Тим",
            "Замок Ривиэля",
    };

    private static String[] NAMES_DINASTY = new String[] {
            "Цесаревич",
            "Окамышевых",
            "Романовых",
            "Линдберг",
            "Конинберг",
            "Риствиэль",
            "Тотенхейм",
            "Вирмантия",
            "Имбрамиэль",
            "Волоконных",
            "истинных Ривиэля",
    };

    public static String getKing() {
        int rand = Controller.rnd(0,NAMES_KING.length-1);
        return NAMES_KING[rand];
    }

    public static String getKingdom() {
        int rand = Controller.rnd(0,NAMES_KINGDOM.length-1);
        return NAMES_KINGDOM[rand];
    }

    public static String getDinasty() {
        int rand = Controller.rnd(0,NAMES_DINASTY.length-1);
        return NAMES_DINASTY[rand];
    }

}
