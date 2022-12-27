package oop_dz_2_v2;

public class Hall_common {
    final String type; // тип заказа (срочный или предварительный) //
    final String day; // день недели (согласно афишы) //
    final String film; // фильм (согласно афишы) //
    final String session; // сеанс (согласно афишы) //
    private double Ks; // коэффициент стоимости сеанса //

    // Прайс //

    final double zakaz_urgent = 5.2; // стоимость срочного заказа в $ //
    final double zakaz_preliminary = 10.1; // стоимость предварительного заказа в $ //
    final double Kses10 = 0.9; // коэффициент стоимости сеанса на 10:00 //
    final double Kses14 = 1.0; // коэффициент стоимости сеанса на 14:00 //
    final double Kses18 = 1.5; // коэффициент стоимости сеанса на 18:00 //
    final double Kses22 = 2.0; // коэффициент стоимости сеанса на 22:00 //
    final double Koz = 1.0; // коэффициент стоимости основного зала //


    public Hall_common(String type, String day, String film, String session) {
        super();
        this.type = type;
        this.day = day;
        this.film = film;
        this.session = session;
    }

    public void fix_row_place (String t, String s) {
        String hall = "Основной";
        KartsHalls kh = new KartsHalls(type);
        kh.osn(type);
        kh.checks_row_place_osn(type);
        switch (s) {
            case "10:00":
                Ks = Kses10;
                break;
            case "14:00":
                Ks = Kses14;
                break;
            case "18:00":
                Ks = Kses18;
                break;
            case "22:00":
                Ks = Kses22;
                break;
        }
        if (type.equals("Срочный")) {
            System.out.println("Оформлен Заказ " + type + " на просмотр фильма в Зале " + hall +
                    " (согласно афишы): День " + day + "; Фильм " + film + "; Время начала сеанса " + session +
                    "; Ряд " + kh.getRow() + "; " + "Место " + kh.getPlace() + "." +
                    " Дополнительный сервис не предусмотрен. Итоговая сумма к оплате: "
                    + ((Math.ceil((zakaz_urgent * Ks * Koz) * 100)) / 100) + "$.");
        } else {
            System.out.println("Оформлен Заказ " + type + " на просмотр фильма в Зале " + hall +
                    " (согласно афишы): День " + day + "; Фильм " + film + "; Время начала сеанса " + session +
                    "; Ряд " + kh.getRow() + "; " + "Место " + kh.getPlace() + "." +
                    " Дополнительный сервис не предусмотрен. Итоговая сумма к оплате: "
                    + ((Math.ceil((zakaz_preliminary * Ks * Koz) *100)) / 100) + "$.");
        }
    }
}
