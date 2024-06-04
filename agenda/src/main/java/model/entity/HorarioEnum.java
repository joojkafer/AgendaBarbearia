package model.entity;

public enum HorarioEnum {
    NOVE_HORAS("09:00:00"),
    DEZ_HORAS("10:00:00"),
    ONZE_HORAS("11:00:00"),
    DOZE_HORAS("12:00:00"),
    TREZE_HORAS("13:00:00"),
    QUATORZE_HORAS("14:00:00"),
    QUINZE_HORAS("15:00:00"),
    DEZESSEIS_HORAS("16:00:00"),
    DEZESSETE_HORAS("17:00:00");

    private String horario;

    HorarioEnum(String horario) {
        this.horario = horario;
    }

    public String getHorario() {
        return horario;
    }
}
