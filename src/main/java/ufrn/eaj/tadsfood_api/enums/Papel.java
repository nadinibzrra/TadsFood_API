package ufrn.eaj.tadsfood_api.enums;

public enum Papel {
    USUARIO("usuario"), ADMINISTRADOR("administrador"), SUPER("super");

    private String nome;

    Papel(String nome){
        this.nome = nome;
    }
}
