package com.example.whatnow.Evento;

class EventInfo {
    private String name;
    private String dateStart;
    private String dateEnd;
    private String description;

    public EventInfo(String name, String dateStart, String dateEnd,String description) {
        this.name = name;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.description = description;

    }

    public String getName() {
        return name;
    }

    public String getDateStart() {
        return dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
