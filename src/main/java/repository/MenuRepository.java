package repository;

import domain.Category;
import domain.Menu;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MenuRepository {
    private static final List<Menu> menus = new ArrayList<>();

    static {
        menus.add(new Menu(1, "후라이드", Category.CHICKEN, 16_000));
        menus.add(new Menu(2, "양념치킨", Category.CHICKEN, 16_000));
        menus.add(new Menu(3, "반반치킨", Category.CHICKEN, 16_000));
        menus.add(new Menu(4, "통구이", Category.CHICKEN, 16_000));
        menus.add(new Menu(5, "간장치킨", Category.CHICKEN, 17_000));
        menus.add(new Menu(6, "순살치킨", Category.CHICKEN, 17_000));
        menus.add(new Menu(21, "콜라", Category.BEVERAGE, 1_000));
        menus.add(new Menu(22, "사이다", Category.BEVERAGE, 1_000));
    }

    public static Menu selectMenu(int menuNumber) {
        return menus.stream()
                .filter(menu -> menu.isEqualMenuNumber(menuNumber))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("일치하는 메뉴가 없습니다."));
    }

    public static List<Menu> menus() {
        return Collections.unmodifiableList(menus);
    }
}
