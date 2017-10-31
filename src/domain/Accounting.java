package domain;

class Accounting {
    /*
    Неиспольуемые поля, но пока что их значения нам не нужны, мы их просто сохраняем,
    но потом можно будет узнать что в них содержится, иначе не нужна была бы коллекция содержащая эти данные
     */
    private String ds;
    private String de;
    private String vol;

    Accounting(String ds, String de, String vol) {
        this.ds = ds;
        this.de = de;
        this.vol = vol;
    }

}
